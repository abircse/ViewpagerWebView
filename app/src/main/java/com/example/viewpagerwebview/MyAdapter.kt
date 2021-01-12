package com.example.viewpagerwebview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.viewpager.widget.PagerAdapter
import java.util.ArrayList

class MyAdapter(private var context: Context, private val myweblist: ArrayList<MyModel>) :  PagerAdapter() {
    override fun getCount(): Int {
        return myweblist.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // inflate item layout
        val views = LayoutInflater.from(context).inflate(R.layout.custom_viewpager_item, container, false)
        // Get Data
        val model = myweblist[position]
        val weburl = model.weburl

        // Set data to view (here we load url to web)
        val webView = views.findViewById(R.id.webview) as WebView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(weburl)
                return true
            }
        }
        webView.loadUrl(weburl)

        // add view to container
        container.addView(views,position)

        return views
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}