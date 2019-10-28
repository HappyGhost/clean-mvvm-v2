package com.myapp.business.feature.bank.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.myapp.business.core.callback.Resource
import com.myapp.business.coretest.RxImmediateSchedulerRule
import com.myapp.business.coretest.captureValues
import com.myapp.business.feature.bank.repository.BankRepository
import com.myapp.business.feature.common.BusinessError
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
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

class SubmitLoanUseCaseImplTest {

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

    lateinit var usecase: SubmitLoanUseCaseImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        usecase = SubmitLoanUseCaseImpl(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `return response when submitting loan successfully`() {
        runBlocking {
            val phoneNumber = "0909090909"
            val fullName = "David"
            val nationId = "VN"
            val province = "HCM"
            val monthlyIncome = "1000"
            val response = ""
            every {
                repository.submitLoan(
                    phoneNumber,
                    fullName,
                    nationId,
                    province,
                    monthlyIncome
                )
            } answers { Observable.just(response) }

            usecase.resultLiveData().captureValues {
                usecase.buildUseCase(phoneNumber, fullName, nationId, province, monthlyIncome)
                usecase.execute()
                assertSendsValues(100, Resource.loading(null), Resource.success(response))
            }

            verify {
                repository.submitLoan(phoneNumber, fullName, nationId, province, monthlyIncome)
            }
        }
    }

    @Test
    fun `return error when submitting loan fail`() {
        runBlocking {
            val phoneNumber = "0909090909"
            val fullName = "David"
            val nationId = "VN"
            val province = "HCM"
            val monthlyIncome = "1000"
            every {
                repository.submitLoan(
                    phoneNumber,
                    fullName,
                    nationId,
                    province,
                    monthlyIncome
                )
            } answers { Observable.error(Throwable()) }

            usecase.resultLiveData().captureValues {
                usecase.buildUseCase(phoneNumber, fullName, nationId, province, monthlyIncome)
                usecase.execute()
                assertSendsValues(
                    100,
                    Resource.loading(null),
                    Resource.error(BusinessError.GENERAL_ERROR, null)
                )
            }

            verify {
                repository.submitLoan(phoneNumber, fullName, nationId, province, monthlyIncome)
            }
        }
    }
}