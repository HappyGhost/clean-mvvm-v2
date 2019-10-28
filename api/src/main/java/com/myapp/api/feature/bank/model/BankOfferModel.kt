package com.myapp.api.feature.bank.model

import com.google.gson.annotations.SerializedName


data class BankOfferModel(
    @SerializedName("min_amount") val minAmount: String,
    @SerializedName("max_amount") val maxAmount: String,
    @SerializedName("min_tenor") val minTenor: Int,
    @SerializedName("max_tenor") val maxTenor: Int,
    @SerializedName("interest_rate") val interestRate: Float,
    @SerializedName("bank") val bankModel: BankModel
)