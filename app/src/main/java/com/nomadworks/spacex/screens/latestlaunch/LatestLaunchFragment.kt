package com.nomadworks.spacex.screens.latestlaunch

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nomadworks.spacex.R
import com.nomadworks.spacex.databinding.FragmentLatestLaunchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LatestLaunchFragment : Fragment(R.layout.fragment_latest_launch) {
    private val viewModel: LatestLaunchViewModel by viewModels()
    private var viewBinding: FragmentLatestLaunchBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = DataBindingUtil.bind(view)
        viewBinding?.run {
            setupViewBinding(this)
        }
    }

    private fun setupViewBinding(binding: FragmentLatestLaunchBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun clearViewBinding(binding: FragmentLatestLaunchBinding) {
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