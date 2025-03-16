package com.example.binlisttesttask.history.ui.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.binlisttesttask.R
import com.example.binlisttesttask.history.domain.models.Bin
import com.example.binlisttesttask.history.ui.HistoryViewHolder

class HistoryAdapter : RecyclerView.Adapter<HistoryViewHolder>() {
    var bins = ArrayList<Bin>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_bin, parent, false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bins.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(bins[position])
    }
}