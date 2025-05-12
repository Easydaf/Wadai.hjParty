package com.example.wadaihjparty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wadaihjparty.databinding.ItemHistoryBinding


class RiwayatAdapter(private val riwayatList: List<RiwayatPesanan>) :
    RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    inner class RiwayatViewHolder(val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RiwayatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        val item = riwayatList[position]
        with(holder.binding) {
            tvNamaKue.text = item.name
            tvPrice.text = item.price
            tvJumlahKue.text = "Jumlah: ${item.quantity}"
            Glide.with(imgCake.context)
                .load(item.image)
                .into(imgCake)
        }
    }

    override fun getItemCount(): Int = riwayatList.size
}