package jet.pack.compose.masterdetails.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jet.pack.compose.masterdetails.data.di.annotations.DispatcherDefault
import jet.pack.compose.masterdetails.data.di.annotations.DispatcherIO
import jet.pack.compose.masterdetails.data.di.annotations.DispatcherMain
import jet.pack.compose.masterdetails.data.di.annotations.DispatcherUnconfined
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class DispatchersModule {

    @Provides
    @DispatcherIO
    fun providesDispatcherIO() : CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DispatcherMain
    fun providesDispatcherMain() : CoroutineDispatcher = Dispatchers.Main

    @Provides
    @DispatcherDefault
    fun providesDispatcherDefault() : CoroutineDispatcher= Dispatchers.Default

    @Provides
    @DispatcherUnconfined
    fun providesDispatcherUnConfined() : CoroutineDispatcher = Dispatchers.Unconfined
}