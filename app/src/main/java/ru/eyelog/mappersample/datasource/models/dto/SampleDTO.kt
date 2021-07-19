package ru.eyelog.mappersample.datasource.models.dto

import ru.eyelog.mappersample.datasource.mappers.essential.NotRequired

data class SampleDTO(
    val id: Long,
    val name: String,
    @Deprecated("Test") val number: Int?,
    @NotRequired val isChecked: Boolean?,
    val type: String,
    val subData: SampleSubDTO,
    val subDataList: List<SampleSubDTO>
)
