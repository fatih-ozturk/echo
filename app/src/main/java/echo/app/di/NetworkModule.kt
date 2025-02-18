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
package echo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import echo.app.account.api.SessionRepository
import echo.app.appconfig.api.AppConfig
import echo.app.network.Mastodon
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    internal fun provideMastodon(
        sessionRepository: SessionRepository,
        appConfig: AppConfig
    ): Mastodon {
        return Mastodon {
            userAuthentication {
                loadDomain {
                    sessionRepository.getPrimarySession().getOrNull()?.domain
                }
                loadAccessToken {
                    sessionRepository.getPrimarySession().getOrNull()?.accessToken
                }
            }
            httpClientConfig {
                if (appConfig.isDebug) {
                    install(Logging) {
                        logger = object : Logger {
                            override fun log(message: String) {
                                Timber.i(message)
                            }
                        }
                        level = LogLevel.ALL
                    }
                }
            }
        }
    }
}
