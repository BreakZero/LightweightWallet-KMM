package com.dougie.wallet.shared.ktor

import com.dougie.wallet.shared.model.response.EtherTransactionInfo

interface BlockChairApi {
    suspend fun txHistoryFromEtherscan(): List<EtherTransactionInfo>
}