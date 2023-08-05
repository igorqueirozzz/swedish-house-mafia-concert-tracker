package dev.queiroz.swedishhousemafiaeventtracker.network
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class WebScrapingDataSourceTest {

    @Test
    fun web_scraping_data_source_test(){
        val dataSource = WebScrapingDataSource()
        runTest {
           Assert.assertEquals(47, dataSource.getEvents().size)
        }
    }
}