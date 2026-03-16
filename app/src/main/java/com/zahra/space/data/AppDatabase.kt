package com.zahra.space.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zahra.space.data.dao.QuranDao
import com.zahra.space.data.entity.QuranAyat

@Database(
    entities = [QuranAyat::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quranDao(): QuranDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "zahra_space.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
