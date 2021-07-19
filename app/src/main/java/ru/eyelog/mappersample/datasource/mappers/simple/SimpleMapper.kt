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
                    subName = it.name.orDefault(),
                    number =  it.number.orDefault(),
                    subNumber =  it.subNumber.orDefault(),
                    isChecked = it.isChecked.orDefault(),
                    type = SampleType.valueByCode(it.type.orDefault()),
                    data = mapSubDTOtoSubTO(it.data),
                    subData = mapSubDTOtoSubTO(it.subData),
                    dataList = mapSubDTOtoSubTOList(it.dataList),
                    subDataList = mapSubDTOtoSubTOList(it.subDataList)
                )
            )
        }
        return outData
    }

    private fun mapSubDTOtoSubTOList(data: List<SampleSubDTO>?): List<SampleSubDO>{

        val outData = mutableListOf<SampleSubDO>()

        data?.all {
            outData.add(
                mapSubDTOtoSubTO(it)
            )
        }
        return outData
    }

    private fun mapSubDTOtoSubTO(data: SampleSubDTO?) =
        SampleSubDO(
            id = data?.id.orDefault(),
            name = data?.name.orDefault(),
            number = data?.number.orDefault(),
            isChecked = data?.isChecked.orDefault(),
            typeMode = SampleType.valueByCode(data?.type.orDefault()),
        )
}
