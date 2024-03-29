package com.myapp.myapplication.feature.dashboard.view

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.myapp.business.core.callback.Status.*
import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.mvvmexample.core.view.BaseFragment
import com.myapp.mvvmexample.core.view.adapter.AdapterItemClicked
import com.myapp.myapplication.R
import com.myapp.myapplication.feature.dashboard.view.adapter.BankOfferAdapter
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
                Navigation.findNavController(rbBanks!!).navigate(R.id.registerLoanFragment)
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