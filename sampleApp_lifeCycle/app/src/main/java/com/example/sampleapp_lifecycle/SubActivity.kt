package com.example.sampleapp_lifecycle

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        post_uri.setOnClickListener{
            val uri = Uri.parse(text_uri.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        val receiver = MyReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED")
        registerReceiver(receiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        val greet = intent.getStringExtra("greet")
        Toast.makeText(this, greet, Toast.LENGTH_SHORT).show()
    }
}
