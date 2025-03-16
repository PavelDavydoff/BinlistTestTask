package com.example.binlisttesttask.history.ui

import com.example.binlisttesttask.history.domain.Bin

sealed interface HistoryState {
    data class Content(val listOfBins: List<Bin>) : HistoryState
    data object Empty : HistoryState
}