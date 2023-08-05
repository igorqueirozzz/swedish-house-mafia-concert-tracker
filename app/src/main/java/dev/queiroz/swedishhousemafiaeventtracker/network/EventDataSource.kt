package dev.queiroz.swedishhousemafiaeventtracker.network

import dev.queiroz.swedishhousemafiaeventtracker.model.Event

interface EventDataSource {

    suspend fun getEvents(): List<Event>
}