package com.amk.superfollower.util

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler

val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    Log.e("CoroutineError", "error -> ${throwable.message}")
}