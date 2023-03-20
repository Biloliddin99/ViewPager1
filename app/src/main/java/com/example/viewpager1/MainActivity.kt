package com.example.viewpager1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.viewpager1.adapters.MyPagerAdapter
import com.example.viewpager1.databinding.ActivityMainBinding
import com.example.viewpager1.databinding.ItemPagerBinding
import com.example.viewpager1.databinding.ItemTabBinding
import com.example.viewpager1.models.MyData
import com.example.viewpager1.models.MyInfo
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var myPagerAdapter: MyPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyInfo.loadData()

        var index = 0
        myPagerAdapter = MyPagerAdapter( MyInfo.list)
        binding.myViewPager.adapter = myPagerAdapter

        binding.myTab.setupWithViewPager(binding.myViewPager)
        addTab()

        binding.myViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                index = position
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        binding.btnNext.setOnClickListener {
            when (index) {
                0 -> {
                    binding.myViewPager.currentItem = index + 1
                }
                1 -> {
                    binding.myViewPager.currentItem = index + 1
                }
                2 -> {
                    binding.myViewPager.currentItem = index + 1
                }
                3 -> {
                    binding.myViewPager.currentItem = index - 3
                }
            }
        }

    }

    private fun addTab() {
        val tabCount = binding.myTab.tabCount

        for (i in 0 until tabCount) {
            val tabItem = ItemTabBinding.inflate(layoutInflater)
            val tab = binding.myTab.getTabAt(i)
            tab?.customView = tabItem.root

            if (i == 0) {
                tabItem.oval.setImageResource(R.drawable.roundcheck)
            } else {
                tabItem.oval.setImageResource(R.drawable.round)
            }
        }
        binding.myTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.oval)
                    ?.setImageResource(R.drawable.roundcheck)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.oval)?.setImageResource(R.drawable.round)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        MyInfo.loadData()
        MyInfo.list.removeAll(MyInfo.list.toSet())
    }

}