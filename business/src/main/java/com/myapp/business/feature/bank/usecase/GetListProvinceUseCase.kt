package com.myapp.business.feature.bank.usecase

import androidx.lifecycle.MutableLiveData
import com.myapp.business.core.callback.Resource
import com.myapp.business.core.usecase.BaseUseCase
import com.myapp.business.core.usecase.IUseCase
import com.myapp.business.feature.bank.info.ProvinceInfo
import com.myapp.business.feature.bank.repository.BankRepository
import com.myapp.business.feature.common.BusinessError


interface GetListProvinceUseCase : IUseCase<List<ProvinceInfo>> {
    fun buildUseCase(): GetListProvinceUseCase
}

class GetListProvinceUseCaseImpl(var bankRepository: BankRepository) :
    BaseUseCase<List<ProvinceInfo>>(), GetListProvinceUseCase {

    var listProvinceMutableLiveData = MutableLiveData<Resource<List<ProvinceInfo>>>()

    override fun resultLiveData(): MutableLiveData<Resource<List<ProvinceInfo>>> =
        listProvinceMutableLiveData

    override fun onError(e: Throwable) {
        listProvinceMutableLiveData.postValue(Resource.error(BusinessError.GENERAL_ERROR, null))
    }

    override fun buildUseCase(): GetListProvinceUseCase {
        observable = bankRepository.getListProvince()
        return this
    }

}