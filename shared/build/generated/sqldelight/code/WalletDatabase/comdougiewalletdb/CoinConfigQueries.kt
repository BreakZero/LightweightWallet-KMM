package comdougiewalletdb

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String

interface CoinConfigQueries : Transacter {
  fun <T : Any> selectAll(mapper: (
    coin_symbol: String,
    coin_name: String,
    coin_decimal: Int,
    display_decimal: Int,
    accent_color: String,
    is_active: Boolean
  ) -> T): Query<T>

  fun selectAll(): Query<CoinConfig>

  fun insertConfig(
    coin_symbol: String,
    coin_name: String,
    coin_decimal: Int,
    display_decimal: Int,
    accent_color: String,
    is_active: Boolean
  )

  fun swithBySymbol(coin_symbol: String)
}
