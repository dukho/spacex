package com.nomadworks.spacex.screens

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nomadworks.spacex.repository.SpacexRepository
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
    private val spacexRepository: SpacexRepository,
    @Assisted private val state: SavedStateHandle): ViewModel() {

    init {
        Timber.d("[spacex] viewmodel got spacexRepository => $spacexRepository / state => $state")
    }
}