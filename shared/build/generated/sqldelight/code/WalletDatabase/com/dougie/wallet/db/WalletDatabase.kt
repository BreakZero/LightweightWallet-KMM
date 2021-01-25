package com.dougie.wallet.db

import com.dougie.wallet.db.shared.newInstance
import com.dougie.wallet.db.shared.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import comdougiewalletdb.CoinConfigQueries

interface WalletDatabase : Transacter {
  val coinConfigQueries: CoinConfigQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = WalletDatabase::class.schema

    operator fun invoke(driver: SqlDriver): WalletDatabase =
        WalletDatabase::class.newInstance(driver)}
}
