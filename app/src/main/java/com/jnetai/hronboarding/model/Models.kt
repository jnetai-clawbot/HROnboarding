package com.jnetai.hronboarding.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.jnetai.hronboarding.data.Converters

@Entity(tableName = "employees")
@TypeConverters(Converters::class)
data class Employee(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String = "",
    val department: Dept = Dept.values()[0],
    val startDate: String = "",
    val onboardingStatus: OnboardStatus = OnboardStatus.values()[0],
    val mentorName: String = "",
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

enum class OnboardStatus(val label: String) {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    TERMINATED("Terminated")
}

enum class Dept(val label: String) {
    ENGINEERING("Engineering"),
    MARKETING("Marketing"),
    SALES("Sales"),
    HR("HR"),
    FINANCE("Finance")
}
