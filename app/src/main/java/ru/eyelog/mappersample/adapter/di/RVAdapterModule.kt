package ru.eyelog.mappersample.adapter.di

import dagger.Module
import dagger.Provides
import ru.eyelog.mappersample.adapter.RVAdapter

@Module
class RVAdapterModule {

    @Provides
    fun provideRVAdapter() = RVAdapter()
}
