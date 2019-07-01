package com.myapp.business.feature.bank.info


data class BankOfferInfo(
        var bankName: String?,
        var maxAmount: String?,
        var maxTenor: Int?,
        var minAmount: String?,
        var minTenor: Int?,
        var interestRate: Float?,
        var logoBankUrl: String?
)