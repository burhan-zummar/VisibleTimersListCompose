package com.droid.visibletimerslist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class VisibleTimerViewModel: ViewModel() {

    val countDownFlow = flow<Int> {
        val startValue = 60
        var currentValue = startValue
        emit(currentValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }
}