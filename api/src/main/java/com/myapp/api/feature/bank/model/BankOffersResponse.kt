package com.myapp.api.feature.bank.model

import com.google.gson.annotations.SerializedName


data class BankOffersResponse(
    @SerializedName("offers") val offers: List<BankOfferModel>
)