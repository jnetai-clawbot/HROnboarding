package com.jnetai.hronboarding

import android.app.Application
import com.jnetai.hronboarding.data.HROnboardingDatabase

class HROnboardingApp : Application() {
    val database by lazy { HROnboardingDatabase.getInstance(this) }
}