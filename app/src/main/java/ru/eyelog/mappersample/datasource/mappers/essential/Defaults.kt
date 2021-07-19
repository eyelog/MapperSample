@file:Suppress("NOTHING_TO_INLINE")

package ru.eyelog.mappersample.datasource.mappers.essential

import java.util.Date

inline fun Byte?.orDefault(default: Byte = 0): Byte = this ?: default

inline fun Short?.orDefault(default: Short = 0): Short = this ?: default

inline fun Int?.orDefault(default: Int = 0): Int = this ?: default

inline fun Long?.orDefault(default: Long = 0): Long = this ?: default

inline fun Float?.orDefault(default: Float = 0f): Float = this ?: default

inline fun Double?.orDefault(default: Double = 0.0): Double = this ?: default

inline fun String?.orDefault(defaultValue: String = ""): String = this ?: defaultValue

inline fun Date?.orDefault(): Date = this ?: Date(0)

inline fun Boolean?.orDefault(): Boolean = this ?: false
