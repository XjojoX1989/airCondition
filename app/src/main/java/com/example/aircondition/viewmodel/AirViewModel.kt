package com.example.aircondition.viewmodel

import android.os.Looper
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.BuildConfig
import com.example.domain.usecase.FetchAirConditionDataUseCase
import com.example.domain.model.AirConditionUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class AirViewModel(private val useCase: FetchAirConditionDataUseCase) : ViewModel() {

    val airConditionListFlow = queryAirConditionList()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    private fun queryAirConditionList(): Flow<Pair<List<AirConditionUIModel>, List<AirConditionUIModel>>> {
        return useCase.invoke("1000", BuildConfig.API_KEY)
    }

    val loadingVisibility = MutableLiveData(View.GONE)
    fun updateLoading(value: Boolean) {
        if (value) {
            loadingVisibility.updateValue(View.VISIBLE)
        } else {
            loadingVisibility.updateValue(View.GONE)
        }
    }

}
fun <T> MutableLiveData<T>.updateValue(value: T) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        setValue(value)
    } else {
        postValue(value)
    }
}