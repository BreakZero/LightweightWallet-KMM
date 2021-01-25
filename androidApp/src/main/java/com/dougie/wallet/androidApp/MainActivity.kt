package com.dougie.wallet.androidApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dougie.wallet.db.WalletDatabase
import com.dougie.wallet.shared.Greeting
import com.dougie.wallet.shared.TestSDK
import com.dougie.wallet.shared.db.DatabaseDriverFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tv: TextView = findViewById(R.id.text_view)
        val database = TestSDK(DatabaseDriverFactory(this))
        tv.text = database.getResult()
    }
}
