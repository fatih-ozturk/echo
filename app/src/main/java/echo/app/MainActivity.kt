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
package echo.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import dagger.hilt.android.AndroidEntryPoint
import echo.app.authentication.presentation.login.LoginRoute
import echo.app.authentication.presentation.login.loginRoute
import echo.app.authentication.presentation.login.navigateToLogin
import echo.app.chroma.tokens.ChromaTheme
import echo.app.home.presentation.homeRoute
import echo.app.home.presentation.navigateToHome
import echo.app.splash.presentation.navigation.SplashRoute
import echo.app.splash.presentation.navigation.splashRoute
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var shouldShowSplashScreen = true
        installSplashScreen().setKeepOnScreenCondition {
            shouldShowSplashScreen
        }
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            ChromaTheme {
                EchoApp(
                    navController = navController,
                    hideSplashScreen = {
                        shouldShowSplashScreen = false
                    }
                )
            }
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
fun EchoApp(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    hideSplashScreen: () -> Unit
) {
    LaunchedEffect(Unit) { // TODO delete
        navController.currentBackStack
            .onEach { currentBackStack ->
                val backStack =
                    currentBackStack
                        .mapNotNull { it.destination.route }
                Timber.tag("EchoApp currentBackStack").e(backStack.toString())
            }.collect()
    }

    Scaffold(
        modifier = modifier,
        contentColor = ChromaTheme.colors.fgPrimary,
    ) { padding ->
        EchoNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding),
            navController = navController,
            hideSplashScreen = hideSplashScreen,
        )
    }
}

@Composable
fun EchoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    hideSplashScreen: () -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SplashRoute,
    ) {
        splashRoute(
            onNavigateToHome = {
                navController.navigateToHome(
                    navOptions = navOptions {
                        popUpTo(SplashRoute) {
                            inclusive = true
                        }
                    }
                )
                hideSplashScreen()
            },
            onNavigateToLogin = {
                navController.navigateToLogin(
                    navOptions = navOptions {
                        popUpTo(SplashRoute) {
                            inclusive = true
                        }
                    }
                )
                hideSplashScreen()
            }
        )
        loginRoute(
            navigateToHome = {
                navController.navigateToHome(
                    navOptions = navOptions {
                        popUpTo(LoginRoute) {
                            inclusive = true
                        }
                    }
                )
            }
        )
        homeRoute()
    }
}
