package com.myapp.api.feature.bank.mapper

import com.myapp.api.core.mapper.BaseInfoMapper
import com.myapp.api.feature.bank.model.BankOfferModel
import com.myapp.api.feature.bank.model.BankOffersResponse
import com.myapp.business.feature.bank.info.BankOfferInfo


class BankOfferResponseMapper : BaseInfoMapper<List<BankOfferInfo>, BankOffersResponse>() {

    override fun transform(value: BankOffersResponse): List<BankOfferInfo> {
        var result = arrayListOf<BankOfferInfo>()
        for (bankOfferModel: BankOfferModel in value.offers) {
            var bankOfferInfo = BankOfferMapper().transform(bankOfferModel)
            result.add(bankOfferInfo)
        }
        return result
    }

}