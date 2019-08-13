package com.dastaniqbal.library

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.mockito.MockitoAnnotations
import java.io.File


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

    private fun getJson(path: String): String {
        val uri = javaClass.classLoader?.getResource(path)!!
        val file = File(uri.path)
        return String(file.readBytes())
    }
}