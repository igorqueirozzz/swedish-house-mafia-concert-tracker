package dev.queiroz.swedishhousemafiaeventtracker.network

import dev.queiroz.swedishhousemafiaeventtracker.data.remote.EventDataSource
import dev.queiroz.swedishhousemafiaeventtracker.model.Event
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class WebScrapingDataSource : EventDataSource {

    override suspend fun getEvents(): List<Event> {
        val url = "https://www.swedishhousemafia.com/"
        val document = Jsoup.connect(url).get()
        val contentElements = document.selectFirst("ul.filter_content")?.select("li")
        val events = mutableListOf<Event>()
        contentElements?.forEach { contentElement ->
            contentElement.select("a").forEach { linkElement ->
                events.add(
                    extractEventInfo(
                        linkElement = linkElement,
                        contentElement = contentElement
                    )
                )
            }
        }
        return events.filterNot { it.alreadyHappened }
    }

    private fun extractEventInfo(linkElement: Element, contentElement: Element): Event {
        val ticketLink = linkElement.attr("href")
        val date = linkElement.getElementsByClass("date").text()
        val name = linkElement.getElementsByClass("name").text()
        val location = linkElement.getElementsByClass("location").text()
        val city = linkElement.getElementsByClass("city").text()
        val alreadyHappened = contentElement.attr("class").contains("striketrough")
        return Event(date = date, ticketLink = ticketLink, name = name, location = location, city = city, alreadyHappened = alreadyHappened)
    }
}