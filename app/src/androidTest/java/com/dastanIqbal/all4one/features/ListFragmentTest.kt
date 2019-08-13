package com.dastanIqbal.all4one.features

import androidx.arch.core.executor.testing.CountingTaskExecutorRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.dastanIqbal.all4one.MainActivity
import com.dastanIqbal.all4one.R
import com.dastanIqbal.all4one.utils.RecyclerViewMatcher
import com.dastanIqbal.all4one.utils.hasItemCount
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.net.HttpURLConnection


/**
 * Created by dastaniqbal on 12/07/2019.
 * 12/07/2019 11:18
 */
@RunWith(androidx.test.runner.AndroidJUnit4::class)
@LargeTest
class ListFragmentTest : MockServerTest() {
    private val TAG = this::class.java.simpleName
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @get:Rule
    var executorRule = CountingTaskExecutorRule()

    private fun withRecyclerViewItemId(pos: Int, id: Int) = RecyclerViewMatcher(R.id.recyclerView).atPositionOnView(pos, id)

    @Before
    override fun setUp() {
        super.setUp()
        ApiWrapper.SERVICE_URL = getMockUrl()
        activityRule.launchActivity(null)
    }

    @Test
    fun success() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

        Thread.sleep(1000)
        mockHttpResponse("users.json", HttpURLConnection.HTTP_OK)

        onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tv_error)).check(matches(not(isDisplayed())))
        onView(withId(R.id.recyclerView)).check(matches((hasItemCount(10))))

        onView(withRecyclerViewItemId(0, R.id.textView)).check(
            matches(withText("Nicholas Kampouris"))
        ).check(matches(isDisplayed()))
    }
}