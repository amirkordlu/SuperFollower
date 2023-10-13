package com.amk.superfollower.ui.features

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amk.superfollower.model.data.ItemsListResponse
import com.amk.superfollower.ui.theme.SuperFollowerTheme
import com.amk.superfollower.ui.theme.Typography
import com.amk.superfollower.ui.theme.Yellow
import dev.burnoo.cokoin.navigation.getNavViewModel

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
    val viewModel = getNavViewModel<MainScreenViewModel>()
    viewModel.getAllItemsList()

    Log.v("3636test", viewModel.allItemsList.value.toString())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ServicesList(viewModel.allItemsList.value)
    }
}


@Composable
fun ServicesList(services: List<ItemsListResponse>) {
    LazyColumn(
        modifier = Modifier.padding(top = 2.dp, bottom = 10.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        items(services.size) {
            ItemCard(services[it])
        }
    }
}

@Composable
fun ItemCard(response: ItemsListResponse) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(236.dp)
            .padding(top = 12.dp, start = 32.dp, end = 32.dp, bottom = 22.dp),
        shape = RoundedCornerShape(24.dp),
        color = Yellow,
        border = BorderStroke(0.5.dp, Color.White.copy(alpha = 0.70f))
    ) {

        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = response.name)

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = "category: " + response.category)

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(text = response.rate.toString() + "  Toman")
        }

    }
}