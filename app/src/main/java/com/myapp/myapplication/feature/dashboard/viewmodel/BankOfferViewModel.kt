package com.myapp.myapplication.feature.dashboard.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.myapp.business.core.callback.Resource
import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.business.feature.bank.usecase.GetBankOffersIUseCase
import javax.inject.Inject


class BankOfferViewModel @Inject constructor(private var getBankOfferUC: GetBankOffersIUseCase) : ViewModel() {

    fun registerOffers(): LiveData<Resource<List<BankOfferInfo>>> = getBankOfferUC.resultLiveData()

    fun getBankOffer() {
        getBankOfferUC.buildUseCase().execute()
    }
}