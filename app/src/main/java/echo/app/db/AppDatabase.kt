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
package echo.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.withTransaction
import echo.app.authmanager.data.db.AccountDatabase
import echo.app.authmanager.data.entity.AccountEntity
import echo.app.authmanager.data.entity.SessionEntity
import echo.app.data.BaseDatabase
import echo.app.data.CommonConverters

@Database(
    version = AppDatabase.APP_DATABASE_VERSION,
    exportSchema = true,
    entities = [
        AccountEntity::class,
        SessionEntity::class
    ]
)
@TypeConverters(
    CommonConverters::class
)
internal abstract class AppDatabase : RoomDatabase(),
    BaseDatabase,
    AccountDatabase {

    override suspend fun <R> inTransaction(block: suspend () -> R): R = withTransaction(block)

    companion object {
        fun buildDatabase(
            context: Context
        ): AppDatabase = databaseBuilder(
            context,
            AppDatabase::class.java,
            APP_DATABASE_NAME
        ).build()

        const val APP_DATABASE_NAME = "app_database"
        const val APP_DATABASE_VERSION = 1
    }
}
