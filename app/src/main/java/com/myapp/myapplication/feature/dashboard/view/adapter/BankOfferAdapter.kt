package com.myapp.myapplication.feature.dashboard.view.adapter

import android.view.ViewGroup
import com.myapp.business.feature.bank.info.BankOfferInfo
import com.myapp.mvvmexample.core.view.adapter.AdapterItemClicked
import com.myapp.mvvmexample.core.view.adapter.BaseAdapter
import com.myapp.mvvmexample.core.view.adapter.holder.BaseHolder
import com.myapp.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_bank.view.*

class BankOfferHolder(parent: ViewGroup) : BaseHolder<BankOfferInfo>(parent, R.layout.item_bank) {

    override fun bindData(model: BankOfferInfo) {
        var resource = itemView.context.resources
        itemView.tvInterestRate.text = resource.getString(R.string.bank_item_interest_rate, model.interestRate)
        itemView.tvMaxAmount.text = resource.getString(R.string.bank_item_max_amount, model.maxAmount)
        itemView.tvMaxTenor.text = resource.getString(R.string.bank_item_max_tenor, model.maxTenor)
        itemView.tvMinAmount.text = resource.getString(R.string.bank_item_min_amount, model.minAmount)
        itemView.tvMinTenor.text = resource.getString(R.string.bank_item_min_tenor, model.minTenor)
        Picasso.get().load(model.logoBankUrl).into(itemView.imgBankLogo)
    }

}

class BankOfferAdapter(itemClick: AdapterItemClicked<BankOfferInfo>) : BaseAdapter<BankOfferInfo, BankOfferHolder>(itemClick) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): BankOfferHolder {
        return BankOfferHolder(viewGroup)
    }

    override fun onBindViewHolder(holder: BankOfferHolder, position: Int) {
        holder.bindData(sources[position])
        holder.itemView.cardBank.setOnClickListener {
            itemClicked.onItemClicked(sources[position])
        }
    }
}