package com.thoughtworks.miniweibo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.thoughtworks.miniweibo.R
import com.thoughtworks.miniweibo.api.Post
import com.thoughtworks.miniweibo.ui.home.HomeTimelineAdaptor.*
import kotlinx.android.synthetic.main.fragment_home_timeline_card.view.*
import kotlinx.android.synthetic.main.home_timeline_card_header.view.*


class HomeTimelineAdaptor(private val clickListener: (Post) -> Unit) :
    ListAdapter<Post, PostViewHolder>(PostDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_home_timeline_card, parent, false)
        return PostViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post, clickListener: (Post) -> Unit) {
            itemView.avatar.load(post.user.profileImageUrl)
            itemView.username.text = post.user.screenName
            itemView.datetime.text = post.createdAt
            itemView.card_content.text = post.text
            itemView.card_content.setOnClickListener { clickListener(post) }
        }
    }
}