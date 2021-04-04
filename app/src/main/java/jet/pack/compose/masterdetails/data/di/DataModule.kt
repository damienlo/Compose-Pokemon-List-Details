package jet.pack.compose.masterdetails.data.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jet.pack.compose.masterdetails.data.remote.PokemonService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    fun providesMoshiConverterFactory(): MoshiConverterFactory =
        MoshiConverterFactory.create()

    @Provides
    fun providesCoroutinesCallAdapterFactory(): CoroutineCallAdapterFactory =
        CoroutineCallAdapterFactory()

    @Provides
    @Singleton
    fun providesRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        coroutinesCallAdapterFactory: CoroutineCallAdapterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(moshiConverterFactory)
        .addCallAdapterFactory(coroutinesCallAdapterFactory)
        .build()

    @Provides
    fun providesPokemonService(
        retrofit: Retrofit
    ): PokemonService =
        retrofit.create(PokemonService::class.java)

}