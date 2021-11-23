package com.a.fireside.repository


import androidx.lifecycle.MutableLiveData
import com.a.fire.api.ApiClient
import com.a.fireside.api.Api
import com.a.fireside.model.HourlyModel
import com.a.fireside.model.WeatherResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class WeatherRepository {
    private var volumesResponseLiveData: MutableLiveData<List<HourlyModel>>? = null
    fun searchVolumes(lat: String?, lon: String?, exclude: String?, appid: String?) {
                volumesResponseLiveData = MutableLiveData()

        ApiClient.apiService.searchVolumes(lat, lon, exclude,appid)?.enqueue(object : Callback<WeatherResponse?> {
                override fun onResponse(
                    call: Call<WeatherResponse?>?,
                    response: Response<WeatherResponse?>
                ) {
                    if (response.body()?.hourly != null) {
                        volumesResponseLiveData!!.postValue(response.body()?.hourly)
                    }
                }

                override fun onFailure(call: Call<WeatherResponse?>?, t: Throwable?) {
                    volumesResponseLiveData?.postValue(null)
                }
            })
    }

    fun getVolumesResponseLiveData(): MutableLiveData<List<HourlyModel>>? {
        return volumesResponseLiveData
    }
}
