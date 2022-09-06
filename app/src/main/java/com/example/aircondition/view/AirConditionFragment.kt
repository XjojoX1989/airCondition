package com.example.aircondition.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.aircondition.adapter.NiceConditionAdapter
import com.example.aircondition.adapter.NormalConditionAdapter
import com.example.aircondition.databinding.FragmentAirConditionBinding
import com.example.aircondition.viewmodel.AirViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AirConditionFragment : Fragment() {

    private lateinit var binding: FragmentAirConditionBinding
    private val viewModel: AirViewModel by viewModel()
    private var normalAdapter: NormalConditionAdapter? = null
    private var niceAdapter: NiceConditionAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAirConditionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        normalAdapter = NormalConditionAdapter(viewLifecycleOwner)
        niceAdapter = NiceConditionAdapter(viewLifecycleOwner)
        binding.apply {
            rvNiceCondition.also {
                it.adapter = niceAdapter
                it.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
            }
            rvNormalCondition.also {
                it.adapter = normalAdapter
                it.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
        lifecycleScope.launch {
            viewModel.airConditionListFlow.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                    .onStart {
                        binding.loadingView.visibility = View.VISIBLE
                    }
                    .collectLatest {
                        it?.apply {
                            binding.loadingView.visibility = View.GONE
                            niceAdapter?.submitList(this.first)
                            normalAdapter?.submitList(this.second)
                        }
                    }
        }
    }
}