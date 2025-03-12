package com.example.binlisttesttask.search.UI

import com.example.binlisttesttask.search.domain.models.BinResponse

sealed interface SearchState {
    data class Content(val bin: BinResponse) : SearchState
    data object Error : SearchState
}