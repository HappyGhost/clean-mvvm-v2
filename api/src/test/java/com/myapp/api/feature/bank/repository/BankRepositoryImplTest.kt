package com.myapp.api.feature.bank.repository

import com.myapp.api.feature.bank.model.*
import com.myapp.api.feature.bank.service.BankService
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.reactivex.Observable
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class BankRepositoryImplTest {

    @MockK
    lateinit var service: BankService

    lateinit var repository: BankRepositoryImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = spyk(BankRepositoryImpl(service))
    }

    @Test
    fun `return response message when submit loan successful`() {
        val phoneNumber = "09090909"
        val fullName = "full name"
        val nationalId = "vn"
        val province = "LongAn"
        val monthlyIncome = "3000000"
        val incomeCode = 3000001
        val loanRequest = SubmitLoanRequest(phoneNumber, fullName, nationalId, province, incomeCode)
        val messageResponse = "successful"

        val response = mockk<Response<ResponseBody>>()
        every { service.submitLoan(eq(loanRequest)) } answers { Observable.just(response) }
        every { response.message() } answers { messageResponse }
        repository.submitLoan(phoneNumber, fullName, nationalId, province, monthlyIncome)
            .subscribe {
                Assert.assertEquals(messageResponse, it)
            }
    }

    @Test
    fun `submit loan api with income code equal 1 when monthlyIncome is below 3 millions`() {
        val phoneNumber = "09090909"
        val fullName = "full name"
        val nationalId = "vn"
        val province = "LongAn"
        val monthlyIncome = "2000000"
        val incomeCode = 1
        val loanRequest = SubmitLoanRequest(phoneNumber, fullName, nationalId, province, incomeCode)
        val messageResponse = "successful"

        val response = mockk<Response<ResponseBody>>()
        every { service.submitLoan(eq(loanRequest)) } answers { Observable.just(response) }
        every { response.message() } answers { messageResponse }
        repository.submitLoan(phoneNumber, fullName, nationalId, province, monthlyIncome)
            .subscribe {
                Assert.assertEquals(messageResponse, it)
            }

        verify {
            service.submitLoan(eq(loanRequest))
        }
    }

    @Test
    fun `submit loan api with income code equal 10000001 when monthlyIncome is from 10 millions`() {
        val phoneNumber = "09090909"
        val fullName = "full name"
        val nationalId = "vn"
        val province = "LongAn"
        val monthlyIncome = "20000000"
        val incomeCode = 10000001
        val loanRequest = SubmitLoanRequest(phoneNumber, fullName, nationalId, province, incomeCode)
        val messageResponse = "successful"

        val response = mockk<Response<ResponseBody>>()
        every { service.submitLoan(eq(loanRequest)) } answers { Observable.just(response) }
        every { response.message() } answers { messageResponse }
        repository.submitLoan(phoneNumber, fullName, nationalId, province, monthlyIncome)
            .subscribe {
                Assert.assertEquals(messageResponse, it)
            }

        verify {
            service.submitLoan(eq(loanRequest))
        }
    }

    @Test
    fun `return List province info when call get list province api successful`() {
        val provinceList = arrayListOf("HCM", "HN")
        val response = ProvincesResponse(provinceList)

        every { service.getListProvince() } answers { Observable.just(response) }
        repository.getListProvince().subscribe { response ->
            Assert.assertEquals(provinceList[0], response[0].name)
            Assert.assertEquals(provinceList[1], response[1].name)
        }
    }

    @Test
    fun `return BankOfferInfo List when call get bank offers api successful`() {
        val bankOfferModel = getBankOfferModel()
        val response = BankOffersResponse(arrayListOf(bankOfferModel))
        every { service.getBankOffer() } answers { Observable.just(response) }
        repository.getBankOfferList().subscribe { response ->
            Assert.assertEquals(response[0].minAmount, bankOfferModel.minAmount)
            Assert.assertEquals(response[0].maxAmount, bankOfferModel.maxAmount)
            Assert.assertEquals(response[0].minTenor, bankOfferModel.minTenor)
            Assert.assertEquals(response[0].maxTenor, bankOfferModel.maxTenor)
            Assert.assertEquals(response[0].interestRate, bankOfferModel.interestRate)
            Assert.assertEquals(response[0].bankName, bankOfferModel.bankModel.name)
            Assert.assertEquals(response[0].logoBankUrl, bankOfferModel.bankModel.logo)
        }
    }

    private fun getBankOfferModel(): BankOfferModel {
        val minAmount = "0"
        val maxAmount = "20000000"
        val minTenor = 0
        val maxTenor = 10
        val interestRate = 12.5f
        val bankName = "bank name"
        val bankLogo = "http://logo.png"
        val bankModel = BankModel(bankName, bankLogo)
        return BankOfferModel(minAmount, maxAmount, minTenor, maxTenor, interestRate, bankModel)
    }
}