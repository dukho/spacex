package com.nomadworks.spacex.screens.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nomadworks.spacex.util.event.EventWrapper
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(
    @Assisted private val state: SavedStateHandle
) : ViewModel() {
    init {
        Timber.d("[spacex] Home view model created !! state = $state")
    }

    private val _homeEvent = MutableLiveData<EventWrapper<HomeAction>>()
    val homeEvent: LiveData<EventWrapper<HomeAction>> = _homeEvent
    private fun postAction(action: HomeAction) {
        _homeEvent.postValue(EventWrapper(action))
    }

    fun onLatestLaunchRequest() {
        postAction(HomeAction.MoveToLatestLaunch)
    }
}