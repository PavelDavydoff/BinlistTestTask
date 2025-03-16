package com.example.binlisttesttask.search.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlisttesttask.history.domain.DbInteractor
import com.example.binlisttesttask.search.domain.BinInteractor
import com.example.binlisttesttask.search.domain.models.BinResponse
import kotlinx.coroutines.launch

class SearchViewModel(private val binInteractor: BinInteractor, private val historyInteractor: DbInteractor) : ViewModel() {
    private val stateLiveData = MutableLiveData<SearchState>()
    fun observeState(): LiveData<SearchState> = stateLiveData

    fun searchRequest(number: String) {
        viewModelScope.launch {
            val result = binInteractor.searchBin(number) as BinResponse

            if (result.resultCode == 200) {
                stateLiveData.postValue(SearchState.Content(result))
                historyInteractor.addBin(result, number.toInt())
            } else {
                stateLiveData.postValue(SearchState.Error(result.resultCode))
            }
            Log.d("Код ошибки", result.resultCode.toString())
            Log.d("Ответ сервера", result.toString())
        }
    }
}
