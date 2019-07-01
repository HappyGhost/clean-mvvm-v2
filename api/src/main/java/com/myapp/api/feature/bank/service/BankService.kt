package com.myapp.api.feature.bank.service

import com.myapp.api.feature.bank.model.BankOffersResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface BankService {

    @GET("/offer")
    fun getBankOffer(): Observable<BankOffersResponse>
}