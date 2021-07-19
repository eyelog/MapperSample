package ru.eyelog.mappersample.datasource.models.to

data class SampleSubDO (
    val id: Long = 0L,
    val name: String = "",
    val number: Int = 0,
    val isChecked: Boolean= false,
    val typeMode: SampleType = SampleType.DEFAULT_TYPE
)
