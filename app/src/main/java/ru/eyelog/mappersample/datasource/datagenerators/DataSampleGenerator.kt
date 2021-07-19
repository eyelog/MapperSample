package ru.eyelog.mappersample.datasource.datagenerators

import ru.eyelog.mappersample.datasource.models.dto.SampleDTO
import ru.eyelog.mappersample.datasource.models.dto.SampleSubDTO
import javax.inject.Inject

class DataSampleGenerator @Inject constructor() {

    fun getDataList(): List<SampleDTO>{

        val outData = mutableListOf<SampleDTO>()

        outData.add(
            SampleDTO(
                id = 0L,
                name = "name 0",
                subName = "name 0",
                number = 0,
                subNumber = 10,
                isChecked = true,
                type = "first type",
                data =  SampleSubDTO(
                    id = 0L,
                    name = "name 0",
                    number = 0,
                    isChecked = true,
                    type = "first type"
                ),
                subData =  SampleSubDTO(
                    id = 0L,
                    name = "name 0",
                    number = 0,
                    isChecked = true,
                    type = "first type"
                ),
                dataList = listOf(
                    SampleSubDTO(
                        id = 0L,
                        name = "name 0",
                        number = 0,
                        isChecked = true,
                        type = "first type"
                    )
                ),
                subDataList = listOf(
                    SampleSubDTO(
                        id = 0L,
                        name = "name 0",
                        number = 0,
                        isChecked = true,
                        type = "first type"
                    )
                )
            )
        )

        outData.add(
            SampleDTO(
                id = 0L,
                name = "name 0",
                subName = null,
                number = 1,
                subNumber = null,
                isChecked = null,
                type = null,
                data =  SampleSubDTO(
                    id = 0L,
                    name = "name 0",
                    number = 0,
                    isChecked = true,
                    type = "first type"
                ),
                subData =  null,
                dataList = listOf(
                    SampleSubDTO(
                        id = 0L,
                        name = "name 0",
                        number = 0,
                        isChecked = true,
                        type = "first type"
                    )
                ),
                subDataList = null
            )
        )

        outData.add(
            SampleDTO(
                id = 0L,
                name = "name 0",
                subName = null,
                number = null,
                subNumber = null,
                isChecked = null,
                type = null,
                data =  null,
                subData =  null,
                dataList = null,
                subDataList = null
            )
        )

        return outData
    }
}
