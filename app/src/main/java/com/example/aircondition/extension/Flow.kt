package com.example.aircondition.extension

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun <T> Flow<T>.launchWithLifecycle(
    lifecycle:Lifecycle,
    state:Lifecycle.State,
    scope:CoroutineScope,
    block:(T)->Unit
){
    this.flowWithLifecycle(lifecycle, state)
        .onEach { block(it) }
        .launchIn(scope)
}
