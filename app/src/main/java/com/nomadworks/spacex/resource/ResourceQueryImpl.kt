package com.nomadworks.spacex.resource

import android.content.Context
import android.provider.Settings
import com.nomadworks.spacex.BuildConfig
import com.nomadworks.spacex.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceQueryImpl @Inject constructor(@ApplicationContext private val context: Context) : ResourceQuery {
    private val releaseConfig = if (BuildConfig.DEBUG) "DEBUG" else "RELEASE"

    override fun getString(resId: Int): String = context.getString(resId)
    override fun getString(resId: Int, param: String): String = getString(resId).format(param)
    override fun getStringArray(resId: Int): Array<String> = context.resources.getStringArray(resId)
    override fun getQuantityString(resId: Int, count: Int, param: String) = context.resources.getQuantityString(resId, count, param)

    override fun getDeviceId(): String = context.getDeviceId()
    override fun getVersionInfo(): String = "Version ${BuildConfig.FLAVOR} ${BuildConfig.VERSION_NAME} (build ${BuildConfig.VERSION_CODE}) - $releaseConfig"
    override fun getVersionName(): String = BuildConfig.VERSION_NAME
    override fun getVersionCode(): String = "${BuildConfig.VERSION_CODE}"

    override fun getBaseUrl(): String {
        return "${context.getString(R.string.base_host)}${context.getString(R.string.base_path)}"
    }

    private fun Context.getDeviceId() = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
}