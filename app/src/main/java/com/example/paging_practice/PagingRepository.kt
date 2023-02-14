package com.example.paging_practice

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow


/**
 * 2023-02-14
 * pureum
 */
class PagingRepository(
    private val service: RetrofitImpl
) {
    fun repoGetData(): Flow<PagingData<NewData>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false), // 두번째 인수는 모지?
            pagingSourceFactory = {PagingSource(service)}
        ).flow
    }
}