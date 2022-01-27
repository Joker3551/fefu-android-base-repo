package com.example.myapplication.tracker.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.tracker.fragment.MyActivityFragment
import com.example.myapplication.tracker.fragment.RecyclerViewFragment
import com.example.myapplication.tracker.fragment.UsersActivityFragment


class ViewPagerAdapter(fragment: RecyclerViewFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return itemsLen
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == firstPosition) MyActivityFragment.newInstance()
        else UsersActivityFragment.newInstance()
    }

    companion object {
        const val itemsLen = 2
        const val firstPosition = 0
    }
}