package com.example.binlisttesttask.search.ui.models

import com.example.binlisttesttask.search.domain.models.BinResponse

sealed interface SearchState {
    data class Content(val bin: BinResponse) : SearchState
    data class Error(val errorCode: Int) : SearchState
}