package di.di.DI

import dagger.Component
import dal.dal.DI.AppModule
import myKotlin.myKotlin.MainActivity

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}