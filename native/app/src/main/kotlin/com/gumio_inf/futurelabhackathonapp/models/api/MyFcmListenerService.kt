package com.gumio_inf.futurelabhackathonapp.models.api

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.gumio_inf.futurelabhackathonapp.R
import com.gumio_inf.futurelabhackathonapp.views.activity.MainActivity





/**
 * Created by gumio_inf on 2018/01/28.
 */
class MyFcmListenerService: FirebaseMessagingService() {

    private val TAG = MyFcmListenerService::class.java.simpleName

    override fun onMessageReceived(message: RemoteMessage?) {
        val from = message!!.from
        val data = message.data

        Log.d(TAG, "from:" + from)
        Log.d(TAG, "data:" + data.toString())

        val msg = data["message"].toString()
        Log.d(TAG, msg)
        sendNotification(msg)
    }

    private fun sendNotification(message: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        val notificationBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("田辺さん")
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(0, notificationBuilder.build())
    }
}