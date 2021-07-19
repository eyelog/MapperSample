package ru.eyelog.mappersample.datasource.models.dto

import ru.eyelog.mappersample.datasource.mappers.essential.NotRequired

data class SampleSubDTO (
    val id: Long,
    val name: String?,
    val number: Int?,
    val isChecked: Boolean?,
    val type: String?
)
