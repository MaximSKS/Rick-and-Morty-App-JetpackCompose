package com.mobile.rick_and_morty.di

/** Классический вариант для инъекции зависимостей (для репозиториев).
А также используем этот способ когда нет доступа к самому классу/интерфейсу (например класс Retrofit)**/

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