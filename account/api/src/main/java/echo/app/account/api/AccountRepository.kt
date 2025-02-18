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
package echo.app.account.api

import arrow.core.Either
import echo.app.account.api.model.Session
import echo.app.domain.error.DataError
import echo.app.domain.model.Account

interface AccountRepository {
    suspend fun getAccount(accountId: String): Either<DataError.Remote, Account>
    suspend fun verifyAccountCredentials(
        domain: String,
        accessToken: String,
    ): Either<DataError.Remote, Account>
    suspend fun getPrimaryAccount(): Either<DataError.Local, Account?>
    suspend fun upsertAccountWithSession(
        account: Account,
        session: Session,
    ): Either<DataError.Local, Unit>
}
