package com.myapp.myapplication.feature.dashboard.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myapp.business.core.callback.Status.*
import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.mvvmexample.core.view.BaseFragment
import com.myapp.mvvmexample.core.view.adapter.AdapterItemClicked
import com.myapp.myapplication.R
import com.myapp.myapplication.feature.dashboard.adapter.BankOfferAdapter
import com.myapp.myapplication.feature.dashboard.viewmodel.BankOfferViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject


class DashboardFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var bankOfferViewModel: BankOfferViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initBankOfferRecycler()
    }

    private fun initBankOfferRecycler() {
        var bankOfferAdapter = BankOfferAdapter(object : AdapterItemClicked<BankOfferInfo> {
            override fun onItemClicked(data: BankOfferInfo) {

            }
        })
        with(rbBanks) {
            adapter = bankOfferAdapter
            layoutManager = LinearLayoutManager(context)
        }

        bankOfferViewModel.registerOffers().observe(viewLifecycleOwner, Observer { response ->
            run {
                when {
                    response?.status == SUCCESS -> {
                        hideProgressDialog()
                        bankOfferAdapter.sources = response.data!!
                        bankOfferAdapter.notifyDataSetChanged()

                    }

                    response?.status == LOADING -> {
                        showProcessDialog()
                    }

                    response?.status == ERROR -> {
                        hideProgressDialog()
                    }
                }
            }
        })
        bankOfferViewModel.getBankOffer()
    }

    private fun initViewModel() {
        bankOfferViewModel = ViewModelProviders.of(this, viewModelFactory).get(BankOfferViewModel::class.java)

    }
}