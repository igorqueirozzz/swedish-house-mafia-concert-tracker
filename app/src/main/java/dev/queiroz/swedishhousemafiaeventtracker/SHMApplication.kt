package dev.queiroz.swedishhousemafiaeventtracker

import android.app.Application
import dev.queiroz.swedishhousemafiaeventtracker.data.ApplicationContainer
import dev.queiroz.swedishhousemafiaeventtracker.data.DefaultApplicationContainer

class SHMApplication : Application() {
    lateinit var container : ApplicationContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultApplicationContainer()
    }
}