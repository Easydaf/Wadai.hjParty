package com.example.wadaihjparty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wadaihjparty.databinding.ItemKueBinding
import com.example.wadaihjparty.model.Cake

class CakeAdapter(
    private val cakeList: List<Cake>,
    private val onItemClick: (Cake) -> Unit,
) : RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {

    inner class CakeViewHolder(val binding: ItemKueBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        val binding = ItemKueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        val cake = cakeList[position]
        with(holder.binding) {
            tvcake.text = cake.name
            tvPrice.text = cake.price
            Glide.with(imgCake.context)
                .load(cake.image)
                .into(imgCake)

            root.setOnClickListener {
                onItemClick(cake)
            }
        }
    }

    override fun getItemCount(): Int = cakeList.size
}