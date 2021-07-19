package ru.eyelog.mappersample.datasource.mappers.essential

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

fun <T : Any, R : Any> T.essentialMap(mapper: EssentialMapper<T, R>): R = let(mapper::invoke)

fun <T : Any, R : Any> List<T>.essentialMap(mapper: EssentialMapper<T, R>): List<R> {
    return deepAssert().map(mapper)
}

fun <T : Any, R : Any> Single<T>.essentialMap(mapper: EssentialMapper<T, R>): Single<R> =
    map(mapper)

fun <T : Any, R : Any> Single<List<T>>.essentialSingleListMap(mapper: EssentialMapper<T, R>): Single<List<R>> {
    return this.map { it.essentialMap(mapper)}
}

fun <T : Any, R : Any> Observable<T>.essentialMap(mapper: EssentialMapper<T, R>): Observable<R> =
    map(mapper)

fun <T : Any, R : Any> Flowable<T>.essentialMap(mapper: EssentialMapper<T, R>): Flowable<R> =
    map(mapper)

fun <T : Any, R : Any> Maybe<T>.essentialMap(mapper: EssentialMapper<T, R>): Maybe<R> = map(mapper)
