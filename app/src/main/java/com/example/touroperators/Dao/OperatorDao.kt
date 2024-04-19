package com.example.touroperators.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.touroperators.DbModels.OperatorDb
import kotlinx.coroutines.flow.Flow

@Dao
interface OperatorDao {
    @Insert
    fun addOperator(operator: OperatorDb)

    @Query("SELECT * FROM operators")
    fun getOperators(): Flow<List<OperatorDb>>

    @Query("SELECT * FROM operators WHERE id = :id")
    fun getOperatorById(id: Int): OperatorDb
}
