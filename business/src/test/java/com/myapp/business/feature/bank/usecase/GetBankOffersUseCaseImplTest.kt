package com.myapp.business.feature.bank.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.myapp.business.core.callback.Resource
import com.myapp.business.coretest.RxImmediateSchedulerRule
import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.business.feature.bank.repository.BankRepository
import io.mockk.*
import io.reactivex.Observable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.ClassRule
import org.junit.Test
import java.util.concurrent.TimeUnit

class GetBankOffersUseCaseImplTest {

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()

        @ClassRule
        @JvmField
        val instantTaskExecutorRule = InstantTaskExecutorRule()
    }

    @After
    fun afterEndEveryTestCase() = RxJavaPlugins.reset()

    /* This is the way which i refer google example and article about unit test RX and live data*/
    @Test
    fun `call onSuccess when usecase is executed successful`() {
        val repository = mockk<BankRepository>()
        val observer = mockk<Observer<Resource<List<BankOfferInfo>>>>()
        val usecase = GetBankOffersUseCaseImpl(repository)
        val listBankInfo = arrayListOf<BankOfferInfo>()
        every { repository.getBankOfferList() } answers { Observable.just(listBankInfo) }
        every { observer.onChanged(any()) } just runs

        val testScheduler = TestScheduler()
        RxJavaPlugins.setComputationSchedulerHandler { testScheduler }

        usecase.resultLiveData().observeForever(observer)
        usecase.buildUseCase()
        usecase.execute()

        testScheduler.advanceTimeBy(4, TimeUnit.SECONDS)

        verifyOrder {
            repository.getBankOfferList()
            observer.onChanged(Resource.loading(null))
            observer.onChanged(Resource.success(listBankInfo))
        }
    }


    /* This is the way which i try using mock the useCase implementation instead of observer*/
    @Test
    fun `call onError when usecase is executed fail`() {
        val repository = mockk<BankRepository>()
        val usecase = spyk(GetBankOffersUseCaseImpl(repository))
        every { repository.getBankOfferList() } answers { Observable.error(Throwable("")) }
        usecase.buildUseCase()
        usecase.execute()

        verifyOrder {
            repository.getBankOfferList()
            usecase.onError(any())
        }

        verify(exactly = 0) {
            usecase.onSuccess(any())
        }
    }
}