package com.paulsoia.githubauth.domain.interactors

import androidx.annotation.WorkerThread
import kotlinx.coroutines.*

abstract class BaseUseCase<Params, out Type> where Type: Any {

    // dispatchers
    private val UI = Dispatchers.Main
    private val BG = Dispatchers.Default

    // type for empty parameter
    class None

    // parameters

    protected var params: Params? = null

    fun withParams(params: Params) {
        this.params = params
    }

    // run

    @WorkerThread
    abstract suspend fun run() : Result<Type>

    @WorkerThread
    suspend fun runWithParams(params: Params) : Result<Type> {
        withParams(params)
        return run()
    }

    // invoke

    operator fun invoke(params: Params, onResult: (Result<Type>) -> Unit = {}): Deferred<Result<Type>> {
        withParams(params)
        val job = GlobalScope.async(BG) { run() }
        GlobalScope.launch(UI) {
            val r = job.await()
            if (isActive) onResult(r)
        }
        return job
    }

    operator fun invoke(onResult: (Result<Type>) -> Unit = {}): Deferred<Result<Type>> {
        val job = GlobalScope.async(BG) { run() }
        GlobalScope.launch(UI) {
            val r = job.await()
            if (isActive) onResult(r)
        }
        return job
    }

    // invoke + suspend

    suspend operator fun invoke(params: Params) : Result<Type> {
        withParams(params)
        return run()
    }

    suspend operator fun invoke(): Result<Type> {
        return run()
    }

}