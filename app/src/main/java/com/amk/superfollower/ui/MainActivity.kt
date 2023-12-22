package com.amk.superfollower.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amk.superfollower.di.myModules
import com.amk.superfollower.ui.features.itemDetailsScreen.ItemDetailsScreen
import com.amk.superfollower.ui.features.loginScreen.LoginScreen
import com.amk.superfollower.ui.features.mainScreen.MainScreen
import com.amk.superfollower.ui.features.signupScreen.SignUpScreen
import com.amk.superfollower.ui.theme.SuperFollowerTheme
import com.amk.superfollower.util.MyScreens
import dev.burnoo.cokoin.Koin
import dev.burnoo.cokoin.navigation.KoinNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Koin(appDeclaration = { modules(myModules) }) {
                SuperFollowerTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        SuperFollowerUI()
                    }
                }
            }
        }
    }
}

@Composable
fun SuperFollowerUI() {
    val navController = rememberNavController()
    KoinNavHost(
        navController = navController,
        startDestination = MyScreens.MainScreen.route
    ) {

        composable(MyScreens.MainScreen.route) {
            MainScreen()
        }

        composable(MyScreens.LoginScreen.route) {
            LoginScreen()
        }

        composable(MyScreens.SignUpScreen.route) {
            SignUpScreen()
        }

        composable(MyScreens.ItemDetailsScreen.route) {
            ItemDetailsScreen()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperFollowerTheme {
        SuperFollowerUI()
    }
}