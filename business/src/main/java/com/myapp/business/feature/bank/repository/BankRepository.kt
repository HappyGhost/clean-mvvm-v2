package com.myapp.business.feature.bank.repository

import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.business.feature.bank.info.ProvinceInfo
import io.reactivex.Observable


interface BankRepository {
    fun getBankOfferList(): Observable<List<BankOfferInfo>>
    fun getListProvince(): Observable<List<ProvinceInfo>>
    fun submitLoan(
        phoneNumber: String, fullName: String,
        nationalId: String, province: String, monthlyIncome: String
    ): Observable<String>
}