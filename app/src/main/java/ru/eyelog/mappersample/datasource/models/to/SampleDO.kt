package ru.eyelog.mappersample.datasource.models.to

data class SampleDO(
    val id: Long,
    val name: String,
    val number: Int,
    val isChecked: Boolean,
    val typeMode: SampleType,
    val subData: SampleSubDO,
    val subDataList: List<SampleSubDO>
)
