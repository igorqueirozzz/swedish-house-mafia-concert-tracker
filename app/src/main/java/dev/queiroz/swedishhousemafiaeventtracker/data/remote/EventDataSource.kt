package dev.queiroz.swedishhousemafiaeventtracker.data.remote

import dev.queiroz.swedishhousemafiaeventtracker.model.Event

interface EventDataSource {
    suspend fun getEvents(): List<Event>
}