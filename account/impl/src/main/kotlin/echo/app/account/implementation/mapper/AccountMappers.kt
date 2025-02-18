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
package echo.app.account.implementation.mapper

import echo.app.account.api.model.Session
import echo.app.account.implementation.entity.AccountEntity
import echo.app.account.implementation.entity.SessionEntity
import echo.app.domain.model.Account
import echo.app.network.model.account.AccountResponse
import echo.app.securitycrypto.api.KeyStoreCryptoManager

fun AccountEntity.toDomainModel() = Account(
    accountId = userId,
    username = username
)

fun SessionEntity.toDomainModel(keyStoreCryptoManager: KeyStoreCryptoManager) = Session(
    accessToken = keyStoreCryptoManager.decrypt(accessToken),
    domain = domain
)


fun AccountResponse.toDataModel(): Account = Account(accountId = id, username = username)
