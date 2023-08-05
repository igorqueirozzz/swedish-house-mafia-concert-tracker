package dev.queiroz.swedishhousemafiaeventtracker.model

data class Event(
    val date: String,
    val name: String,
    val location: String,
    val ticketLink: String,
    val city: String,
    val alreadyHappened: Boolean
)
