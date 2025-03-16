package com.example.binlisttesttask.search.di
import com.example.binlisttesttask.search.data.NetworkClient
import com.example.binlisttesttask.search.data.RepositoryImpl
import com.example.binlisttesttask.search.data.RetrofitNetworkClient
import com.example.binlisttesttask.search.domain.BinInteractor
import com.example.binlisttesttask.search.domain.BinInteractorImpl
import com.example.binlisttesttask.search.domain.Repository
import org.koin.dsl.module

val searchModule = module {

    factory<NetworkClient> {
        RetrofitNetworkClient()
    }
    factory<Repository> {
        RepositoryImpl(get())
    }
    factory<BinInteractor> {
        BinInteractorImpl(get())
    }
}