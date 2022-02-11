package com.senex.timetable.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

private const val DEBUG_PREFIX = "app-debug"

internal fun Context.toast(message: String?) =
    message?.let {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    } ?: Unit

internal fun log(message: String?) =
    Log.d(DEBUG_PREFIX, message ?: "null")

internal fun Fragment.log(message: String?) =
    Log.d(DEBUG_PREFIX + ": " + this::class.java.simpleName, message ?: "null")