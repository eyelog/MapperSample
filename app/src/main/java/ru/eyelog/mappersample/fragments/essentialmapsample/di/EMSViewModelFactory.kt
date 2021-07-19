package ru.eyelog.mappersample.fragments.essentialmapsample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.mappersample.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.mappersample.datasource.mappers.essential.SampleEssentialMapper
import ru.eyelog.mappersample.datasource.mappers.simple.SimpleMapper
import ru.eyelog.mappersample.fragments.essentialmapsample.EMSViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class EMSViewModelFactory @Inject constructor(
    private val dataSampleGenerator: DataSampleGenerator,
    private val simpleEssentialMapper: SampleEssentialMapper
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(EMSViewModel::class.java)) {
            return EMSViewModel(
                dataSampleGenerator,
                simpleEssentialMapper
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
