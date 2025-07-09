package com.mobile.rick_and_morty.di

import com.mobile.rick_and_morty.data.repository.CharacterDetailsRepositoryImpl
import com.mobile.rick_and_morty.domain.repository.CharacterDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Это 'легкий' вариант для инъекции(внедрения) зависимостей (для репозиториев) с использованием аннотации @Binds.
Этот способ инъекции зависимостей будет более правильно назвать 'связать зависимость' т.к. используем аннотацию @Binds.
Данный вариант работает только с абстрактн. классами/интерфейсами которые мы хотим заинжектить(внедрить).
Преимущество данного способа в том, что dagger-hilt генерирует чуть меньше кода для интерфейсов/абстактн классов
чем использование ф-ций с аннотацией @Provides (как показанно в файле [RepositoryModule.kt]).
Важно! Eсли используем данный способ, то необходимо пометить класс реализации как
'@Inject constructor' перед конструктором (как показанно в файле [CharacterDetailsRepositoryImpl]).
Если этого не сделать то будет ошибка т.к. dagger-hilt не знает как создать CharacterDetailsRepositoryImpl.
**/

// В данном приложении использую это вариант с использованием аннотации @Binds
// Аналогично и для CharacterRepositoryModule и EpisodeRepositoryModule.
@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterDetailsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharacterDetailsRepository(
        characterDetailsRepositoryImpl: CharacterDetailsRepositoryImpl
    ): CharacterDetailsRepository
}