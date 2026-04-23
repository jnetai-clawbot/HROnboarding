package com.jnetai.hronboarding.data

import androidx.room.*
import com.jnetai.hronboarding.model.Employee

@Dao
interface HROnboardingDao {
    @Query("SELECT * FROM employees ORDER BY createdAt DESC") suspend fun getAll(): List<Employee>
    @Insert suspend fun insert(item: Employee): Long
    @Update suspend fun update(item: Employee)
    @Delete suspend fun delete(item: Employee)
}