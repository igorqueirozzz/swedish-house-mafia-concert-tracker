package dev.queiroz.swedishhousemafiaeventtracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.queiroz.swedishhousemafiaeventtracker.data.remote.EventDataSource
import dev.queiroz.swedishhousemafiaeventtracker.data.repository.EventRepository
import dev.queiroz.swedishhousemafiaeventtracker.data.repository.impl.EventRepositoryImpl
import dev.queiroz.swedishhousemafiaeventtracker.network.WebScrapingDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesEventDataSource(): EventDataSource {
        return WebScrapingDataSource()
    }

    @Provides
    @Singleton
    fun providesEventRepository(eventDataSource: EventDataSource) : EventRepository {
        return EventRepositoryImpl(eventDataSource)
    }
}