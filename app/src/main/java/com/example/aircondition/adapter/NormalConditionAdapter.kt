package com.example.aircondition.adapter

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import com.example.aircondition.databinding.NormalConditionItemBinding
import com.example.domain.model.AirConditionUIModel

class NormalConditionAdapter(private val lifecycleOwner: LifecycleOwner) :
    BaseRecyclerViewAdapter<AirConditionUIModel, AirConditionViewHolder, NormalConditionItemBinding>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirConditionViewHolder {
        return AirConditionViewHolder(parent, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: AirConditionViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AirConditionUIModel>() {
            override fun areItemsTheSame(
                oldItem: AirConditionUIModel, newItem: AirConditionUIModel
            ): Boolean {
                return oldItem.siteId == newItem.siteId
            }

            override fun areContentsTheSame(
                oldItem: AirConditionUIModel, newItem: AirConditionUIModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class AirConditionViewHolder(parent: ViewGroup, lifecycleOwner: LifecycleOwner) :
    BaseRecyclerViewHolder<AirConditionUIModel, NormalConditionItemBinding>(
        NormalConditionItemBinding::inflate, parent, lifecycleOwner
    ) {
    override fun bind(item: AirConditionUIModel, position: Int) {
        binding.data = item
    }

}
