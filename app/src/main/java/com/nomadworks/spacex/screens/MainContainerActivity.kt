package com.nomadworks.spacex.screens

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.nomadworks.spacex.R
import com.nomadworks.spacex.databinding.ActivityMainBinding
import com.nomadworks.spacex.repository.SpacexRepository
import com.nomadworks.spacex.resource.ResourceQuery
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainContainerActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    @field:[Inject Named("CONFIG")]
    lateinit var sharedPreferences: SharedPreferences

    @Inject lateinit var resourceQuery: ResourceQuery

    @Inject lateinit var repository: SpacexRepository

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Timber.d("[spacex] sharedPreferences injected ?? => $sharedPreferences")
        Timber.d("[spacex] resourceQuery => $resourceQuery")
        Timber.d("[spacex] repository => $repository")
        Timber.d("[spacex] viewModel => $viewModel")
        Timber.d("[spacex] API ID => ${getString(R.string.api_id)}")

        viewBinding.lifecycleOwner = this
        viewBinding.viewModel = viewModel
    }
}