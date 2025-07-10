package com.mobile.rick_and_morty.di


// Classic approach to inject dependencies (or when we don't have access to the class/interface)
//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//
//    @Singleton
//    @Provides
//    fun provideCharacterRepository(api: RickAndMortyApi): CharacterRepository {
//        return CharacterRepositoryImpl(api)
//    }
//
//    @Singleton
//    @Provides
//    fun provideCharacterDetailsRepository(api: RickAndMortyApi): CharacterDetailsRepository {
//        return CharacterDetailsRepositoryImpl(api)
//    }
//
//    @Singleton
//    @Provides
//    fun provideEpisodeRepository(api: RickAndMortyApi): EpisodeRepository {
//        return EpisodeRepositoryImpl(api)
//    }
//
//}