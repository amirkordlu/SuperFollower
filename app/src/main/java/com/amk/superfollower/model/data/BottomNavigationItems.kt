package com.amk.superfollower.model.data

import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavigationItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
