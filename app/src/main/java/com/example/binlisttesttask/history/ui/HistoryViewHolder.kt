package com.example.binlisttesttask.history.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.binlisttesttask.R
import com.example.binlisttesttask.history.domain.models.Bin

class HistoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val binNumber: TextView = itemView.findViewById(R.id.binNumber)
    private val scheme: TextView = itemView.findViewById(R.id.scheme)
    private val type: TextView = itemView.findViewById(R.id.type)
    private val brand: TextView = itemView.findViewById(R.id.brand)
    private val country: TextView = itemView.findViewById(R.id.country)
    private val bank: TextView = itemView.findViewById(R.id.bank)

    fun bind(bin: Bin) {
        binNumber.text = bin.binNumber.toString()
        scheme.text = bin.scheme
        type.text = bin.type
        brand.text = bin.brand
        country.text = bin.country
        bank.text = bin.bank
    }
}