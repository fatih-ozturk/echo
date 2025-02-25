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
package echo.app.account.implementation.datasource.remote

import arrow.core.Either
import echo.app.network.Mastodon
import echo.app.network.api.AccountApi
import echo.app.network.model.account.AccountResponse
import echo.app.network.utils.ApiError
import javax.inject.Inject

class AccountRemoteDataSourceImpl @Inject constructor(
    private val mastodon: Mastodon
) : AccountRemoteDataSource {

    private val accountApi: AccountApi
        get() = mastodon.accountApi

    override suspend fun verifyAccountCredentials(
        domain: String,
        accessToken: String
    ): Either<ApiError, AccountResponse> {
        return accountApi.verifyAccountCredentials(
            domain = domain,
            accessToken = accessToken
        )
    }

    override suspend fun getAccount(accountId: String): Either<ApiError, AccountResponse> {
        return accountApi.getAccount(accountId)
    }
}
