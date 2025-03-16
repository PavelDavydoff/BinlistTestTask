package com.example.binlisttesttask.history.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlisttesttask.history.domain.DbInteractor
import kotlinx.coroutines.launch

class HistoryViewModel(private val historyInteractor: DbInteractor) : ViewModel() {
    private val stateLiveData = MutableLiveData<HistoryState>()
    fun observeState(): LiveData<HistoryState> = stateLiveData

    fun getListOfBins() {
        viewModelScope.launch {
            historyInteractor.getBins().collect { bins ->
                val listOfBins = bins.toMutableList()
                if (listOfBins.isEmpty()) {
                    stateLiveData.postValue(HistoryState.Empty)
                } else {
                    stateLiveData.postValue(HistoryState.Content(listOfBins))
                }
            }
        }
    }
}