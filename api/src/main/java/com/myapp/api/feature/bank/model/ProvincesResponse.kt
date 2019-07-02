package com.myapp.api.feature.bank.model

import com.google.gson.annotations.SerializedName


data class ProvincesResponse(
        @SerializedName("provinces_list") var provinces: List<String>
)