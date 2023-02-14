package com.example.paging_practice

import android.graphics.ImageDecoder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging_practice.databinding.ListBinding

/**
 * 2023-02-14
 * pureum
 */
class Adapter : PagingDataAdapter<NewData,Adapter.MyViewHolder>(
    object : DiffUtil.ItemCallback<NewData>(){
        override fun areItemsTheSame(oldItem: NewData, newItem: NewData): Boolean {
            return oldItem.image == newItem.image && oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: NewData, newItem: NewData): Boolean {
            return oldItem == newItem
        }
    }
){
    inner class MyViewHolder(private val binding: ListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:NewData){
            binding.textView2.text = item.name
            binding.textView4.text = item.image
            binding.textView6.text = item.status
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)?:return
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(binding = ListBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }
}