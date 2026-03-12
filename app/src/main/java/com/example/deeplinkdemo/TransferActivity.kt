package com.example.deeplinkdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class TransferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val deepLink = intent?.data
        val to = deepLink?.getQueryParameter("to")
        val amount = deepLink?.getQueryParameter("amount")

        Log.d("TransferActivity", "Deep link received: to=$to, amount=$amount")

        // Vulnerability: forwards untrusted incoming intent without validation.
        val forwardedIntent: Intent = intent
        forwardedIntent.setClass(this, ConfirmTransferActivity::class.java)
        startActivity(forwardedIntent)
        finish()
    }
}
