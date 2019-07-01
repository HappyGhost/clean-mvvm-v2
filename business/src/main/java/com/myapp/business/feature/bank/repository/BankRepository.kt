package com.myapp.business.feature.bank.repository

import com.myapp.business.feature.bank.info.BankOfferInfo
import io.reactivex.Observable


interface BankRepository {
    fun getBankOfferList(): Observable<List<BankOfferInfo>>
}