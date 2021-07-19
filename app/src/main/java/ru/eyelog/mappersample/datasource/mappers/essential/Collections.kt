@file:Suppress("NOTHING_TO_INLINE")

package ru.eyelog.mappersample.datasource.mappers.essential

import io.reactivex.functions.Function

inline fun <T, R : Any> List<T>.map(transform: Function<T, R>): List<R> {
    return map { transform.apply(it) }
}

inline fun <T, R : Any> List<T?>.mapNotNull(transform: Function<T, R>): List<R> {
    return mapNotNull { input -> input?.let { transform.apply(it) } }
}

inline fun <T> List<T?>?.deepAssert(): List<T> {
    return this!!.map { it!! }
}

inline fun <K, V> Map<K?, V?>?.filterNonNull(): Map<K, V> {
    if (this == null) return emptyMap()

    return entries.filter { it.value != null && it.key != null }
        .map { it.key!! to it.value!! }
        .toMap()
}

inline fun <T, R : Any> Sequence<T>.map(transform: Function<T, R>): Sequence<R> {
    return map { transform.apply(it) }
}

inline fun <T : Any> Sequence<T>.addIn(mutableCollection: MutableCollection<T>) {
    mutableCollection.addAll(this)
}

inline fun <T : Any> Collection<T>.addIn(mutableCollection: MutableCollection<T>) {
    mutableCollection.addAll(this)
}
