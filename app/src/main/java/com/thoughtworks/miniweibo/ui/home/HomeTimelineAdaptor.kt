package com.thoughtworks.miniweibo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.miniweibo.R


class HomeTimelineAdaptor(private val posts: Array<String>) :
    RecyclerView.Adapter<HomeTimelineAdaptor.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_home_timeline_card, parent, false)
        return PostViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.textView.text = posts[position]
    }

    class PostViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = v.findViewById(R.id.username)
    }
}