package com.example.aircondition.adapter

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import com.example.aircondition.databinding.NiceCoditionItemBinding
import com.example.aircondition.databinding.NormalConditionItemBinding
import com.example.domain.model.AirConditionUIModel

class NiceConditionAdapter(private val lifecycleOwner: LifecycleOwner) :
    BaseRecyclerViewAdapter<AirConditionUIModel, NiceConditionViewHolder, NiceCoditionItemBinding>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NiceConditionViewHolder {
        return NiceConditionViewHolder(parent, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: NiceConditionViewHolder, position: Int) {
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

class NiceConditionViewHolder(parent: ViewGroup, lifecycleOwner: LifecycleOwner) :
    BaseRecyclerViewHolder<AirConditionUIModel, NiceCoditionItemBinding>(
        NiceCoditionItemBinding::inflate, parent, lifecycleOwner
    ) {
    override fun bind(item: AirConditionUIModel, position: Int) {
        binding.data = item
    }

}
