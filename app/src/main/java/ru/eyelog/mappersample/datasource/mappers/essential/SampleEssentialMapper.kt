package ru.eyelog.mappersample.datasource.mappers.essential

import ru.eyelog.mappersample.datasource.models.dto.SampleDTO
import ru.eyelog.mappersample.datasource.models.to.SampleDO
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
                number = number.orDefault(),
                isChecked = isChecked.orDefault(),
                typeMode = SampleType.valueByCode(type),
                subData = subData.essentialMap(subSampleEssentialMapper),
                subDataList = subDataList.essentialMap(subSampleEssentialMapper)
            )
        }
    }
}
