package com.myapp.api.feature.bank.repository

import com.myapp.api.core.repository.BaseApiRepository
import com.myapp.api.feature.bank.mapper.BankOfferResponseMapper
import com.myapp.api.feature.bank.mapper.ProvincesResponseMapper
import com.myapp.api.feature.bank.mapper.SubmitLoanResponseMapper
import com.myapp.api.feature.bank.model.SubmitLoanRequest
import com.myapp.api.feature.bank.service.BankService
import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.business.feature.bank.info.ProvinceInfo
import com.myapp.business.feature.bank.repository.BankRepository
import io.reactivex.Observable


class BankRepositoryImpl(private var service: BankService) : BaseApiRepository(), BankRepository {

    override fun submitLoan(
        phoneNumber: String,
        fullName: String,
        nationalId: String,
        province: String,
        monthlyIncome: String
    ): Observable<String> {
        val income = when {
            monthlyIncome.toDouble() < 3000000 -> 1
            monthlyIncome.toDouble() in 3000000..9999999 -> 3000001
            else -> 10000001
        }
        val submitLoanRequest = SubmitLoanRequest(phoneNumber, fullName, nationalId, province, income)
        return processRequest(service.submitLoan(submitLoanRequest).map { response ->
            SubmitLoanResponseMapper().transform(
                response
            )
        })
    }

    override fun getListProvince(): Observable<List<ProvinceInfo>> {
        return processRequest(service.getListProvince().map
        { response -> ProvincesResponseMapper().transform(response) })
    }

    override fun getBankOfferList(): Observable<List<BankOfferInfo>> {
        return processRequest(service.getBankOffer().map
        { response -> BankOfferResponseMapper().transform(response) })
    }
}