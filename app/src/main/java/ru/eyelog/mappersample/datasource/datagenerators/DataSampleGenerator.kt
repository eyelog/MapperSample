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
                number = null,
                isChecked = null,
                type = "first type",
                subData =  SampleSubDTO(
                    id = 0L,
                    name = "name 0",
                    number = 0,
                    isChecked = true,
                    type = "first type"
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
                id = 1L,
                name = "name 1",
                number = 3,
                isChecked = true,
                type = "second type",
                subData = SampleSubDTO(
                    id = 0L,
                    name = "name 1",
                    number = 0,
                    isChecked = true,
                    type = "second type"
                ),
                subDataList = listOf(
                    SampleSubDTO(
                        id = 0L,
                        name = "name 1",
                        number = 0,
                        isChecked = true,
                        type = "second type"
                    )
                )
            )
        )

        return outData
    }
}
