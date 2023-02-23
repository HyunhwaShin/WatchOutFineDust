package com.example.watchoutfinedust.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.watchoutfinedust.databinding.FragmentMainBinding
import com.example.watchoutfinedust.presentation.adapter.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPager : ViewPager2
    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter
    private lateinit var tabLayout : TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)
        viewPager = binding.viewPager
        tabLayout = binding.tabLayout

        viewPagerFragmentAdapter.addFragment(MapFragment())
        viewPagerFragmentAdapter.addFragment(WarningListFragment())

        viewPager.adapter = viewPagerFragmentAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("ViewPagerFragment", "page ${position+1}")
            }
        })

        val tabLayoutArray = arrayOf("지도", "경보/주의보 지역")

        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            tab.text = tabLayoutArray[position]
        }.attach()

    }

}