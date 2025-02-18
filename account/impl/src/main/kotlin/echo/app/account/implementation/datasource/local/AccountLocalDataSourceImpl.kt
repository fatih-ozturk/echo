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
package echo.app.account.implementation.datasource.local

import echo.app.account.implementation.dao.AccountDao
import echo.app.account.implementation.database.AccountDatabase
import echo.app.account.implementation.entity.AccountEntity
import javax.inject.Inject

class AccountLocalDataSourceImpl @Inject constructor(
    private val accountDatabase: AccountDatabase
) : AccountLocalDataSource {

    private val accountDao: AccountDao
        get() = accountDatabase.accountDao()

    override suspend fun upsert(accountEntity: AccountEntity) {
        accountDao.upsert(accountEntity)
    }

    override suspend fun update(accountEntity: AccountEntity) {
        accountDao.update(accountEntity)
    }

    override suspend fun addSession(userId: String, sessionId: String) {
        accountDao.addSession(userId, sessionId)
    }

    override suspend fun getPrimaryAccount(): AccountEntity? {
        return accountDao.getPrimaryAccount()
    }
}
