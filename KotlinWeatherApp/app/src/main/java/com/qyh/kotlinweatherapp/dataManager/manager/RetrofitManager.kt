package com.qyh.kotlinweatherapp.dataManager.manager

import com.qyh.kotlinweatherapp.extensions.DelegatesExt
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient



/**
 * 创建人：dan.y
 * 创建时间：2017-6-21
 * 类描述：封装一个retrofit集成0kHttp3的抽象基类
*/
open class RetrofitManager {
    companion object{
        private var mRetrofit: Retrofit by DelegatesExt.notNullSingleValue<Retrofit>()
        private var mOkHttpClient: OkHttpClient by DelegatesExt.notNullSingleValue<OkHttpClient>()

        /**
         * 获取Retrofit对象
         * @return
         */
        /*protected*/ fun getRetrofit(): Retrofit{
            mOkHttpClient = OkhttpManager.getOkHttpClient()
            mRetrofit = Retrofit.Builder()
                    .baseUrl("http://route.showapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build()
            return mRetrofit
        }
    }

}