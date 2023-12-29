package com.riadul.advancedandroid.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityNotificationMainBinding

class NotificationMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityNotificationMainBinding
    private val channelID = "com.riadul.advancedandroid.notification.channel1"
    private var notificationManager: NotificationManager? = null
    private val KEY_REPLY = "key_reply"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelID, "DemoChannel", "This is Demo Channel")
        binding.button.setOnClickListener {
            displayNotification()
        }
    }

    private fun displayNotification() {
        val notificationId = 45
        val tapResultIntent = Intent(this, NotificationSecondActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            tapResultIntent,
            PendingIntent.FLAG_MUTABLE
        )
        // reply action
        val remoteInput: RemoteInput = RemoteInput.Builder(KEY_REPLY).run {
            setLabel("Enter Your Name")
            build()
        }

        val replyAction: NotificationCompat.Action = NotificationCompat.Action.Builder(
            0,
            "Reply",
            pendingIntent
        ).addRemoteInput(remoteInput).build()

        // action button 1
        val actionIntent = Intent(this, NotificationDetailsActivity::class.java)
        val actionPendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            actionIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val action1: NotificationCompat.Action = NotificationCompat.Action.Builder(
            0,
            "Details",
            actionPendingIntent
        ).build()

        // action button 2
        val actionIntent2 = Intent(this, NotificationSettingsActivity::class.java)
        val actionPendingIntent2: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            actionIntent2,
            PendingIntent.FLAG_IMMUTABLE
        )

        val action2: NotificationCompat.Action = NotificationCompat.Action.Builder(
            0,
            "Settings",
            actionPendingIntent2
        ).build()

        val notification = NotificationCompat.Builder(this, channelID)
            .setContentTitle("Demo Title")
            .setContentText("This is a demo notification")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            //.setContentIntent(pendingIntent)
            .addAction(action1)
            .addAction(action2)
            .addAction(replyAction)
            .build()

        notificationManager?.notify(notificationId, notification)
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }
}