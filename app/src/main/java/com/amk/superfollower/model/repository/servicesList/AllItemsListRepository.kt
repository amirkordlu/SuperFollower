package com.amk.superfollower.model.repository.servicesList

import com.amk.superfollower.model.data.ItemsListResponse

interface AllItemsListRepository {
    suspend fun getAllItemsList(): List<ItemsListResponse>
}