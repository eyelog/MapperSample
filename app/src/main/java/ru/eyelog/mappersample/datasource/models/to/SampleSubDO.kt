package ru.eyelog.mappersample.datasource.models.to

data class SampleSubDO (
    val id: Long,
    val name: String,
    val number: Int,
    val isChecked: Boolean,
    val typeMode: SampleType
)
