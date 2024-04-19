package com.example.touroperators.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.touroperators.Dao.OperatorDao
import com.example.touroperators.DbModels.OperatorDb

@Database (entities = [OperatorDb::class], version = 1)
abstract class Db() : RoomDatabase() {

    abstract fun operatorDao(): OperatorDao

    companion object {
        private const val DATABASE_NAME = "touroperators.db"

        fun getDatabase(context: Context): Db {
            return Room.databaseBuilder(
                context,
                Db::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}