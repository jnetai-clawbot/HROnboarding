package com.jnetai.hronboarding.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.jnetai.hronboarding.data.Converters

@Entity(tableName = "employees")
@TypeConverters(Converters::class)
data class Employee(
    val name: String = "",
    val department: String = "",
    val startDate: String = "",
    val status: Dept = Dept.values()[0],
    val mentorName: String = "",
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

enum class OnboardStatus(val label: String) {
    PENDING("Pending"),\n    IN_PROGRESS("In Progress"),\n    COMPLETED("Completed"),\n    TERMINATED("Terminated")
}

enum class Dept(val label: String) {
    ENGINEERING("Engineering"),\n    MARKETING("Marketing"),\n    SALES("Sales"),\n    HR("HR"),\n    FINANCE("Finance")
}
