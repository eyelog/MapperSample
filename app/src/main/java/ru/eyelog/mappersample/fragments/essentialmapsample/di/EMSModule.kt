package ru.eyelog.mappersample.fragments.essentialmapsample.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.mappersample.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.mappersample.datasource.mappers.essential.SampleEssentialMapper
import ru.eyelog.mappersample.datasource.mappers.essential.SubSampleEssentialMapper
import ru.eyelog.mappersample.datasource.mappers.simple.SimpleMapper
import ru.eyelog.mappersample.fragments.essentialmapsample.EMSViewModel

@Module
class EMSModule {

    @Provides
    fun provideEMSViewModel(
        fragment: Fragment,
        factory: EMSViewModelFactory
    ): EMSViewModel = ViewModelProvider(fragment, factory).get(EMSViewModel::class.java)

    @Provides
    fun provideDataGenerator() = DataSampleGenerator()

    @Provides
    fun provideSampleEssentialMapper(subSampleEssentialMapper: SubSampleEssentialMapper) =
        SampleEssentialMapper(subSampleEssentialMapper)

    @Provides
    fun provideSubSampleEssentialMapper() = SubSampleEssentialMapper()
}