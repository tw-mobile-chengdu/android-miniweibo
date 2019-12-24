package com.thoughtworks.miniweibo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.thoughtworks.miniweibo.R

class HomeTimelineFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_timeline_fragment, container, false)
        val gotoDetailButton = view.findViewById<Button>(R.id.goto_post_detail)
        gotoDetailButton.setOnClickListener {
            val action =
                HomeTimelineFragmentDirections.actionHomeTimelineFragmentToPostDetailFragment()
            findNavController().navigate(action)
        }
        return view
    }
}