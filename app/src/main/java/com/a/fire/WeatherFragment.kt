package com.a.fire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a.fire.adapter.WeatherAdapter
import com.a.fireside.viewmodel.WeatherViewModel


class WeatherFragment : Fragment() {
    private var adapter: WeatherAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var latitude: String? = null
    private var longitude: String? = null
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
         latitude = bundle!!.getString("latitude")
        longitude = bundle!!.getString("longitude")
    }
    private fun Init() {
        val layoutManager = LinearLayoutManager(activity)
        recyclerView!!.layoutManager = layoutManager
        val exclude = "alerts,daily,minutely,current"
        val appid = "b2d83321a0e15d4f978007694b94caa4"
        viewModel!!.searchVolumes(latitude, longitude, exclude, appid)
        subscribeObservers()
    }
    private fun subscribeObservers() {

        viewModel.getVolumesResponseLiveData()!!.observe(viewLifecycleOwner, Observer { networkState ->
            adapter = WeatherAdapter()
            recyclerView!!.adapter = adapter
            adapter!!.setResults(networkState);
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_booksearch, container, false)
        recyclerView =
            view.findViewById(R.id.fragment_booksearch_searchResultsRecyclerView)
        Init()
        return view
    }

}