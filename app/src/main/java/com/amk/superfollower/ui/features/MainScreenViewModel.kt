package com.amk.superfollower.ui.features

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amk.superfollower.model.data.ItemsListResponse
import com.amk.superfollower.model.repository.servicesList.AllItemsListRepository
import com.amk.superfollower.util.coroutineExceptionHandler
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val allServicesList: AllItemsListRepository
) : ViewModel() {

    val allItemsList = mutableStateOf<List<ItemsListResponse>>(listOf())

    fun getAllItemsList() {
        viewModelScope.launch(coroutineExceptionHandler) {
            val data = allServicesList.getAllItemsList()
            allItemsList.value = data
        }
    }

}