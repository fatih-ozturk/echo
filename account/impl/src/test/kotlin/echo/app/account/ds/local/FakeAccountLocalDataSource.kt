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
package echo.app.account.ds.local

import echo.app.account.implementation.datasource.local.AccountLocalDataSource
import echo.app.account.implementation.entity.AccountEntity

class FakeAccountLocalDataSource : AccountLocalDataSource {

    private val accounts = mutableMapOf<String, AccountEntity>()

    override suspend fun upsert(accountEntity: AccountEntity) {
        accounts[accountEntity.userId] = accountEntity
    }

    override suspend fun update(accountEntity: AccountEntity) {
        accounts[accountEntity.userId]?.let {
            accounts[accountEntity.userId] = accountEntity
        }
    }

    override suspend fun addSession(userId: String, sessionId: String) {
        accounts[userId]?.let { existing ->
            accounts[userId] = existing.copy(sessionId = sessionId)
        }
    }

    override suspend fun getPrimaryAccount(): AccountEntity? {
        return accounts.values.maxByOrNull { it.primaryAt }
    }
}
