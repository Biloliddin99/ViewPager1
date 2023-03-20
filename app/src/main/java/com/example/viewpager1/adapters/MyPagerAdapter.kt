package com.example.viewpager1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.viewpager1.databinding.ItemPagerBinding
import com.example.viewpager1.models.MyData

class MyPagerAdapter(private val list: ArrayList<MyData>) : PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemPagerBinding =
            ItemPagerBinding.inflate(LayoutInflater.from(container.context), container, false)
        itemPagerBinding.imageItem.setBackgroundResource(list[position].image)
        itemPagerBinding.txtTitle.text = list[position].title
        itemPagerBinding.txtInfo.text = list[position].text
        container.addView(itemPagerBinding.root)
        return itemPagerBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}