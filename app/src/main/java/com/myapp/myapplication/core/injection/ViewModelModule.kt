/*
 * Copyright (C) 2018 The Android Open Source Project
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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapp.mvvmexample.core.injection.BankViewModelFactory
import com.myapp.myapplication.feature.dashboard.viewmodel.BankOfferViewModel
import com.myapp.myapplication.feature.loan.viewmodel.RegisterLoanViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BankOfferViewModel::class)
    abstract fun bindBankOfferViewModel(bankOfferViewModel: BankOfferViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterLoanViewModel::class)
    abstract fun bindRegisterLoanViewModel(registerLoanViewModel: RegisterLoanViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: BankViewModelFactory): ViewModelProvider.Factory
}
