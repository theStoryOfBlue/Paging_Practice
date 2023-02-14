package com.example.paging_practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow


/**
 * 2023-02-14
 * pureum
 */
class MainViewModel(private val repo:PagingRepository) :ViewModel(){
    fun vmGetData(): Flow<PagingData<NewData>> {
        return repo.repoGetData().cachedIn(viewModelScope)
    }
}