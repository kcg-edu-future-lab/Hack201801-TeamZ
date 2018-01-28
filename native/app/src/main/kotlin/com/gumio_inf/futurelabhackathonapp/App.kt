package com.gumio_inf.futurelabhackathonapp

import android.app.Application
import com.gumio_inf.futurelabhackathonapp.models.enumerate.MySharedPreferences

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
    }

    fun getInstance(): App {
        if (mInstance == null) {
            mInstance = App()
        }
        return mInstance as App
    }
}