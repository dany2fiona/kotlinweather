package com.qyh.kotlinweatherapp.dataManager.servers.weather

import com.qyh.kotlinweatherapp.WApp.Companion.instance
import com.qyh.kotlinweatherapp.bean.WeatherJsonBean
import com.qyh.kotlinweatherapp.dataManager.servers.Servers
import rx.Observable
import rx.Subscriber

/**
 * Created by dan.y on 2017/6/22.
 */
class WeatherServers : Servers() {
    companion object{
        //根据地名查询天气
        fun getWeatherByCityName (area: String, subscriber: Subscriber<WeatherJsonBean>) {
            getWeatherByCityName(service.getWeatherByCityName(area,instance.showapi_appid,instance.showapi_sign),subscriber)
        }
        fun getWeatherByCityName(observable: Observable<WeatherJsonBean>, subscriber: Subscriber<WeatherJsonBean>){
            setSubscribe(observable,subscriber)
        }
    }
}