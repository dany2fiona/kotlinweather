package com.qyh.kotlinweatherapp.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.qyh.firstkotlindemo.adapter.ForecastListAdapter
import com.qyh.kotlinweatherapp.R
import com.qyh.kotlinweatherapp.bean.WeatherBean
import com.qyh.kotlinweatherapp.contract.weather.WeatherContract
import com.qyh.kotlinweatherapp.extensions.hideKeyboard
import com.qyh.kotlinweatherapp.presenter.weather.WeatherPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_titleandright.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(),ToolbarManager , WeatherContract.View{

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    private var netItems: ArrayList<WeatherBean>?=null
    private var resultItems : ArrayList<WeatherBean>?=null
    var mPresenter:WeatherContract.Presenter?=null
    var area:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_title.apply {
            hint = "请输入城市名如：上海"
            isFocusable = true
            isFocusableInTouchMode = true
            requestFocus()
        }

        btn_right.apply {
            text = "刷新"
            setOnClickListener { getWeatherByCityName() }
        }

        WeatherPresenter(this)

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList,ll)

        initData()

    }

    override fun setWeatherPresenter(presenter: WeatherContract.Presenter) {
        mPresenter = presenter
    }

    override fun getWeatherByCityName() {
        area = et_title.text.toString()
        if(area.equals("")){
            toast("请输入城市名称")
        }else{
            mPresenter?.getWeatherByCityName(area, MainActivity@this)
        }
    }

    override fun getWeatherByCityNameSuccess(list: ArrayList<WeatherBean>) {
        et_title.hideKeyboard()
       if(list.size > 0){
           if (netItems?.size!! > 0)netItems?.clear()
           netItems?.addAll(list)
           getResultData()
       }else{
           toast("无数据")
       }
    }

    override fun getWeatherByCityNameFailed() {
        et_title.hideKeyboard()
        et_title.setText("")
        area = ""
    }

    fun initData(){
        netItems = arrayListOf()
        getResultData()
    }

    fun getResultData(){
        if(resultItems == null){
            resultItems  = arrayListOf()
        }else{
            resultItems?.clear()
            for (bean in netItems!!){
                resultItems?.add(bean)
            }
        }
        if(forecastList.adapter == null){
            forecastList.adapter = ForecastListAdapter(resultItems!!)
        }else{
            forecastList.adapter.notifyDataSetChanged()
        }
    }



}
