package com.jnetai.hronboarding.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jnetai.hronboarding.model.Employee

@Database(entities = [Employee::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class HROnboardingDatabase : RoomDatabase() {
    abstract fun dao(): HROnboardingDao
    companion object {
        @Volatile private var INSTANCE: HROnboardingDatabase? = null
        fun getInstance(context: Context): HROnboardingDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, HROnboardingDatabase::class.java, "employee_db")
                .fallbackToDestructiveMigration().build().also { INSTANCE = it }
        }
    }
}