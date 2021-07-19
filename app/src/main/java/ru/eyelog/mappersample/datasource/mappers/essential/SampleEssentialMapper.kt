package ru.eyelog.mappersample.datasource.mappers.essential

import ru.eyelog.mappersample.datasource.models.dto.SampleDTO
import ru.eyelog.mappersample.datasource.models.to.SampleDO
import ru.eyelog.mappersample.datasource.models.to.SampleSubDO
import ru.eyelog.mappersample.datasource.models.to.SampleType
import javax.inject.Inject

class SampleEssentialMapper @Inject constructor(
    val subSampleEssentialMapper: SubSampleEssentialMapper
) : EssentialMapper<SampleDTO, SampleDO>() {
    override fun transform(raw: SampleDTO): SampleDO {
        return raw.run {
            SampleDO(
                id = id,
                name = name.orDefault(),
                subName = name.orDefault(),
                number = number.orDefault(),
                subNumber = number.orDefault(),
                isChecked = isChecked.orDefault(),
                type = SampleType.valueByCode(type.orDefault()),
                data = data?.essentialMap(subSampleEssentialMapper) ?: SampleSubDO(),
                subData = subData?.essentialMap(subSampleEssentialMapper) ?: SampleSubDO(),
                dataList = dataList?.essentialMap(subSampleEssentialMapper) ?: emptyList(),
                subDataList = subDataList?.essentialMap(subSampleEssentialMapper) ?: emptyList()
            )
        }
    }
}
