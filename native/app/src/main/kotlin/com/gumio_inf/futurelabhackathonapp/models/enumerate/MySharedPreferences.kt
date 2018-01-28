package com.gumio_inf.futurelabhackathonapp.models.enumerate

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by gumio_inf on 2018/01/28.
 */
object MySharedPreferences {

    private val PREFERENCE_NAME = "future"
    private var mSharedPreferences: SharedPreferences? = null
    private var mEditor: SharedPreferences.Editor? =  null

    fun initialize(context: Context){
        if (mSharedPreferences != null && mEditor != null) return
        mSharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        mEditor = mSharedPreferences?.edit()
    }

    fun setFirstAppLaunch(isFirst: Boolean) {
        mEditor?.putBoolean(SharedPreferenceType.FIRST_APP_LAUNCH.key, isFirst)
        mEditor?.commit()
    }

    fun getFirstAppLaunch(): Boolean? = mSharedPreferences?.getBoolean(SharedPreferenceType.ACTIVE_APP_LOGIN.key, true)

    fun setActiveAppLogin(isLogin: Boolean) {
        mEditor?.putBoolean(SharedPreferenceType.FIRST_APP_LAUNCH.key, isLogin)
        mEditor?.commit()
    }

    fun getActiveAppLogin(): Boolean? = mSharedPreferences?.getBoolean(SharedPreferenceType.ACTIVE_APP_LOGIN.key, false)

    fun clearPreferences() {
        mEditor?.clear()?.commit()
    }
}