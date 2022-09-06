package com.example.aircondition.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<T, V : BaseRecyclerViewHolder<T, M>, M : ViewBinding>(diffCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T, V>(diffCallback) {

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.bind(getItem(position), position)
        if (holder.binding is ViewDataBinding) {
            holder.binding.executePendingBindings()
        }
    }
}

abstract class BaseRecyclerViewHolder<T, M : ViewBinding>(val binding: M, val lifecycleOwner: LifecycleOwner) : RecyclerView.ViewHolder(binding.root) {

    constructor(bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> M, parent: ViewGroup, lifecycleOwner: LifecycleOwner) : this(bindingInflater(LayoutInflater.from(parent.context), parent, false), lifecycleOwner)

    abstract fun bind(item: T, position: Int)
}

