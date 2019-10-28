package com.myapp.business.feature.bank.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.myapp.business.core.callback.Resource
import com.myapp.business.coretest.RxImmediateSchedulerRule
import com.myapp.business.coretest.captureValues
import com.myapp.business.feature.bank.info.ProvinceInfo
import com.myapp.business.feature.bank.repository.BankRepository
import com.myapp.business.feature.common.BusinessError
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verifyOrder
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test

/* Example using coroutines to do unit test*/

class GetListProvinceUseCaseImplTest {

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()

        @ClassRule
        @JvmField
        val instantTaskExecutorRule = InstantTaskExecutorRule()
    }

    private val testDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var repository: BankRepository

    lateinit var usecase: GetListProvinceUseCaseImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        usecase = GetListProvinceUseCaseImpl(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `return province info when getting province successfully`() {
        runBlocking {
            val response = arrayListOf<ProvinceInfo>()
            every { repository.getListProvince() } answers { Observable.just(response) }
            usecase.resultLiveData().captureValues {
                usecase.buildUseCase()
                usecase.execute()
                assertSendsValues(100, Resource.loading(null), Resource.success(response))
            }

            verifyOrder {
                repository.getListProvince()
            }
        }
    }

    @Test
    fun `call error when getting province fail`() {
        runBlocking {
            every { repository.getListProvince() } answers { Observable.error(Throwable()) }
            usecase.resultLiveData().captureValues {
                usecase.buildUseCase()
                usecase.execute()
                assertSendsValues(
                    100,
                    Resource.loading(null),
                    Resource.error(BusinessError.GENERAL_ERROR, null)

                )
            }

            verifyOrder {
                repository.getListProvince()
            }
        }
    }
}