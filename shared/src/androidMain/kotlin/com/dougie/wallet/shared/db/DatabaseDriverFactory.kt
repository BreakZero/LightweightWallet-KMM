package com.dougie.wallet.shared.db

import android.content.Context
import com.dougie.wallet.db.WalletDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(WalletDatabase.Schema, context, "test.db")
    }
}