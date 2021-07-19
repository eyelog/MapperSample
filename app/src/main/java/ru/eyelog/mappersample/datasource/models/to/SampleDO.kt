package ru.eyelog.mappersample.datasource.models.to

data class SampleDO(
    val id: Long = 0L,
    val name: String = "",
    val subName: String = "",
    val number: Int = 0,
    val subNumber: Int = 0,
    val isChecked: Boolean = false,
    val type: SampleType = SampleType.FIRST_TYPE,
    val data: SampleSubDO = SampleSubDO(),
    val subData: SampleSubDO = SampleSubDO(),
    val dataList: List<SampleSubDO> = emptyList(),
    val subDataList: List<SampleSubDO> = emptyList()
)
