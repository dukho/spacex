package com.nomadworks.spacex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SpacexApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initLogging()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Timber.d("[spacex] Hey I'm in")
    }
}