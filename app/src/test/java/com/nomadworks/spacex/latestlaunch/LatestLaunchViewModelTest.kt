package com.nomadworks.spacex.latestlaunch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.whenever
import com.nomadworks.spacex.api.model.launch.Launch
import com.nomadworks.spacex.repository.SpacexRepository
import com.nomadworks.spacex.screens.latestlaunch.LatestLaunchViewModel
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.io.FileReader

@ExperimentalCoroutinesApi
class LatestLaunchViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    var coroutineDispatcher = TestCoroutineDispatcher()

    /*
     * cannot mock a final class - just instantiate instead
    @Mock
    lateinit var savedStateHandle: SavedStateHandle
    */

    @Mock
    lateinit var repository: SpacexRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { _ -> Schedulers.trampoline() }
        Dispatchers.setMain(coroutineDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        coroutineDispatcher.cleanupTestCoroutines()
    }

    // Note: runBlocking should return void (no value at the end of the block
    @Test
    fun test_latest_launch_success() = runBlocking{
        val launch = getLatestLaunchResponse()
        assertNotNull(launch)

        whenever(repository.fetchLatestLaunch()).thenReturn(launch)

        val viewModel = instantiateViewModel()
        assertNotNull(viewModel)

        viewModel.fetchLatest()
        assertEquals("On Success:\n\n$launch" , viewModel.viewState.value?.result)
    }

    private fun getLatestLaunchResponse(): Launch {
        return Gson().fromJson(
            FileReader("src/test/resources/json/latest_launch_success.json"),
            Launch::class.java
        )
    }

    private fun instantiateViewModel(): LatestLaunchViewModel {
        return LatestLaunchViewModel(repository, SavedStateHandle())
    }
}