package com.example.paging_practice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * 2023-02-14
 * pureum
 */
class RetrofitImpl : RetrofitSource{
    override suspend fun getData(page: Int): Data {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitSource::class.java).getData(3)
    }

}