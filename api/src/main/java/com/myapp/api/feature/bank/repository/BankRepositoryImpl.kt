package com.myapp.api.feature.bank.repository

import com.myapp.api.core.repository.BaseApiRepository
import com.myapp.api.feature.bank.mapper.BankOfferResponseMapper
import com.myapp.api.feature.bank.service.BankService
import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.business.feature.bank.repository.BankRepository
import io.reactivex.Observable


open class BankRepositoryImpl(var service: BankService) : BaseApiRepository(), BankRepository {
    override fun getBankOfferList(): Observable<List<BankOfferInfo>> {
        return processRequest(service.getBankOffer().map { response -> BankOfferResponseMapper().transform(response) })
    }
}