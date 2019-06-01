package com.angelhackers.hereme.Activity

import android.app.Notification

import android.os.Bundle
import android.view.View
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import com.angelhackers.hereme.R

import com.angelhackers.hereme.Activity.App.Companion.CHANNEL_1_ID
import com.angelhackers.hereme.Activity.App.Companion.CHANNEL_2_ID

class NotifyActivity : AppCompatActivity() {

    private var notificationManager: NotificationManagerCompat? = null
    private var editTextTitle: EditText? = null
    private var editTextMessage: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)

        editTextTitle = findViewById(R.id.edit_text_title)
        editTextMessage = findViewById(R.id.edit_text_message)
    }

    fun sendOnChannel1(v: View) {
        val title = editTextTitle!!.text.toString()
        val message = editTextMessage!!.text.toString()

        val notification = NotificationCompat.Builder(this, CHANNEL_1_ID)
            //.setSmallIcon(R.drawable.ic_one)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()

        notificationManager!!.notify(1, notification)
    }

    fun sendOnChannel2(v: View) {
        val title = editTextTitle!!.text.toString()
        val message = editTextMessage!!.text.toString()

        val notification = NotificationCompat.Builder(this, CHANNEL_2_ID)
            //.setSmallIcon(R.drawable.ic_two)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()

        notificationManager!!.notify(2, notification)
    }
}