package com.furkandursun.innova_case_study.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.furkandursun.innova_case_study.databinding.ItemCurrencyBinding
import com.furkandursun.innova_case_study.model.Currency

class CurrencyAdapter : ListAdapter<Currency, CurrencyAdapter.CurrencyViewHolder>(CurrencyDiffCallback()) {

    inner class CurrencyViewHolder(private val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: Currency) {
            binding.apply {
                nameTextView.text = currency.Isim
                currencyNameTextView.text = currency.CurrencyName
                forexBuyingTextView.text = currency.ForexBuying
                forexSellingTextView.text = currency.ForexSelling
                banknoteBuyingTextView.text = currency.BanknoteBuying
                banknoteSellingTextView.text = currency.BanknoteSelling
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val binding = ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
    }
}

class CurrencyDiffCallback : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem.Isim == newItem.Isim
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem == newItem
    }
}
