package dev.queiroz.swedishhousemafiaeventtracker.data.repository

import dev.queiroz.swedishhousemafiaeventtracker.model.Event
import dev.queiroz.swedishhousemafiaeventtracker.data.remote.EventDataSource

interface EventRepository {
    suspend fun getEvents(): List<Event>
}