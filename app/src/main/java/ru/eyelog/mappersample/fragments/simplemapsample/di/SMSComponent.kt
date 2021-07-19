package ru.eyelog.mappersample.fragments.simplemapsample.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.mappersample.adapter.di.RVAdapterModule
import ru.eyelog.mappersample.fragments.simplemapsample.SMSFragment

@Component(modules = [
    SMSModule::class,
    RVAdapterModule::class
])
interface SMSComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): SMSComponent
    }

    fun inject(fragment: SMSFragment)
}