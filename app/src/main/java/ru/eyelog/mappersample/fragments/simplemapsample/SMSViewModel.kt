package ru.eyelog.mappersample.fragments.simplemapsample

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.eyelog.mappersample.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.mappersample.datasource.mappers.simple.SimpleMapper
import ru.eyelog.mappersample.datasource.models.dto.SampleDTO
import ru.eyelog.mappersample.datasource.models.to.SampleDO

class SMSViewModel (
    private val dataSampleGenerator: DataSampleGenerator,
    private val simpleMapper: SimpleMapper
): ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<List<SampleDO>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<SampleDO>>()

    var data = listOf<SampleDTO>()
    var outData = listOf<SampleDO>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        data = dataSampleGenerator.getDataList()
    }

    fun startThread(){

        Single.just(data)
            .map { simpleMapper.mapDTOtoTO(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                _sampleLiveData.value = data
            }
            .addTo(CompositeDisposable())
    }

    fun cleanList() {
        outData = listOf()
        _sampleLiveData.value = outData
    }
}