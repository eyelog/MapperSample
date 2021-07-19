package ru.eyelog.mappersample.datasource.models.to

enum class SampleType(val code: String) {
    FIRST_TYPE ("first type"),
    SECOND_TYPE ("second type"),
    THIRD_TYPE ("third type"),
    DEFAULT_TYPE ("default type");

    companion object {
        fun valueByCode(code: String): SampleType = code.let {
            values().find { it.code == code } ?: DEFAULT_TYPE
        }
    }
}
