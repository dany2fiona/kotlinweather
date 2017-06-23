package com.qyh.kotlinweatherapp.dataManager.servers


import com.qyh.kotlinweatherapp.bean.WeatherJsonBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

/**
 * Created by dan.y on 2016/12/13.
 */
interface APIs{

    //根据城市名查询天气
    @FormUrlEncoded
    @POST("9-2")
    fun getWeatherByCityName(/*@Field("areaid") areaid: String,*/ @Field("area") area: String/*, @Field("needMoreDay") needMoreDay: String,
                 @Field("needIndex") needIndex: String, @Field("needHourData") needHourData: String, @Field("need3HourForcast") need3HourForcast: String,
                 @Field("needAlarm") needAlarm: String*/, @Field("showapi_appid") showapi_appid: String, @Field("showapi_sign") showapi_sign: String): Observable<WeatherJsonBean>


}
