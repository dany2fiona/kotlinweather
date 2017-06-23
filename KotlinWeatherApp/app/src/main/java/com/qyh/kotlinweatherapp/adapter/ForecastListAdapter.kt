package com.qyh.firstkotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qyh.kotlinweatherapp.R
import com.qyh.kotlinweatherapp.bean.WeatherBean
import com.qyh.kotlinweatherapp.extensions.ctx
import com.qyh.kotlinweatherapp.extensions.loadImg
import kotlinx.android.synthetic.main.layout_item_details.view.*

/**
 * Created by dan.y on 2017/6/9.
 */
class ForecastListAdapter(var items: ArrayList<WeatherBean>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    val list:List<String> = listOf("今天","明天","后天")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_title.text = list[position]
        holder.bindWeather(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.layout_item_details, parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        fun bindWeather(weatherBean: WeatherBean){
            with(weatherBean){
                itemView.iv_temper.loadImg(day_weather_pic)
                itemView.tv_temper.text = day_weather
                itemView.tv_wd.text = day_air_temperature +"℃"
                itemView.tv_wx.text = day_wind_direction
                itemView.tv_wl.text = day_wind_power
                itemView.iv_temper_n.loadImg(night_weather_pic)
                itemView.tv_temper_n.text = night_weather
                itemView.tv_wd_n.text = night_air_temperature +"℃"
                itemView.tv_wx_n.text = night_wind_direction
                itemView.tv_wl_n.text = night_wind_power
                itemView.tv_rcrl.text = sun_begin_end.split("|")[0]
                itemView.tv_rcrl_n.text = sun_begin_end.split("|")[1]
            }
        }
    }
}