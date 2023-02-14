package com.example.paging_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.paging_practice.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding :ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val data : RetrofitImpl by lazy {RetrofitImpl()}
    private val adapter : Adapter by lazy { Adapter() }
    private val viewModel = MainViewModel(PagingRepository(RetrofitImpl()))
    private val swipeRefreshLayout : SwipeRefreshLayout by lazy { binding.swipeRefreshLayout }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            viewModel.vmGetData().collectLatest {
                adapter.submitData(it)
            }
        }

        swipeRefreshLayout.setOnRefreshListener {
            adapter.refresh()
            swipeRefreshLayout.isRefreshing = false
        }
    }
}