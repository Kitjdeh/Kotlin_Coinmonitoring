package com.example.coinmonitoring.view.adpater

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coinmonitoring.R
import com.example.coinmonitoring.dataModel.UpDownDataSet

class PriceListUpDownRVAdapter(val context: Context, val dataSet: List<UpDownDataSet>) :
    RecyclerView.Adapter<PriceListUpDownRVAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coinName = view.findViewById<TextView>(R.id.coinName)
        val coinPriceUpDown = view.findViewById<TextView>(R.id.coinPriceUpDown)
        val price = view.findViewById<TextView>(R.id.price)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.coin_price_change_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.coinName.text = dataSet[position].coinName
        if (dataSet[position].upDownPrice.contains("-")) {
            holder.coinPriceUpDown.text = "하락"
            holder.coinPriceUpDown.setTextColor(Color.BLUE)
        } else {
            holder.coinPriceUpDown.text = "상승"
            holder.coinPriceUpDown.setTextColor(Color.RED)
        }
        //소수점을 기준으로 split
        holder.price.text = dataSet[position].upDownPrice.split(".")[0]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}