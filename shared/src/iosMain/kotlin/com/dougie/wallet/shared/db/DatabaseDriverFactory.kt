package com.dougie.wallet.shared.db

import com.dougie.wallet.db.WalletDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(WalletDatabase.Schema, "test.db")
    }
}