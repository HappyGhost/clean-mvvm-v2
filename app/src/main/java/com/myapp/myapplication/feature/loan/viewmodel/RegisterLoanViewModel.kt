package com.myapp.myapplication.feature.loan.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.myapp.business.core.callback.Resource
import com.myapp.business.feature.bank.usecase.GetListProvinceUseCase
import com.myapp.business.feature.bank.usecase.SubmitLoanUseCase
import javax.inject.Inject


class RegisterLoanViewModel @Inject constructor(
    private var getListProvinceUseCase: GetListProvinceUseCase,
    private var submitLoanUseCase: SubmitLoanUseCase
) : ViewModel() {

    fun getProvinceLiveData() = getListProvinceUseCase.resultLiveData()

    fun requestGetProvince() {
        getListProvinceUseCase.buildUseCase().execute()
    }

    fun submitLoanRequest(
        phoneNumber: String, fullName: String,
        nationalId: String, province: String, monthlyIncome: String
    ): LiveData<Resource<String>> {
        return submitLoanUseCase.buildUseCase(phoneNumber, fullName, nationalId, province, monthlyIncome).execute()
    }

}