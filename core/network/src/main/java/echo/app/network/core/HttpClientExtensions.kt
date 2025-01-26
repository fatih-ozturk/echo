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
package echo.app.network.core

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put

internal suspend inline fun <reified T> HttpClient.getByPaths(
    vararg paths: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T = get(urlString = buildPaths(*paths), block = block).body()

internal suspend inline fun <reified T> HttpClient.getByPaths(
    paths: Collection<String>,
    block: HttpRequestBuilder.() -> Unit = {}
): T = get(urlString = buildPaths(paths), block = block).body()

internal suspend inline fun <reified T> HttpClient.postByPaths(
    vararg paths: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T = post(urlString = buildPaths(*paths), block = block).body()

internal suspend inline fun <reified T> HttpClient.postByPaths(
    paths: Collection<String>,
    block: HttpRequestBuilder.() -> Unit = {}
): T = post(urlString = buildPaths(paths), block = block).body()

internal suspend inline fun <reified T> HttpClient.deleteByPaths(
    vararg paths: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T = delete(urlString = buildPaths(*paths), block = block).body()

internal suspend inline fun <reified T> HttpClient.deleteByPaths(
    paths: Collection<String>,
    block: HttpRequestBuilder.() -> Unit = {}
): T = delete(urlString = buildPaths(paths), block = block).body()

internal suspend inline fun <reified T> HttpClient.putByPaths(
    vararg paths: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T = put(urlString = buildPaths(*paths), block = block).body()

private fun buildPaths(vararg paths: String): String = paths.joinToString(separator = "/")

private fun buildPaths(paths: Collection<String>): String = paths.joinToString(separator = "/")
