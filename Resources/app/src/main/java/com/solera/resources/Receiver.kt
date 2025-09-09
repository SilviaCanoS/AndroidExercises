package com.solera.resources

import android.content.BroadcastReceiver
import android.content.Intent
import android.widget.Toast

class Receiver: BroadcastReceiver() {
    override fun onReceive(context: android.content.Context?, intent: android.content.Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isAirplaneModeOn = intent.getBooleanExtra("state", false)
            Toast.makeText(context, "Airplane Mode is " + if (isAirplaneModeOn) "ON" else "OFF", Toast.LENGTH_SHORT).show()
        }
    }

}