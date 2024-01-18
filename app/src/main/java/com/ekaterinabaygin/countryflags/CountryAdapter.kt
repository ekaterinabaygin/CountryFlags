package com.ekaterinabaygin.countryflags

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ekaterinabaygin.flag.R

private object CountryDiffCallback : DiffUtil.ItemCallback<Country>() {

    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.countryCode == newItem.countryCode
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country) = oldItem == newItem
}

class CountryAdapter : ListAdapter<Country, CountryAdapter.CountryViewHolder>(CountryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val flagText = itemView.findViewById<TextView>(R.id.flagText)
        private val nameText = itemView.findViewById<TextView>(R.id.countryNameText)

        fun onBind(country: Country) {
            flagText.text = country.flag
            nameText.text = country.name
        }
    }
}
