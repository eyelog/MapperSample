package ru.eyelog.mappersample.datasource.models.dto

import ru.eyelog.mappersample.datasource.mappers.essential.NotRequired

data class SampleSubDTO (
    val id: Long,
    @NotRequired val name: String?,
    @NotRequired val number: Int?,
    @NotRequired val isChecked: Boolean?,
    val type: String
)
