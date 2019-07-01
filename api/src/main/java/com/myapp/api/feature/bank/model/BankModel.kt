package com.myapp.api.feature.bank.model

import com.google.gson.annotations.SerializedName


data class BankModel(
    @SerializedName("name") val name: String,
    @SerializedName("logo") val logo: String
)