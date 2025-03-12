package com.example.binlisttesttask.search.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlisttesttask.search.domain.BinInteractor
import com.example.binlisttesttask.search.domain.BinInteractorImpl
import com.example.binlisttesttask.search.domain.models.BinResponse
import kotlinx.coroutines.launch

class SearchViewModel(private val binInteractor: BinInteractor) : ViewModel() {
    private val stateLiveData = MutableLiveData<SearchState>()
    fun observeState(): LiveData<SearchState> = stateLiveData

    fun searchRequest(number: String){
        viewModelScope.launch {
            val result = binInteractor.searchBin(number)
            stateLiveData.postValue(SearchState.Content(result))
            }
        }
    }
