package com.dougie.wallet.shared.db

import com.dougie.wallet.db.WalletDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = WalletDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.coinConfigQueries

    internal fun getContent(): String {
        return dbQuery.selectAll().executeAsList().joinToString(", ") { it.coin_name }
    }
}