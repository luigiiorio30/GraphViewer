package com.example.graphviewer.fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graphviewer.net.PieApi
import com.example.graphviewer.net.PieApiService
import com.example.graphviewer.net.PieInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class PieViewModel : ViewModel() {

    private val _pie = MutableLiveData<List<PieInfo>>()

    val pie: LiveData<List<PieInfo>>
        get() = _pie

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    /**
     * Function for acquiring pie chart data via API
     */
    fun dataPieAcquisition() = CoroutineScope(Dispatchers.Main).launch {
        try {
            _pie.postValue(PieApi.retrofitService.getPieInfo())

            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false

        } catch (networkError: IOException) {
            _eventNetworkError.value = true
        }
    }

    /**
     * Function to save pie chart data in a list by API
     */
    fun getDataPie(): List<Int> {
        return _pie.value!!.map { e -> e.PieData }.distinct()
    }

}