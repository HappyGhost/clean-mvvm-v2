/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.example.github.di

import android.app.Application
import com.myapp.api.feature.bank.repository.BankRepositoryImpl
import com.myapp.api.feature.bank.service.BankService
import com.myapp.business.feature.bank.repository.BankRepository
import com.myapp.business.feature.bank.usecase.*
import com.myapp.myapplication.feature.mock.FakeInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient2(interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.cache(null)
        builder.followRedirects(false)
        builder.followSslRedirects(false)
        builder.addInterceptor(interceptor)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApiAdapter(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://feeds.bbci.co.uk")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideInterceptor(application: Application): Interceptor {
        return FakeInterceptor(application.applicationContext)
    }

    @Provides
    fun provideGetBankOfferUc(repository: BankRepository): GetBankOffersIUseCase {
        return GetBankOffersUseCaseImpl(repository)
    }

    @Provides
    fun provideBankRepository(retrofit: Retrofit): BankRepository {
        return BankRepositoryImpl(retrofit.create(BankService::class.java))
    }

    @Provides
    fun provideGetProvincesUc(repository: BankRepository): GetListProvinceUseCase {
        return GetListProvinceUseCaseImpl(repository)
    }

    @Provides
    fun provideSubmitLoanUseCase(repository: BankRepository): SubmitLoanUseCase {
        return SubmitLoanUseCaseImpl(repository)
    }
}
