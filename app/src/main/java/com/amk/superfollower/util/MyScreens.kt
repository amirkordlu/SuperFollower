package com.amk.superfollower.util

sealed class MyScreens(val route: String) {
    object MainScreen : MyScreens("mainScreen")
    object LoginScreen : MyScreens("loginScreen")
}
