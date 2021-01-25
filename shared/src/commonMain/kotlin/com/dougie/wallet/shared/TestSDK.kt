package com.dougie.wallet.shared

import com.dougie.wallet.shared.db.Database
import com.dougie.wallet.shared.db.DatabaseDriverFactory

class TestSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)

    fun getResult() = database.getContent()
}