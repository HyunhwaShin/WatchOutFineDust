package com.example.watchoutfinedust.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerFragmentAdapter(fragment : Fragment)
    : FragmentStateAdapter(fragment) {
    var fragmentList = ArrayList<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size-1)
    }
    fun deleteFragment(){
        fragmentList.removeLast()
        notifyItemRemoved(fragmentList.size)
    }
}