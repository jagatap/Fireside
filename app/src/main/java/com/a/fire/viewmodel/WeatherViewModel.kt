package com.a.fireside.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.a.fireside.model.HourlyModel

import com.a.fireside.repository.WeatherRepository

public class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private var bookRepository: WeatherRepository? = null
    private var volumesResponseLiveData: MutableLiveData<List<HourlyModel>>? = null
    fun init() {

    }

    fun searchVolumes(lat: String?, lon: String?, exclude: String?, appid: String?) {
        bookRepository = WeatherRepository()
        volumesResponseLiveData = bookRepository!!.getVolumesResponseLiveData()
        bookRepository!!.searchVolumes(lat, lon,exclude,appid)
        volumesResponseLiveData = bookRepository!!.getVolumesResponseLiveData()
    }

    fun getVolumesResponseLiveData(): MutableLiveData<List<HourlyModel>>? {
        return volumesResponseLiveData
    }
}