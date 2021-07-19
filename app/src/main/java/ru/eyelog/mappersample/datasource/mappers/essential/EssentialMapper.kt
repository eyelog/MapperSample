package ru.eyelog.mappersample.datasource.mappers.essential

import android.util.Log
import io.reactivex.functions.Function
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

abstract class EssentialMapper<T : Any, R> : Function<T, R> {
    private val missedParams = HashSet<String>()

    @Throws(EssentialParamMissingException::class)
    operator fun invoke(raw: T): R = apply(raw)

    @Throws(EssentialParamMissingException::class)
    final override fun apply(raw: T): R {
        missedParams.clear()
        checkMisses(raw)

        if (missedParams.isNotEmpty()) {
            throw EssentialParamMissingException(
                missedParams,
                raw
            )
        }

        return transform(raw)
    }

    protected abstract fun transform(raw: T): R

    private fun checkMisses(raw: T) {
        raw::class.memberProperties.forEach { property ->

            if (property.findAnnotation<NotRequired>() == null) {
                val value = property.getter.call(raw)

                Log.i("Logcat", "            ")
                Log.i("Logcat", "value $value")

                val statuses = ArrayList<String>()

                val additionChecks = globalChecks.asSequence()
                    .filter { it.first.isInstance(value) }
                    .map { it.second }

                val excludedChecks = property.annotations.asSequence()
                    .mapNotNull { it as? ExcludeCheck }
                    .map { it.expressionClass }

                Log.i("Logcat", "property.annotations ${property.annotations}")

                if (value != null) {
                    property.annotations.asSequence()
                        .mapNotNull { it as? Check }
                        .map { it.expressionClass }
                        .plus(additionChecks)
                        .minus(excludedChecks)
                        .map { it.objectInstance ?: it.createInstance() }
                        .map { it(value) }
                        .filter { it.isNotEmpty() }
                        .toCollection(statuses)

                    Log.i("Logcat", "property $property")
                    Log.i("Logcat", "property.parameters ${property.parameters}")
                } else {
                    Log.i("Logcat", "statuses.add(null)")
                    statuses.add("null")
                }

                Log.i("Logcat", "statuses $statuses")

                if (statuses.isNotEmpty()) {
                    missedParams.add("${property.name} $statuses")
                }
            }
        }
    }

    companion object {
        private val globalChecks = ArrayList<Pair<KClass<*>, KClass<out CheckerClass>>>()

        private fun addGlobalCheck(clsCheckPair: Pair<KClass<*>, KClass<out CheckerClass>>): Companion {
            globalChecks.add(clsCheckPair)
            return this
        }

        fun addGlobalCheck(
            clsToCheck: KClass<*>,
            clsWhoCheck: KClass<out CheckerClass>
        ): Companion {
            return addGlobalCheck(
                clsToCheck to clsWhoCheck
            )
        }
    }
}
