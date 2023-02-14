package com.example.paging_practice

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception

/**
 * 2023-02-14
 * pureum
 */
class PagingSource(
    private val service : RetrofitImpl
) : PagingSource<Int, NewData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewData> {
        return try {
            val nowPage = params.key?: 0
            val result = service.getData(nowPage)
            //Log.e("TAG", "load: $result", )
            LoadResult.Page(
                data = result.toList(),
                prevKey = if(nowPage==0) null else nowPage - 1,
                nextKey = nowPage+1
            )
        }catch (e:Exception){
            Log.e("TAG", "pagingSource : err", )
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NewData>): Int? = 0

}