package com.github.rozag.kueue

import java.util.concurrent.Executor

class Kueue(
        private val workerExecutor: Executor,
        private val callbackExecutor: Executor
) {

    // TODO: tests

    fun <T> fromCallable(callable: () -> T) = perform<T> { onComplete, onError ->
        try {
            val result = callable()
            onComplete(result)
        } catch (throwable: Throwable) {
            onError(throwable)
        }
    }

    fun <T> perform(runTask: (onComplete: (T) -> Unit, onError: OnError) -> Unit) = Work(workerExecutor, callbackExecutor, runTask)

}