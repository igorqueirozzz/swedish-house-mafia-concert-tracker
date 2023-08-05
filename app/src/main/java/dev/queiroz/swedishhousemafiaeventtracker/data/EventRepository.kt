package dev.queiroz.swedishhousemafiaeventtracker.data

import dev.queiroz.swedishhousemafiaeventtracker.model.Event
import dev.queiroz.swedishhousemafiaeventtracker.network.EventDataSource

interface EventRepository {
    suspend fun getEvents(): List<Event>
}

class DefaultEventRepository(private val eventDataSource: EventDataSource) : EventRepository {
    override suspend fun getEvents(): List<Event> {
        return eventDataSource.getEvents()
    }
}