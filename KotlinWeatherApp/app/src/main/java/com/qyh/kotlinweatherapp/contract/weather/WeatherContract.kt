package com.qyh.kotlinweatherapp.contract.weather

import com.qyh.kotlinweatherapp.bean.WeatherBean
import com.qyh.kotlinweatherapp.ui.BaseActivity

/**
 * Created by dan.y on 2017/6/21.
 */
interface WeatherContract {
    interface View{
        fun setWeatherPresenter(presenter: Presenter)
        fun getWeatherByCityName()
        fun getWeatherByCityNameSuccess(list:ArrayList<WeatherBean>)
        fun getWeatherByCityNameFailed()
    }

    interface Presenter{
        fun getWeatherByCityName(area:String,context:BaseActivity)
    }
}