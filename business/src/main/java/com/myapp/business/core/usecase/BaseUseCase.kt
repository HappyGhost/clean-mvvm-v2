package com.myapp.business.core.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.myapp.business.core.callback.Resource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

interface IUseCase<T> {
    fun execute(): LiveData<Resource<T>>
    fun destroy()
    fun resultLiveData(): MutableLiveData<Resource<T>>
}

abstract class BaseUseCase<K> : IUseCase<K> {

    private var mDisposable: Disposable? = null

    protected var observable: Observable<K>? = null


    override fun execute(): LiveData<Resource<K>> {
        mDisposable = observable?.run {
            resultLiveData().postValue(Resource.loading(null))
            observeOn(AndroidSchedulers.mainThread())
            subscribeOn(Schedulers.io())
            subscribe({ info -> onSuccess(info) }, { throwable -> onError(throwable) })
        }
        return resultLiveData()
    }

    override fun destroy() {
        mDisposable?.run {
            dispose()
        }
    }

    abstract fun onError(e: Throwable)

    open fun onSuccess(info: K) {
        resultLiveData().postValue(Resource.success(info))
    }
}
