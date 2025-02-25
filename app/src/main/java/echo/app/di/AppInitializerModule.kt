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

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import echo.app.core.common.appinitializer.Initializer
import echo.app.initializer.TimberInitializer
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppInitializerModule {
    @Binds
    @IntoSet
    @Singleton
    abstract fun provideTimberInitializer(timberInitializer: TimberInitializer): Initializer
}
