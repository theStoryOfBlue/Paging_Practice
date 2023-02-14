package com.example.paging_practice

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 2023-02-14
 * pureum
 */
interface RetrofitSource {

    @GET("api/character/?page=19")
    suspend fun getData(
        @Query("page") page:Int
    ):Data

}