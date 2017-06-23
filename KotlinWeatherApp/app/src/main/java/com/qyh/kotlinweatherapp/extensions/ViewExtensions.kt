package com.qyh.kotlinweatherapp.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.qyh.kotlinweatherapp.R

/**
 * Created by dan.y on 2017/6/21.
 */

val View.ctx : Context
    get() = context

fun View.slideExit(){//和RecyclerView联动
    if(translationY == 0f) animate().translationY(-height.toFloat())
}
fun View.slideEnter(){
    if(translationY < 0f) animate().translationY(0f)
}
fun View.slideExit(height: Float){//和RecyclerView联动
    if(translationY == 0f) animate().translationY(-height)
}

fun ImageView.loadImg(imgUrl: String){
    Glide.with(ctx).load(imgUrl).asBitmap().placeholder(R.mipmap.pic_default_details).into(this)
}

fun EditText.hideKeyboard(){
    val im:InputMethodManager = this.ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ;
    im.hideSoftInputFromWindow(this.getWindowToken(), 0)
}

