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
package echo.app.core.database.converter

import echo.app.data.converter.CommonConverters
import io.kotest.matchers.shouldBe
import org.junit.Before
import org.junit.Test

class CommonConvertersTest {

    private lateinit var converters: CommonConverters

    @Before
    fun setUp() {
        converters = CommonConverters()
    }

    @Test
    fun `fromStringList should convert a list of strings to a single comma-separated string`() {
        val list = listOf("one", "two", "three")

        val result = converters.fromStringList(list)

        result shouldBe "one, two, three"
    }

    @Test
    fun `toStringList should convert a comma-separated string to a list of trimmed strings`() {
        val input = "one, two , three"

        val result = converters.toStringList(input)

        result shouldBe listOf("one", "two", "three")
    }

    @Test
    fun `fromStringList should handle an empty list`() {
        val result = converters.fromStringList(emptyList())

        result shouldBe ""
    }

    @Test
    fun `toStringList should handle an empty string`() {
        val result = converters.toStringList("")

        result shouldBe listOf("")
    }
}
