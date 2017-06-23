package com.qyh.kotlinweatherapp

import android.app.Application
import com.qyh.kotlinweatherapp.extensions.DelegatesExt

/**
 * Created by dan.y on 2017/6/20.
 */
class WApp : Application() {
    val showapi_appid:String = "40855"
    val showapi_sign:String = "bab1946fc3224edcb4ace9e6a38742f9"

    companion object{
        var instance:WApp by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}