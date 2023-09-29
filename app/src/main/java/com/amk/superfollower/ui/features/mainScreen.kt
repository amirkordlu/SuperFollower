package com.amk.superfollower.ui.features

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amk.superfollower.ui.theme.SuperFollowerTheme

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    SuperFollowerTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {

}