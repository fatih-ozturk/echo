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
package echo.app.authentication.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import echo.app.authentication.data.ds.remote.AuthenticationRemoteDataSource
import echo.app.authentication.data.ds.remote.AuthenticationRemoteDataSourceImpl
import echo.app.authentication.data.repository.AuthRepositoryImpl
import echo.app.authentication.domain.repository.AuthRepository
import echo.app.authentication.domain.usecase.ValidateDomainUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthenticationModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindAuthenticationRemoteDataSource(
        applicationCredentialsRemoteDataSourceImpl: AuthenticationRemoteDataSourceImpl
    ): AuthenticationRemoteDataSource

    companion object {
        @Provides
        @Singleton
        fun provideValidateDomainUseCase() = ValidateDomainUseCase()
    }
}
