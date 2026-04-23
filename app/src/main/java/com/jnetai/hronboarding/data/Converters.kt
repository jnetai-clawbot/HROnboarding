package com.jnetai.hronboarding.data

import androidx.room.TypeConverter
import com.jnetai.hronboarding.model.OnboardStatus
import com.jnetai.hronboarding.model.Dept

class Converters {
    @TypeConverter fun fromOnboardStatus(v: OnboardStatus): String = v.name
    @TypeConverter fun toOnboardStatus(v: String): OnboardStatus = OnboardStatus.valueOf(v)
    @TypeConverter fun fromDept(v: Dept): String = v.name
    @TypeConverter fun toDept(v: String): Dept = Dept.valueOf(v)
}