package com.thoughtworks.miniweibo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.miniweibo.R
import com.thoughtworks.miniweibo.api.ApiResponse
import com.thoughtworks.miniweibo.api.ApiSuccessResponse
import com.thoughtworks.miniweibo.api.Post
import com.thoughtworks.miniweibo.api.WeiboService
import com.thoughtworks.miniweibo.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        viewAdapter = HomeTimelineAdaptor {
            val action =
                HomeTimelineFragmentDirections.actionHomeTimelineFragmentToPostDetailFragment()
            findNavController().navigate(action)
        }

        val weiboService = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(WeiboService::class.java)
        weiboService.getPosts().observe(this, Observer<ApiResponse<List<Post>>> {
            if (it is ApiSuccessResponse) {
                (viewAdapter as HomeTimelineAdaptor).submitList(it.body)
            }
        })

        recyclerView = view.findViewById<RecyclerView>(R.id.home_timeline_post_list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return view
    }
}