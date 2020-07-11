package com.nomadworks.spacex.types

sealed class Result<out S, out F> {
    data class Success<out S, out F>(val a: S) : Result<S, F>()
    data class Failure<out S, out F>(val b: F) : Result<S, F>()
}

fun <E> E.Success() = Result.Success<E, Nothing>(this)

fun <T> T.Failure() = Result.Failure<Nothing, T>(this)
