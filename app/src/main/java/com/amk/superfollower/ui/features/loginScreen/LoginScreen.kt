package com.amk.superfollower.ui.features.loginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amk.superfollower.ui.theme.SuperFollowerTheme
import com.amk.superfollower.ui.theme.Typography
import com.amk.superfollower.util.MyScreens
import dev.burnoo.cokoin.navigation.getNavController

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    SuperFollowerTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LoginScreen()
        }
    }
}


@Composable
fun LoginScreen() {
    val navigation = getNavController()

    Column(modifier = Modifier.fillMaxSize()) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.67f),
            color = Color(0xFFCFD8DC)
        ) {

            TextButton(modifier = Modifier.size(38.dp, 18.dp),
                onClick = { }
            ) {
                Text(
                    text = "فعلا نه",
                    style = Typography.bodySmall,
                    color = Color(0xFF616161)
                )
            }
        }

        LoginSection { navigation.navigate(MyScreens.SignUpScreen.route) }

        Divider(
            color = Color(0xFFEEEEEE), thickness = 1.5.dp, modifier = Modifier.padding(
                start = 20.dp, top = 16.dp, bottom = 14.dp, end = 20.dp
            )
        )

        SignUpSection()


    }
}

@Composable
fun LoginSection(signUp: () -> Unit) {
    Column {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 60.dp)
                .height(48.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "ورود",
                style = Typography.bodyMedium,
                color = Color(0xFF424242)
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(48.dp),
            onClick = { signUp.invoke() },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF7E84F9))
        ) {
            Text(
                text = "آلایی نیستی؟ ثبت نام کن",
                style = Typography.bodyMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun SignUpSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextButton(onClick = { }) {
            Text(
                text = "ثبت نام کنید",
                style = Typography.bodySmall,
                color = Color(0xFF009688),
                textAlign = TextAlign.End
            )
        }

        Text(text = "هنوز ثبت نام نکرده اید؟", style = Typography.bodySmall)

    }
}