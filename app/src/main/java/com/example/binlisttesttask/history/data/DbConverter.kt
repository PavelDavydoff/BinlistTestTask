package com.example.binlisttesttask.history.data

import com.example.binlisttesttask.history.db.BinEntity
import com.example.binlisttesttask.history.domain.Bin
import com.example.binlisttesttask.search.domain.models.BinResponse

class DbConverter {
    fun map(binResponse: BinResponse): BinEntity {
        return BinEntity(
            binResponse.scheme,
            binResponse.type,
            binResponse.brand,
            binResponse.country?.name,
            binResponse.bank?.name
        )
    }

    fun map(binEntity: BinEntity): Bin {
        return Bin(
            binEntity.scheme,
            binEntity.type,
            binEntity.brand,
            binEntity.country,
            binEntity.bank
        )
    }
}