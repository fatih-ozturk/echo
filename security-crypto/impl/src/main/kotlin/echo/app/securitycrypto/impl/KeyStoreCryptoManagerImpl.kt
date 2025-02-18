/*
 * Copyright 2025 Fatih OZTURK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package echo.app.securitycrypto.impl

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import echo.app.securitycrypto.api.KeyStoreCryptoManager
import java.security.KeyStore
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.inject.Inject

class KeyStoreCryptoManagerImpl @Inject constructor(
    private val keyAlias: String = DEFAULT_KEY_ALIAS,
    private val keySize: Int = DEFAULT_KEY_SIZE
) : KeyStoreCryptoManager {

    companion object {
        private const val TRANSFORMATION = "AES/GCM/NoPadding"
        private const val IV_LENGTH_BYTES = 12
        private const val TAG_LENGTH_BITS = 128
        private const val DEFAULT_KEY_ALIAS = "default_key_alias_echo"
        private const val DEFAULT_KEY_SIZE = 256
        private const val ANDROID_KEYSTORE = "AndroidKeyStore"
    }

    private val keyStore: KeyStore by lazy {
        KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }
    }

    override fun encrypt(plainText: String): String {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        val iv = generateSecureIv()
        val secretKey = getOrCreateKey()

        cipher.init(
            Cipher.ENCRYPT_MODE,
            secretKey,
            GCMParameterSpec(TAG_LENGTH_BITS, iv)
        )

        val encryptedBytes = cipher.doFinal(plainText.encodeToByteArray())
        return Base64.encodeToString(iv + encryptedBytes, Base64.NO_WRAP)
    }

    override fun decrypt(cipherText: String): String {
        val decodedBytes = Base64.decode(cipherText, Base64.NO_WRAP)
        require(decodedBytes.size > IV_LENGTH_BYTES)
        val iv = decodedBytes.copyOfRange(0, IV_LENGTH_BYTES)
        val encryptedData = decodedBytes.copyOfRange(IV_LENGTH_BYTES, decodedBytes.size)
        val secretKey = getOrCreateKey()

        val cipher = Cipher.getInstance(TRANSFORMATION).apply {
            init(
                Cipher.DECRYPT_MODE,
                secretKey,
                GCMParameterSpec(TAG_LENGTH_BITS, iv)
            )
        }

        return cipher.doFinal(encryptedData).decodeToString()
    }

    private fun getOrCreateKey(): SecretKey {
        return synchronized(this) {
            getExistingKey() ?: generateNewKey()
        }
    }

    private fun getExistingKey(): SecretKey? {
        return if (keyStore.containsAlias(keyAlias)) {
            (keyStore.getEntry(keyAlias, null) as KeyStore.SecretKeyEntry).secretKey
        } else {
            null
        }
    }

    private fun generateNewKey(): SecretKey {
        return KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE).apply {
            init(
                KeyGenParameterSpec.Builder(
                    keyAlias,
                    KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
                )
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .setKeySize(keySize)
                    .setRandomizedEncryptionRequired(false)
                    .build()
            )
        }.generateKey()
    }

    private fun generateSecureIv(): ByteArray {
        return ByteArray(IV_LENGTH_BYTES).apply {
            SecureRandom().nextBytes(this)
        }
    }
}
