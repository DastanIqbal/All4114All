package com.dastanIqbal.all4one

import com.dastanIqbal.model.DataM
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.net.HttpURLConnection

@RunWith(JUnit4::class)
class RepositoryTest : MockServerTest() {
    private val TAG = this::class.java.simpleName

    override fun setUp() {
        super.setUp()
        ApiWrapper.SERVICE_URL = getMockUrl()
    }

    @Test
    fun successResponse() {
        mockHttpResponse("users.json", HttpURLConnection.HTTP_OK)
        runBlocking {
            ApiWrapper.getAPI().getData()
                .subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.trampoline())
                .subscribeWith(object : DisposableSingleObserver<List<DataM>>() {
                    override fun onSuccess(t: List<DataM>) {
                        val dataM = t.getOrNull(0)
                        Assert.assertEquals(10, (t as ArrayList).size)
                        Assert.assertEquals("4kQA1aQK8-Y", dataM?.id)
                        Assert.assertEquals("nicholaskampouris", dataM?.user?.username)
                        println("Passed")
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        }
    }
}