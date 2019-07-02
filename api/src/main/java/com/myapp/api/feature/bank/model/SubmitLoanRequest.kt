package com.myapp.api.feature.bank.model

import com.google.gson.annotations.SerializedName


data class SubmitLoanRequest(
    @SerializedName("phone_number") var phoneNumber: String,
    @SerializedName("full_name") var fullName: String,
    @SerializedName("national_id_number") var nationalId: String,
    @SerializedName("province") var province: String,
    @SerializedName("monthly_income") var monthlyIncome: Int
)