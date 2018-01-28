package com.gumio_inf.futurelabhackathonapp.models.api

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService



/**
 * Created by gumio_inf on 2018/01/28.
 */
class MyInstanceIDListenerService: FirebaseInstanceIdService() {
    private val TAG = MyInstanceIDListenerService::class.java.simpleName

    // 新しいトークンが生成されるたびにコールバックさせるとこ
    override fun onTokenRefresh() {
        //ここで取得したInstanceIDをサーバー管理者に伝える

        sendToServer()

        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refreshed token: " + refreshedToken!!)
    }

    private fun sendToServer() {

    }
}