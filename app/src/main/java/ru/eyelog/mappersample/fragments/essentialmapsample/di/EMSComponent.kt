package ru.eyelog.mappersample.fragments.essentialmapsample.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.mappersample.adapter.di.RVAdapterModule
import ru.eyelog.mappersample.fragments.essentialmapsample.EMSFragment

@Component(modules = [
    EMSModule::class,
    RVAdapterModule::class
])
interface EMSComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): EMSComponent
    }

    fun inject(fragment: EMSFragment)
}
