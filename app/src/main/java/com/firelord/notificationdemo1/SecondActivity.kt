package com.firelord.notificationdemo1

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        receiveInput()
    }

    private fun receiveInput(){
        val KEY_REPLY = "key_reply"
        val intent = this.intent
        val textView3 = findViewById<TextView>(R.id.textView3)
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput!=null){
           val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            textView3.text = inputString

            val channelID = "com.firelord.notificationdemo1.channel1"
            val notificationId = 45

            val repliedNotifcation = NotificationCompat.Builder(this,channelID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("Your reply recieved")
                .build()
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationId,repliedNotifcation)

        }
    }
}