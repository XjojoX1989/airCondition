package com.example.aircondition.extension

import android.os.Looper
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.updateValue(value: T) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        setValue(value)
    } else {
        postValue(value)
    }
}