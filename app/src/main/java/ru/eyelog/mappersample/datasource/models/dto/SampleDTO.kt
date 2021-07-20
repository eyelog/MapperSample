package ru.eyelog.mappersample.datasource.models.dto

import ru.eyelog.mappersample.datasource.mappers.essential.NotRequired

/*
* С помощью аннотации @NotRequired можно указать EssentialMapper переменные, которые не подлежат
* nullable контролю. Переменная не помеченная @NotRequired будет обработана EssentialMapper
* */

data class SampleDTO(
    val id: Long,
    val name: String?,
    val subName: String?,
    val number: Int?,
    @NotRequired val subNumber: Int?,
    val isChecked: Boolean?,
    val type: String?,
    val data: SampleSubDTO?,
    @NotRequired val subData: SampleSubDTO?,
    val dataList: List<SampleSubDTO>?,
    val subDataList: List<SampleSubDTO>?
)
