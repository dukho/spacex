package com.nomadworks.spacex

import android.app.Application
import timber.log.Timber

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