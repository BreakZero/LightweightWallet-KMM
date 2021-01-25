package com.dougie.wallet.shared.ktor

import co.touchlab.kermit.Kermit
import com.dougie.wallet.shared.model.response.EtherScanTxListResponse
import com.dougie.wallet.shared.model.response.EtherTransactionInfo
import io.ktor.client.HttpClient
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

class BlockChairApiImpl : BlockChairApi {
    private val kermit = Kermit()
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    kermit.d("Network") {
                        message
                    }
                }
            }
            level = LogLevel.ALL
        }
    }

    override suspend fun txHistoryFromEtherscan(): List<EtherTransactionInfo> {
        return client.get<EtherScanTxListResponse> {
            url("https://api.etherscan.io/api?module=account&action=txlist&address=0x81080a7e991bcdddba8c2302a70f45d6bd369ab5&sort=asc&page=1&offset=10&apikey=apikey")
        }.result
    }
}