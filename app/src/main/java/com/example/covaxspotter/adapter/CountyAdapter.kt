package com.example.covaxspotter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.covaxspotter.databinding.CountyItemBinding
import com.example.covaxspotter.room.CountyVaccine

class CountyAdapter(
    private val onItemClicked: (CountyVaccine) -> Unit
) : ListAdapter<CountyVaccine, CountyAdapter.CountyViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<CountyVaccine>() {
            override fun areItemsTheSame(oldItem: CountyVaccine, newItem: CountyVaccine): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CountyVaccine, newItem: CountyVaccine): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountyViewHolder {
        val viewHolder = CountyViewHolder(
            CountyItemBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CountyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CountyViewHolder(
        private var binding: CountyItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(countyVaccine: CountyVaccine) {
            binding.countyName.text = countyVaccine.countyName
        }
    }
}
