package comdougiewalletdb

import kotlin.Boolean
import kotlin.Int
import kotlin.String

data class CoinConfig(
  val coin_symbol: String,
  val coin_name: String,
  val coin_decimal: Int,
  val display_decimal: Int,
  val accent_color: String,
  val is_active: Boolean
) {
  override fun toString(): String = """
  |CoinConfig [
  |  coin_symbol: $coin_symbol
  |  coin_name: $coin_name
  |  coin_decimal: $coin_decimal
  |  display_decimal: $display_decimal
  |  accent_color: $accent_color
  |  is_active: $is_active
  |]
  """.trimMargin()
}
