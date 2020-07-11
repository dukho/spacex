package com.nomadworks.spacex.screens

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.nomadworks.spacex.repository.SpacexRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
    private val spacexRepository: SpacexRepository,
    @Assisted private val state: SavedStateHandle): ViewModel() {

    init {
        Timber.d("[spacex] viewmodel got spacexRepository => $spacexRepository / state => $state")
    }

    data class MainViewState(
        val showLoadingSpinner: Boolean = false,
        val result: String = ""
    )

    private var viewStateSnapshot = MainViewState()
    private val _viewState = MutableLiveData<MainViewState>().apply {
        value = viewStateSnapshot
    }
    private fun postMainViewState(viewState: MainViewState) {
        viewStateSnapshot = viewState
        _viewState.postValue(viewStateSnapshot)
    }

    // this is exposed to viewbinding
    val viewState: LiveData<MainViewState> = _viewState


    fun fetchLatest() {
        Timber.d("[spacex] FETCH!")
        postMainViewState(viewStateSnapshot.copy(
            showLoadingSpinner = true,
            result = ""
        ))

        viewModelScope.launch {
            val result = kotlin.runCatching {
                spacexRepository.fetchLatestLaunch()
            }
            postMainViewState(viewStateSnapshot.copy(
                showLoadingSpinner = false
            ))
            result.onSuccess {
                postMainViewState(viewStateSnapshot.copy(
                    result = "On Success:\n\n$it"
                ))
            }.onFailure {
                postMainViewState(viewStateSnapshot.copy(
                    result = "On Failure:\n\n$it"
                ))
            }
        }

    }
}