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
package echo.app.initializer

import echo.app.appconfig.api.AppConfig
import echo.app.core.common.appinitializer.Initializer
import javax.inject.Inject
import javax.inject.Singleton
import timber.log.Timber

@Singleton
class TimberInitializer @Inject constructor(
    private val appConfig: AppConfig,
) : Initializer {
    override fun init() {
        if (appConfig.isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
