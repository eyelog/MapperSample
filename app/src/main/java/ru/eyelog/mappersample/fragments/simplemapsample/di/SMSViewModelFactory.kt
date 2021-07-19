package ru.eyelog.mappersample.fragments.simplemapsample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.mappersample.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.mappersample.datasource.mappers.simple.SimpleMapper
import ru.eyelog.mappersample.fragments.simplemapsample.SMSViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class SMSViewModelFactory @Inject constructor(
    private val dataSampleGenerator: DataSampleGenerator,
    private val simpleMapper: SimpleMapper
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(SMSViewModel::class.java)) {
            return SMSViewModel(
                dataSampleGenerator,
                simpleMapper
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}