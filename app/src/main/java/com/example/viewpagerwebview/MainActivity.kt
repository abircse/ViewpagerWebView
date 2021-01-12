package com.example.viewpagerwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.ViewPager
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var myWebUrlList: ArrayList<MyModel>
    private lateinit var adapter: MyAdapter
    lateinit var viewPager: ViewPager
    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // intialize toolbar default
        actionBar = this.supportActionBar!!

        // call list data
        loadViewpageritem()

        // set adapter
        viewPager = findViewById(R.id.viewPager)

        // Set adapter to viewpager
        adapter = MyAdapter(this, myWebUrlList)
        viewPager.adapter = adapter
        //viewPager.setPadding(100,0,100,0)

        // viewpager swipe when item change
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val url = myWebUrlList[position].title
                actionBar.title = url
            }
            override fun onPageSelected(position: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    // Set url to listview
    private fun loadViewpageritem() {
        myWebUrlList = ArrayList()
        myWebUrlList.add(MyModel("GOOGLE SEARCH","https://www.google.com"))
        myWebUrlList.add(MyModel("COXSBAZAR NEWS","http://www.coxsbazarnews.com"))
        myWebUrlList.add(MyModel("COXTUNES LAB","http://www.coxtunes.com"))
    }
}