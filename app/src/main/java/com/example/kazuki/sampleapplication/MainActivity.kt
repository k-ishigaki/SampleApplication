package com.example.kazuki.sampleapplication

import android.content.*
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    companion object {
        const val ACTION_SHOW_DIALOG = BuildConfig.APPLICATION_ID + ".show_dialog_at_main"
    }

    private var button : Button? = null

    private var receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.v("broadcast is received")
            showDialog()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = this.findViewById(R.id.button)
        button?.setOnClickListener(View.OnClickListener {
            Log.v("tapped!")
            startSubActivity()
        })

        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, IntentFilter(ACTION_SHOW_DIALOG))
    }

    private fun startSubActivity() {
        val intent = Intent(this, SubActivity::class.java)
        startActivity(intent)
    }

    private fun showDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("title")
            setMessage("message")
            setPositiveButton("finish app") { _, _ ->
                Toast.makeText(this@MainActivity, "finish app", Toast.LENGTH_LONG).show()
                finish()
            }
            setNegativeButton("Cancel", null)
            show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver)
    }
}
