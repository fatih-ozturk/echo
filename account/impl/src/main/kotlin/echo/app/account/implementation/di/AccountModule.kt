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
package echo.app.account.implementation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import echo.app.account.api.AccountRepository
import echo.app.account.api.SessionRepository
import echo.app.account.implementation.datasource.local.AccountLocalDataSource
import echo.app.account.implementation.datasource.local.AccountLocalDataSourceImpl
import echo.app.account.implementation.datasource.remote.AccountRemoteDataSource
import echo.app.account.implementation.datasource.remote.AccountRemoteDataSourceImpl
import echo.app.account.implementation.datasource.local.SessionLocalDataSource
import echo.app.account.implementation.datasource.local.SessionLocalDataSourceImpl
import echo.app.account.implementation.repository.AccountRepositoryImpl
import echo.app.account.implementation.repository.SessionRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AccountModule {

    @Binds
    @Singleton
    abstract fun bindAccountLocalDataSource(
        accountLocalDataSourceImpl: AccountLocalDataSourceImpl
    ): AccountLocalDataSource

    @Binds
    @Singleton
    abstract fun bindSessionLocalDataSource(
        sessionLocalDataSourceImpl: SessionLocalDataSourceImpl
    ): SessionLocalDataSource

    @Binds
    @Singleton
    abstract fun bindAccountRemoteDataSource(
        accountRemoteDataSourceImpl: AccountRemoteDataSourceImpl
    ): AccountRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsAccountRepository(
        accountRepositoryImpl: AccountRepositoryImpl
    ): AccountRepository

    @Binds
    @Singleton
    abstract fun bindsSessionRepository(
        sessionRepositoryImpl: SessionRepositoryImpl
    ): SessionRepository
}
