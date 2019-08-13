package com.dastanIqbal.all4one.features

import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.mockito.MockitoAnnotations
import java.io.InputStream


open class MockServerTest {
    private val TAG = this::class.java.simpleName
    protected lateinit var mockServer: MockWebServer

    @Before
    open fun setUp() {
        MockitoAnnotations.initMocks(this)

        configureMockServer()
    }

    @After
    open fun tearDown() {
        stopMockServer()
    }

    private fun configureMockServer() {
        mockServer = MockWebServer()
        mockServer.start()
    }

    private fun stopMockServer() {
        mockServer.shutdown()
    }

    fun getMockUrl() = mockServer.url("/").toString()


    fun mockHttpResponse(fileName: String, responseCode: Int) =
        mockServer.enqueue(
            MockResponse()
                .setResponseCode(responseCode)
                .setBody(getJson(fileName))
        )

    fun getJson(path : String) : String {
        val inputStream: InputStream = InstrumentationRegistry.getInstrumentation().context.resources.assets.open(path)
        return inputStream.bufferedReader().use{it.readText()}
    }
}