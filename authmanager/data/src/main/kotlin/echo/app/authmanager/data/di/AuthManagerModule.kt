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
package echo.app.authmanager.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import echo.app.authmanager.data.ds.local.AccountLocalDataSource
import echo.app.authmanager.data.ds.local.AccountLocalDataSourceImpl
import echo.app.authmanager.data.ds.local.SessionLocalDataSource
import echo.app.authmanager.data.ds.local.SessionLocalDataSourceImpl
import echo.app.authmanager.data.repository.AuthManagerImpl
import echo.app.authmanager.domain.AuthManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthManagerModule {

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
    abstract fun bindAccountRepository(
        authManagerImpl: AuthManagerImpl
    ): AuthManager
}
