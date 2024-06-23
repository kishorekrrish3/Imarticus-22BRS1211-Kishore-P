package com.example.s5_alarmapp

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val i = Intent(context,DestinationActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context, requestCode: 0,i, flags: 0)

        val builder = NotificationCompat.Builder(context!!, channelId: "kishore")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContextTitle("Kishore Alarm Manager")
            .setContextText("Session 5")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val NotificationManager = NotificationCompat.from(context)
        notificationManager.notify(id:123, builder.build())
    }
}