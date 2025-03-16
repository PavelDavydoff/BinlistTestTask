package com.example.binlisttesttask.history.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.binlisttesttask.history.domain.models.Bin
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDao {
    @Insert(entity = BinEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertBin(binEntity: BinEntity)

    @Query("SELECT * FROM bin_table")
    fun getBins(): Flow<List<BinEntity>>
}