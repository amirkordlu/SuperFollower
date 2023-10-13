package com.amk.superfollower.ui.features

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toolbar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amk.superfollower.R
import com.amk.superfollower.model.data.ItemsListResponse
import com.amk.superfollower.ui.theme.SuperFollowerTheme
import com.amk.superfollower.ui.theme.Typography
import com.amk.superfollower.ui.theme.Yellow
import com.amk.superfollower.util.items
import dev.burnoo.cokoin.navigation.getNavViewModel

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    SuperFollowerTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MainToolbar()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val viewModel = getNavViewModel<MainScreenViewModel>()
    viewModel.getAllItemsList()

    Log.v("3636test", viewModel.allItemsList.value.toString())


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { MainToolbar() },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp, 24.dp, 0.dp, 0.dp)),
                containerColor = Color.White, tonalElevation = 14.dp
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            // navigation.navigate(screen)
                        },
                        alwaysShowLabel = false,
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding()
                )
        ) {
            ServicesList(viewModel.allItemsList.value)
        }
    }

}

@Composable
fun MainToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "ورود / ثبت نام", style = Typography.bodySmall)
        }

        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(40.dp)
            )
        }

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