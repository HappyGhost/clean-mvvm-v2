package com.myapp.api.feature.bank.service

import com.myapp.api.feature.bank.model.BankOffersResponse
import com.myapp.api.feature.bank.model.ProvincesResponse
import com.myapp.api.feature.bank.model.SubmitLoanRequest
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface BankService {

    @GET("/offer")
    fun getBankOffer(): Observable<BankOffersResponse>

    @GET("/provinces")
    fun getListProvince(): Observable<ProvincesResponse>

    @POST("/loans")
    fun submitLoan(@Body request: SubmitLoanRequest): Observable<Response<ResponseBody>>
}