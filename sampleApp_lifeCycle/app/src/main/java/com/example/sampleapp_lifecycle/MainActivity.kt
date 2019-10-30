package com.example.sampleapp_lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.net.Uri
import android.content.BroadcastReceiver
import android.content.IntentFilter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("ActivityLifeCycle","onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_open_subView.setOnClickListener{
            val intent = Intent("com.example.sampleapp_lifecycle.Action_ChangeView")
            intent.putExtra("greet","hello!")
            startActivity(intent)
        }
        val receiver = MyReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED")
        registerReceiver(receiver, intentFilter)
    }

    override fun onStart() {
        Log.i("ActivityLifeCycle","onStart()")
        super.onStart()
    }

    override fun onRestart() {
        Log.i("ActivityLifeCycle","onRestart()")
        super.onRestart()
    }

    override fun onResume() {
        Log.i("ActivityLifeCycle","onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.i("ActivityLifeCycle","onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.i("ActivityLifeCycle","onStop()")
        super.onStop()

    }

    override fun onDestroy() {
        Log.i("ActivityLifeCycle","onDestroy()")
        super.onDestroy()
    }

}