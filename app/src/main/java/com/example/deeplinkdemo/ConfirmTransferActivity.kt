package com.example.deeplinkdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmTransferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val deepLink = intent?.data
        val to = deepLink?.getQueryParameter("to") ?: "unknown"
        val amount = deepLink?.getQueryParameter("amount") ?: "0"

        val detailsView = TextView(this).apply {
            text = "Confirming transfer to $to for $$amount"
            textSize = 20f
            setPadding(32, 64, 32, 32)
        }

        setContentView(detailsView)
    }
}
