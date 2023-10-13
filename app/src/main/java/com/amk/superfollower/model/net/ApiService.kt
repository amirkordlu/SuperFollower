package com.amk.superfollower.model.net

import com.amk.superfollower.model.data.ItemsListResponse
import com.amk.superfollower.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/v2/")
    suspend fun getAllItems(
        @Query("key") key: String = "zvbRWMTKoIn1ee4hTJn912UfBLFyJqZP",
        @Query("action") action: String = "services"
    ): List<ItemsListResponse>

}

fun createApiService(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}