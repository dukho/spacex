package com.nomadworks.spacex.resource

import androidx.annotation.ArrayRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

interface ResourceQuery {
    fun getString(@StringRes resId: Int): String
    fun getString(@StringRes resId: Int, param: String): String
    fun getStringArray(@ArrayRes resId: Int): Array<String>
    fun getQuantityString(@PluralsRes resId: Int, count: Int, param: String = ""): String

    fun getDeviceId(): String
    fun getVersionInfo(): String
    fun getVersionName(): String
    fun getVersionCode(): String
    fun getBaseUrl(): String
}