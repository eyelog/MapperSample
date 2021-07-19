package ru.eyelog.mappersample.datasource.mappers.simple

import ru.eyelog.mappersample.datasource.mappers.essential.orDefault
import ru.eyelog.mappersample.datasource.models.dto.SampleDTO
import ru.eyelog.mappersample.datasource.models.dto.SampleSubDTO
import ru.eyelog.mappersample.datasource.models.to.SampleDO
import ru.eyelog.mappersample.datasource.models.to.SampleSubDO
import ru.eyelog.mappersample.datasource.models.to.SampleType

class SimpleMapper {

    fun mapDTOtoTO(data: List<SampleDTO>): List<SampleDO>{

        val outData = mutableListOf<SampleDO>()

        data.all {
            outData.add(
                SampleDO(
                    id = it.id,
                    name = it.name.orDefault(),
                    number =  it.number.orDefault(),
                    isChecked = it.isChecked.orDefault(),
                    typeMode = SampleType.valueByCode(it.type),
                    subData = mapSubDTOtoSubTO(it.subDataList)[0],
                    subDataList = mapSubDTOtoSubTO(it.subDataList)
                )
            )
        }
        return outData
    }

    private fun mapSubDTOtoSubTO(data: List<SampleSubDTO>): List<SampleSubDO>{

        val outData = mutableListOf<SampleSubDO>()

        data.all {
            outData.add(
                SampleSubDO(
                    id = it.id,
                    name = it.name.orDefault(),
                    number =  it.number.orDefault(),
                    isChecked = it.isChecked.orDefault(),
                    typeMode = SampleType.valueByCode(it.type),
                )
            )
        }
        return outData
    }
}
