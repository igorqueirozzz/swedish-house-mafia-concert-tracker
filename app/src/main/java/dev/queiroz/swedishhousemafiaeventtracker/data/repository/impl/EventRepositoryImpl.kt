package dev.queiroz.swedishhousemafiaeventtracker.data.repository.impl

import dev.queiroz.swedishhousemafiaeventtracker.data.remote.EventDataSource
import dev.queiroz.swedishhousemafiaeventtracker.data.repository.EventRepository
import dev.queiroz.swedishhousemafiaeventtracker.model.Event

class EventRepositoryImpl(private val eventDataSource: EventDataSource) : EventRepository {
    override suspend fun getEvents(): List<Event> {
        return eventDataSource.getEvents()
    }
}