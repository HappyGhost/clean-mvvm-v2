package com.myapp.business.feature.bank.usecase

import androidx.lifecycle.MutableLiveData
import com.myapp.business.core.callback.Resource
import com.myapp.business.core.callback.SingleLiveEvent
import com.myapp.business.core.usecase.BaseUseCase
import com.myapp.business.core.usecase.IUseCase
import com.myapp.business.feature.bank.repository.BankRepository


interface SubmitLoanUseCase : IUseCase<String> {
    fun buildUseCase(
        phoneNumber: String, fullName: String,
        nationalId: String, province: String, monthlyIncome: String
    ): SubmitLoanUseCase
}

class SubmitLoanUseCaseImpl(var bankRepository: BankRepository) : BaseUseCase<String>(), SubmitLoanUseCase {

    var submitLoanResultLiveData = SingleLiveEvent<Resource<String>>()
    override fun resultLiveData(): MutableLiveData<Resource<String>> = submitLoanResultLiveData

    override fun onError(e: Throwable) {
    }

    override fun buildUseCase(
        phoneNumber: String,
        fullName: String,
        nationalId: String,
        province: String,
        monthlyIncome: String
    ): SubmitLoanUseCase {
        observable = bankRepository.submitLoan(phoneNumber, fullName, nationalId, province, monthlyIncome)
        return this
    }
}