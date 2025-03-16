package com.example.binlisttesttask.history.ui.models

import com.example.binlisttesttask.history.domain.models.Bin

sealed interface HistoryState {
    data class Content(val listOfBins: List<Bin>) : HistoryState
    data object Empty : HistoryState
}