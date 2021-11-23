package com.a.fire.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.a.fire.R
import com.a.fire.adapter.WeatherAdapter.BookSearchResultHolder
import com.a.fireside.model.HourlyModel
import java.util.*


class WeatherAdapter : RecyclerView.Adapter<BookSearchResultHolder>() {
    private var results: List<HourlyModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSearchResultHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_item, parent, false)
        return BookSearchResultHolder(itemView)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: BookSearchResultHolder, position: Int) {
        val (_, temp, _, _, humidity, _, _, _, _, wind_speed) = results[position]
        holder.txt_tempture.text = "$temp Tempture"
        holder.txt_humidity.text = "$humidity Humidity"
        holder.txt_wind_speed.text = "$wind_speed Wind speed"
        val cl = Calendar.getInstance()
        cl.timeInMillis = results.get(position).dt.toLong()
        holder.txt_hr.text =  "" +cl.get(Calendar.HOUR_OF_DAY)+ ":" + cl.get(Calendar.MINUTE) + ":" + cl.get(Calendar.SECOND);

    }
    override fun getItemCount(): Int {
        return results.size
    }
    fun setResults(results: List<HourlyModel>) {
        this.results = results
        notifyDataSetChanged()
    }
    inner class BookSearchResultHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val txt_tempture: TextView
        val txt_wind_speed: TextView
        val txt_humidity: TextView
        val txt_hr: TextView

        init {
            txt_tempture = itemView.findViewById(R.id.txt_tempture)
            txt_humidity = itemView.findViewById(R.id.txt_humidity)
            txt_wind_speed = itemView.findViewById(R.id.txt_wind_speed)
            txt_hr = itemView.findViewById(R.id.txt_hr)
        }
    }

}