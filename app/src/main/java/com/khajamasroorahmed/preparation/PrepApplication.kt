package com.khajamasroorahmed.preparation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PrepApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}