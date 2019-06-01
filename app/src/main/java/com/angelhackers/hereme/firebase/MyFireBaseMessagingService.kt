package com.angelhackers.hereme.firebase

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.R
import android.app.NotificationChannel
import com.angelhackers.hereme.MainActivity


class MyFireBaseMessagingService : FirebaseMessagingService() {

    private val TAG = "FirebaseMessage"
    var token : String = FirebaseInstanceId.getInstance().getToken()!!

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d(TAG, "From: " + remoteMessage!!.from)


        if (remoteMessage.getData() != null) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData())
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            var pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
            val notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

            var notificationManager: NotificationManager =
                this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channelId = "channel"
            val channelName = "Channel Name"
            val importance = NotificationManager.IMPORTANCE_LOW
            val message : String = remoteMessage.data.toString()

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                val mChannel = NotificationChannel(
                    channelId, channelName, importance
                )
                notificationManager.createNotificationChannel(mChannel)
            }

            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.mipmap.sym_def_app_icon)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(notificationSound)
                .setContentIntent(pendingIntent)
            notificationManager.notify(0, notificationBuilder.build())
        }
    }

    override fun onNewToken(p0: String?) {
        Log.d(TAG,"Refreshed token: " + p0)
       // sendRegistrationToServer(token)
    }
}
