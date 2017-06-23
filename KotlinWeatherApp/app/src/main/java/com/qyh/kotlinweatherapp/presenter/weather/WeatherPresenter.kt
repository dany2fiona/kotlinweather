package com.qyh.kotlinweatherapp.presenter.weather

import com.qyh.kotlinweatherapp.bean.WeatherBean
import com.qyh.kotlinweatherapp.bean.WeatherJsonBean
import com.qyh.kotlinweatherapp.contract.weather.WeatherContract
import com.qyh.kotlinweatherapp.dataManager.manager.BaseSubscriber
import com.qyh.kotlinweatherapp.dataManager.servers.weather.WeatherServers
import com.qyh.kotlinweatherapp.ui.BaseActivity
import org.jetbrains.anko.toast
import rx.Subscriber

/**
 * Created by dan.y on 2017/6/22.
 */
class WeatherPresenter(view : WeatherContract.View) : WeatherContract.Presenter {
    var view:WeatherContract.View?=null

    init {
        this.view = view
        view.setWeatherPresenter(this)
    }

    override fun getWeatherByCityName(area: String, context: BaseActivity) {
        WeatherServers.getWeatherByCityName(area, object : BaseSubscriber<WeatherJsonBean>(context){

            override fun onNext(t: WeatherJsonBean?) {
                if(t?.showapi_res_body?.ret_code == 0){
                    view?.getWeatherByCityNameSuccess(t?.convertWeatherList() as ArrayList<WeatherBean>)
                }else{
                    context.toast("找不到此地名!")
                    view?.getWeatherByCityNameFailed()
                }
            }

        })
    }
}