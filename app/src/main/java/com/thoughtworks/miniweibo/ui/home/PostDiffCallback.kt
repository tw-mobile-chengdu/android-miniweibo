package com.thoughtworks.miniweibo.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.thoughtworks.miniweibo.api.Post

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.text == newItem.text
    }
}