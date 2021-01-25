package com.dougie.wallet.db.shared

import com.dougie.wallet.db.WalletDatabase
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.internal.copyOnWriteList
import comdougiewalletdb.CoinConfig
import comdougiewalletdb.CoinConfigQueries
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.MutableList
import kotlin.reflect.KClass

internal val KClass<WalletDatabase>.schema: SqlDriver.Schema
  get() = WalletDatabaseImpl.Schema

internal fun KClass<WalletDatabase>.newInstance(driver: SqlDriver): WalletDatabase =
    WalletDatabaseImpl(driver)

private class WalletDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), WalletDatabase {
  override val coinConfigQueries: CoinConfigQueriesImpl = CoinConfigQueriesImpl(this, driver)

  object Schema : SqlDriver.Schema {
    override val version: Int
      get() = 1

    override fun create(driver: SqlDriver) {
      driver.execute(null, """
          |CREATE TABLE coinConfig(
          |    coin_symbol TEXT NOT NULL PRIMARY KEY,
          |    coin_name TEXT NOT NULL,
          |    coin_decimal INTEGER NOT NULL,
          |    display_decimal INTEGER NOT NULL,
          |    accent_color TEXT NOT NULL,
          |    is_active INTEGER NOT NULL DEFAULT 0
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |INSERT INTO coinConfig (coin_symbol, coin_name, coin_decimal, display_decimal, accent_color, is_active)
          |VALUES ('BTC', 'Bitcoin', 8, 8, '#E8963F', 1)
          """.trimMargin(), 0)
      driver.execute(null, """
          |INSERT INTO coinConfig (coin_symbol, coin_name, coin_decimal, display_decimal, accent_color, is_active)
          |VALUES ('ETH', 'Ethereum', 18, 8, '#5F6CBA', 0)
          """.trimMargin(), 0)
      driver.execute(null, """
          |INSERT INTO coinConfig (coin_symbol, coin_name, coin_decimal, display_decimal, accent_color, is_active)
          |VALUES ('CRO', 'Crypto.com Coin', 8, 8, '#0000CD', 0)
          """.trimMargin(), 0)
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ) {
    }
  }
}

private class CoinConfigQueriesImpl(
  private val database: WalletDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), CoinConfigQueries {
  internal val selectAll: MutableList<Query<*>> = copyOnWriteList()

  override fun <T : Any> selectAll(mapper: (
    coin_symbol: String,
    coin_name: String,
    coin_decimal: Int,
    display_decimal: Int,
    accent_color: String,
    is_active: Boolean
  ) -> T): Query<T> = Query(-1714438053, selectAll, driver, "CoinConfig.sq", "selectAll", """
  |SELECT *
  |FROM coinConfig
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!.toInt(),
      cursor.getLong(3)!!.toInt(),
      cursor.getString(4)!!,
      cursor.getLong(5)!! == 1L
    )
  }

  override fun selectAll(): Query<CoinConfig> = selectAll { coin_symbol, coin_name, coin_decimal,
      display_decimal, accent_color, is_active ->
    CoinConfig(
      coin_symbol,
      coin_name,
      coin_decimal,
      display_decimal,
      accent_color,
      is_active
    )
  }

  override fun insertConfig(
    coin_symbol: String,
    coin_name: String,
    coin_decimal: Int,
    display_decimal: Int,
    accent_color: String,
    is_active: Boolean
  ) {
    driver.execute(-299526587, """
    |INSERT INTO coinConfig (coin_symbol, coin_name, coin_decimal, display_decimal, accent_color, is_active)
    |VALUES (?,?,?,?,?,?)
    """.trimMargin(), 6) {
      bindString(1, coin_symbol)
      bindString(2, coin_name)
      bindLong(3, coin_decimal.toLong())
      bindLong(4, display_decimal.toLong())
      bindString(5, accent_color)
      bindLong(6, if (is_active) 1L else 0L)
    }
    notifyQueries(-299526587, {database.coinConfigQueries.selectAll})
  }

  override fun swithBySymbol(coin_symbol: String) {
    driver.execute(-787958274, """
    |UPDATE coinConfig
    |SET is_active = (is_active == 0)
    |WHERE coin_symbol = ?
    """.trimMargin(), 1) {
      bindString(1, coin_symbol)
    }
    notifyQueries(-787958274, {database.coinConfigQueries.selectAll})
  }
}
