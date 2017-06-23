package com.qyh.kotlinweatherapp.ui

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import com.qyh.kotlinweatherapp.extensions.slideEnter
import com.qyh.kotlinweatherapp.extensions.slideExit

/**
 * Created by dan.y on 2017/6/21.
 */
interface ToolbarManager {
    val toolbar : Toolbar

    fun attachToScroll(recyclerView: RecyclerView,linearLayout: LinearLayout){
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0){
                    toolbar.slideExit()
                    linearLayout.slideExit(toolbar.height.toFloat())
                } else{
                    toolbar.slideEnter()
                    linearLayout.slideEnter()
                }
            }
        })
    }
}