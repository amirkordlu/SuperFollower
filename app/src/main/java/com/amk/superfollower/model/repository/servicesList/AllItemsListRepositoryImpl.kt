package com.amk.superfollower.model.repository.servicesList

import com.amk.superfollower.model.data.ItemsListResponse
import com.amk.superfollower.model.net.ApiService

class AllItemsListRepositoryImpl(private val apiService: ApiService) : AllItemsListRepository {
    override suspend fun getAllItemsList(): List<ItemsListResponse> {
        return apiService.getAllItems()
    }

}