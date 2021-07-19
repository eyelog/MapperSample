@file:Suppress("NOTHING_TO_INLINE")

package ru.eyelog.mappersample.datasource.mappers.essential

import io.reactivex.functions.Function

inline fun <T, R : Any> List<T>.map(transform: Function<T, R>): List<R> {
    return map { transform.apply(it) }
}

inline fun <T> List<T>.deepAssert(): List<T> {
    return this.map { it }
}
