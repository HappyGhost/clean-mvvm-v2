package com.myapp.business.feature.bank.usecase

import android.arch.lifecycle.MutableLiveData
import com.myapp.business.core.callback.Resource
import com.myapp.business.core.usecase.BaseUseCase
import com.myapp.business.core.usecase.IUseCase
import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.business.feature.bank.repository.BankRepository
import java.util.concurrent.TimeUnit


interface GetBankOffersIUseCase : IUseCase<List<BankOfferInfo>> {
    fun buildUseCase(): GetBankOffersIUseCase
}

open class GetBankOffersUseCaseImpl(var bankRepository: BankRepository) : BaseUseCase<List<BankOfferInfo>>(), GetBankOffersIUseCase {

    private val bankResult = MutableLiveData<Resource<List<BankOfferInfo>>>()
    override fun onError(e: Throwable) {
        bankResult.postValue(Resource.error(e.message, null))
    }

    override fun resultLiveData(): MutableLiveData<Resource<List<BankOfferInfo>>> = bankResult

    override fun buildUseCase(): GetBankOffersIUseCase {
        observable = bankRepository.getBankOfferList().delaySubscription(3, TimeUnit.SECONDS)
        return this
    }
}