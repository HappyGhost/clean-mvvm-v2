package com.myapp.myapplication.feature.loan.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.myapp.business.core.callback.Status
import com.myapp.mvvmexample.core.view.BaseFragment
import com.myapp.myapplication.R
import com.myapp.myapplication.core.view.edittext.validation.EmptyValidationRule
import com.myapp.myapplication.core.view.edittext.validation.MinIncomeLoanValidationRule
import com.myapp.myapplication.core.view.edittext.validation.NationalIdValidationRule
import com.myapp.myapplication.core.view.edittext.validation.PhoneValidationRule
import com.myapp.myapplication.feature.loan.viewmodel.RegisterLoanViewModel
import kotlinx.android.synthetic.main.fragment_register_loan.*
import javax.inject.Inject


class RegisterLoanFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var registerLoanViewModel: RegisterLoanViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_loan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initValidationRule()
        initView()
        initProvinceField()
    }

    private fun initProvinceField() {
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, arrayListOf<String>())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        registerLoanViewModel.getProvinceLiveData().observe(this, Observer { response ->
            run {
                when {
                    response?.status == Status.LOADING -> {
                        showProcessDialog()
                    }
                    response?.status == Status.ERROR -> {
                        hideProgressDialog()
                    }
                    response?.status == Status.SUCCESS -> {
                        hideProgressDialog()
                        spinnerProvince.setAdapter(adapter)
                        adapter.clear()
                        adapter.addAll(response.data?.map { it.name }?.toMutableList()!!)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        })
        registerLoanViewModel.requestGetProvince()
    }

    private fun initViewModel() {
        registerLoanViewModel = ViewModelProviders.of(this, viewModelFactory).get(RegisterLoanViewModel::class.java)

    }

    private fun initView() {
        btnSubmit.setOnClickListener {
            var isValid = edtPhoneNumber.isValid()
            isValid = edtFullName.isValid() && isValid
            isValid = edtNationalId.isValid() && isValid
            isValid = edtMonthlyIncome.isValid() && isValid
            if (isValid) {
                registerLoanViewModel.submitLoanRequest(
                    edtPhoneNumber.text.toString(),
                    edtFullName.text.toString(),
                    edtNationalId.text.toString(),
                    spinnerProvince.selectedItem.toString(),
                    edtMonthlyIncome.text.toString()
                ).observe(this, Observer { response ->
                    run {
                        when {
                            response?.status == Status.SUCCESS -> {
                                showSuccess()
                            }
                        }

                    }
                })
            }

        }
    }

    private fun showSuccess() {
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    private fun initValidationRule() {
        edtPhoneNumber.addValidationRule(PhoneValidationRule(getString(R.string.error_phone_invalid)))

        edtFullName.addValidationRule(EmptyValidationRule(context!!))

        edtNationalId.isRequiredField = false
        edtNationalId.addValidationRule(NationalIdValidationRule(getString(R.string.error_national_id_invalid)))

        edtMonthlyIncome.addValidationRule(MinIncomeLoanValidationRule(getString(R.string.error_min_monthly_income)))
    }
}