package ru.eyelog.mappersample.fragments.simplemapsample.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.mappersample.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.mappersample.datasource.mappers.simple.SimpleMapper
import ru.eyelog.mappersample.fragments.simplemapsample.SMSViewModel

@Module
class SMSModule {

    @Provides
    fun provideEMSViewModel(
        fragment: Fragment,
        factory: SMSViewModelFactory
    ): SMSViewModel = ViewModelProvider(fragment, factory).get(SMSViewModel::class.java)

    @Provides
    fun provideDataGenerator() = DataSampleGenerator()

    @Provides
    fun provideSimpleMapper() = SimpleMapper()
}