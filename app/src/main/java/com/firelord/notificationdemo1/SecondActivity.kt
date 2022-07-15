package com.firelord.notificationdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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
        }
    }
}