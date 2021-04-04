package jet.pack.compose.masterdetails.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jet.pack.compose.masterdetails.data.IPokemonRepository
import jet.pack.compose.masterdetails.data.repository.PokemonRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsPokemonRepository(
        pokemonRepository: PokemonRepository
    ): IPokemonRepository

}