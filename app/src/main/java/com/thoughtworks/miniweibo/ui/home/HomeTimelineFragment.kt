package com.thoughtworks.miniweibo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.miniweibo.R

class HomeTimelineFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_timeline_fragment, container, false)
        viewManager = LinearLayoutManager(this.context)
        viewAdapter = HomeTimelineAdaptor(
            arrayOf(
                "abc",
                "ccc",
                "abc",
                "ccc",
                "abc",
                "ccc",
                "abc",
                "ccc",
                "abc",
                "ccc",
                "abc",
                "ccc",
                "abc",
                "ccc"
            )
        )

        recyclerView = view.findViewById<RecyclerView>(R.id.home_timeline_post_list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return view
    }
}