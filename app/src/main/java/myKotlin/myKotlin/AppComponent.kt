package myKotlin.myKotlin

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dal.dal.DI.DatabaseModule
import dal.dal.DI.NetworkModule

@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}