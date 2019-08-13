package com.dastanIqbal.di.adapter

import androidx.databinding.ViewDataBinding

abstract class ViewHolder<V,out T : ViewDataBinding>(val bind: T) : androidx.recyclerview.widget.RecyclerView.ViewHolder(bind.root) {
    abstract fun bind(item: V?, position: Int)
    abstract fun unbind()
}