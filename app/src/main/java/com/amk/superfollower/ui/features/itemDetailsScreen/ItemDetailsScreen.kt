package com.amk.superfollower.ui.features.itemDetailsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amk.superfollower.ui.theme.PurpleGrey80
import com.amk.superfollower.ui.theme.SuperFollowerTheme
import com.amk.superfollower.ui.theme.Typography
import com.amk.superfollower.ui.theme.textFieldStyle

@Preview(showBackground = true)
@Composable
fun ItemDetailsScreenPreview() {
    SuperFollowerTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ItemDetailsScreen()
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailsScreen() {
    var textFieldValue = mutableStateOf("")

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { DetailsToolbar() }
    ) {
        Column(
            modifier = Modifier.padding(
                top = it.calculateTopPadding()
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "لایک اینستاگرام برنزی",
                style = Typography.bodyMedium
            )

            ItemDetailsCard()

            Text(
                text = ":حداقل",
                style = Typography.bodySmall
            )

            Text(
                text = ":حداکثر",
                style = Typography.bodySmall
            )

            Text(
                text = ":قیمت به ازای هزار",
                style = Typography.bodySmall
            )

            MainTextField(
                edtValue = textFieldValue.value,
                icon = Icons.Default.Info,
                hint = "لینک"
            ) { newtext ->
                textFieldValue.value = newtext
            }

            MainTextField(
                edtValue = textFieldValue.value,
                icon = Icons.Default.Info,
                hint = "تعداد"
            ) { newtext ->
                textFieldValue.value = newtext
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 28.dp)
                    .height(48.dp),
                onClick = { },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF7E84F9))
            ) {
                Text(
                    text = "ثبت سفارش",
                    style = Typography.bodyMedium,
                    color = Color.White
                )
            }

        }
    }


}

@Composable
fun DetailsToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailsCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(236.dp)
            .padding(top = 12.dp, start = 32.dp, end = 32.dp, bottom = 22.dp),
        shape = RoundedCornerShape(24.dp),
        color = PurpleGrey80,
        border = BorderStroke(0.5.dp, Color.White.copy(alpha = 0.70f)),
        onClick = { }
    ) {

        Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.End) {
            Text(text = "response.name", style = Typography.bodyMedium)

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "category: " + "response.category", style = Typography.bodySmall)

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "response.rate.toString()" + "", style = Typography.bodySmall)
        }

    }
}

@Composable
fun MainTextField(
    edtValue: String,
    icon: ImageVector,
    hint: String,
    onValueChanges: (String) -> Unit,
) {
    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = { Text(hint) },
        value = edtValue,
        singleLine = true,
        onValueChange = onValueChanges,
        placeholder = { Text(hint) },
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 12.dp),
        shape = RoundedCornerShape(14.dp),
        leadingIcon = { Icon(icon, null) },
        textStyle = textFieldStyle
    )
}