package com.example.aircondition.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aircondition.extension.updateValue
import com.example.data.BuildConfig
import com.example.domain.usecase.FetchAirConditionDataUseCase
import com.example.domain.model.AirConditionUIModel
import kotlinx.coroutines.flow.*

class AirViewModel(private val useCase: FetchAirConditionDataUseCase) : ViewModel() {

    val airConditionListFlow = queryAirConditionList().onEach {
        updateConditionList(it)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun queryAirConditionList(): Flow<Pair<List<AirConditionUIModel>, List<AirConditionUIModel>>> {
        return useCase.invoke("1000", BuildConfig.API_KEY)
    }

    val searchText = MutableStateFlow("")
    fun updateSearchText(s: String) {
        searchText.tryEmit(s)
    }

    val searchStateFlow = searchText.map {
        "找不到『${it}』相關的空污資訊"
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "")


    val _conditionList = MutableStateFlow<List<AirConditionUIModel>>(arrayListOf())
    val conditionList = _conditionList.combine(searchText) { list, search ->
        list.filter {
            it.siteName.contains(search)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    private fun updateConditionList(list: Pair<List<AirConditionUIModel>, List<AirConditionUIModel>>) {
        _conditionList.tryEmit(list.first + list.second)
    }

}

