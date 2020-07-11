package com.nomadworks.spacex.screens.home

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nomadworks.spacex.R
import com.nomadworks.spacex.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()

    @field:[Inject Named("CONFIG")]
    lateinit var sharedPreferences: SharedPreferences

    private var viewBinding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("[spacex] onViewCreated() sharedPreferences = $sharedPreferences /  viewModel = $viewModel")

        viewBinding = FragmentHomeBinding.bind(view)
        viewBinding?.run {
            setupViewBinding(this)
        }
    }

    private fun setupViewBinding(binding: FragmentHomeBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.homeEvent.observe(viewLifecycleOwner, Observer { wrapper ->
            when (val action = wrapper?.getContentIfNotHandled()) {
                is HomeAction.MoveToLatestLaunch -> {
                    Timber.d("[spacex] Latest !!")
                    findNavController().navigate(R.id.action_homeFragment_to_latestLaunchFragment)
                }
            }
        })
    }

    private fun clearViewBinding(binding: FragmentHomeBinding) {
        binding.viewModel = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding?.run {
            clearViewBinding(this)
        }
        viewBinding = null
    }
}