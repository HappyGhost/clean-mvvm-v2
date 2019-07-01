package com.myapp.api.feature.bank.mapper

import com.myapp.api.core.mapper.BaseInfoMapper
import com.myapp.api.feature.bank.model.BankOfferModel
import com.myapp.business.feature.bank.info.BankOfferInfo


class BankOfferMapper : BaseInfoMapper<BankOfferInfo, BankOfferModel>() {
    override fun transform(value: BankOfferModel): BankOfferInfo {
        return BankOfferInfo(
            value.bankModel.name,
            value.maxAmount,
            value.maxTenor,
            value.minAmount,
            value.minTenor,
            value.InterestRate,
            value.bankModel.logo
        )
    }
}