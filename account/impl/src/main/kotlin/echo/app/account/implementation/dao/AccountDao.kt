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
package echo.app.account.implementation.dao

import androidx.room.Dao
import androidx.room.Query
import echo.app.account.implementation.entity.AccountEntity
import echo.app.data.dao.BaseDao

@Dao
abstract class AccountDao : BaseDao<AccountEntity>() {

    @Query("UPDATE AccountEntity SET sessionId = :sessionId WHERE userId = :userId")
    abstract suspend fun addSession(userId: String, sessionId: String)

    @Query("SELECT * FROM AccountEntity WHERE primaryAt = (SELECT MAX(primaryAt) FROM AccountEntity) LIMIT 1")
    abstract suspend fun getPrimaryAccount(): AccountEntity?
}
