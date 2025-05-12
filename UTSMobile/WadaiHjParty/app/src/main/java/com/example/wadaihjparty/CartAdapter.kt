package com.example.wadaihjparty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wadaihjparty.databinding.ItemCartBinding
import com.example.wadaihjparty.model.Cake

class CartAdapter(private val items: List<Cake>) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cake = items[position]
        with(holder.binding) {
            tvCartName.text = cake.name
            Glide.with(imgCart.context)
                .load(cake.image)
                .into(imgCart)

            btnTambah.setOnClickListener {
                // TODO: Tambah jumlah
            }

            btnMinus.setOnClickListener {
                // TODO: Kurangi jumlah
            }

            btnDelete.setOnClickListener {
                // TODO: Hapus item dari keranjang
            }
        }
    }

    override fun getItemCount(): Int = items.size
}