package com.gumio_inf.futurelabhackathonapp

import android.app.Application
import com.gumio_inf.futurelabhackathonapp.models.api.FutureServices
import com.gumio_inf.futurelabhackathonapp.models.enumerate.MySharedPreferences
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gumio_inf on 2018/01/28.
 */
class App: Application {
    private var mInstance: App? = null

    constructor() {
        mInstance = this
    }

    override fun onCreate() {
        super.onCreate()
        MySharedPreferences.initialize(this)
        client()
    }

    fun client(): FutureServices {

        val okClient = OkHttpClient()
                .newBuilder()
                .addInterceptor {
                    it.proceed(it.request()
                            .newBuilder()
                            .addHeader("Authorization", resources.getString(R.string.server_key))
                            .addHeader("Content-Type", "application/json")
                            .build())
                }.build()

        val retrofit = Retrofit
                .Builder()
                .client(okClient)
                .baseUrl("https://fcm.googleapis.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(FutureServices::class.java)
    }

    fun getInstance(): App {
        if (mInstance == null) {
            mInstance = App()
        }
        return mInstance as App
    }
}