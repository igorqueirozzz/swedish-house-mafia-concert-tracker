package dev.queiroz.swedishhousemafiaeventtracker.data

import dev.queiroz.swedishhousemafiaeventtracker.network.WebScrapingDataSource

interface ApplicationContainer {
    val eventRepository: EventRepository
}

class DefaultApplicationContainer : ApplicationContainer {
    private val eventDataSource = WebScrapingDataSource()
    override val eventRepository: EventRepository
        get() = DefaultEventRepository(eventDataSource = eventDataSource)
}