package com.furkandursun.innova_case_study.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.furkandursun.innova_case_study.databinding.ItemCryptoBinding
import com.furkandursun.innova_case_study.model.CryptoModel

class CryptoAdapter : ListAdapter<CryptoModel, CryptoAdapter.CryptoViewHolder>(CryptoModelDiffCallback()) {

    inner class CryptoViewHolder(private val binding: ItemCryptoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crypto: CryptoModel) {
            binding.apply {
                // Set the data to the views
                nameTextView.text = crypto.name
                symbolTextView.text = crypto.symbol
                priceTextView.text = crypto.current_price.toString()
                Glide.with(itemView.context)
                    .load(crypto.image)
                    .into(imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = ItemCryptoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = getItem(position)
        holder.bind(crypto)
    }
}

class CryptoModelDiffCallback : DiffUtil.ItemCallback<CryptoModel>() {
    override fun areItemsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean {
        return oldItem == newItem
    }
}
