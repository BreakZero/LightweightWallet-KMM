package com.dougie.wallet.shared.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EtherScanTxListResponse(
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: List<EtherTransactionInfo>,
    @SerialName("status")
    val status: String // 1 OK, 0 Error
)

@Serializable
data class EtherTransactionInfo(
    @SerialName("blockHash")
    val blockHash: String,
    @SerialName("blockNumber")
    val blockNumber: String,
    @SerialName("confirmations")
    val confirmations: String,
    @SerialName("contractAddress")
    val contractAddress: String,
    @SerialName("cumulativeGasUsed")
    val cumulativeGasUsed: String,
    @SerialName("from")
    val from: String,
    @SerialName("gas")
    val gas: String,
    @SerialName("gasPrice")
    val gasPrice: String,
    @SerialName("gasUsed")
    val gasUsed: String,
    @SerialName("hash")
    val hash: String,
    @SerialName("input")
    val input: String,
    @SerialName("isError")
    val isError: String,
    @SerialName("nonce")
    val nonce: String,
    @SerialName("timeStamp")
    val timeStamp: String,
    @SerialName("to")
    val to: String,
    @SerialName("transactionIndex")
    val transactionIndex: String,
    @SerialName("txreceipt_status")
    val txreceiptStatus: String,
    @SerialName("value")
    val value: String
)