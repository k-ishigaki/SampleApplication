package com.example.kazuki.sampleapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class SubActivity : AppCompatActivity() {

    var button : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        button = findViewById(R.id.button)
        button?.setOnClickListener {
            Log.v("button clicked")
            Toast.makeText(this@SubActivity, "show dialog on main activity", Toast.LENGTH_LONG).show()
            showDialogOnMainActivity()
        }
    }

    private fun showDialogOnMainActivity() {
        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(MainActivity.ACTION_SHOW_DIALOG))
    }
}
