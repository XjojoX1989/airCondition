package com.example.aircondition.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.example.aircondition.adapter.NormalConditionAdapter
import com.example.aircondition.databinding.FragmentSearchListBinding
import com.example.aircondition.extension.launchWithLifecycle
import com.example.aircondition.viewmodel.AirViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class SearchListFragment : Fragment() {

    private val airViewModel: AirViewModel by sharedViewModel()
    private lateinit var binding: FragmentSearchListBinding
    private var adapter: NormalConditionAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        subscribeUI()
    }

    private fun subscribeUI() {
        airViewModel.conditionList.launchWithLifecycle(
            lifecycle, Lifecycle.State.STARTED, lifecycleScope
        ) {
            binding.tvStatus.visibility = if (it == null || it.isEmpty()) View.VISIBLE
            else View.GONE
            adapter?.submitList(it)
        }
        airViewModel.searchStateFlow.launchWithLifecycle(
            lifecycle, Lifecycle.State.STARTED, lifecycleScope
        ) {
            binding.tvStatus.text = it
        }
    }

    private fun initView() {
        adapter = NormalConditionAdapter(viewLifecycleOwner)
        binding.apply {
            rvList.adapter = adapter
        }
    }

}