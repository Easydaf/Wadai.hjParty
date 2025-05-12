package com.example.wadaihjparty.data

import com.example.wadaihjparty.model.Cake

object cartManager {
    private val cartItems = mutableListOf<Cake>()

    fun addToCart(cake: Cake) {
        cartItems.add(cake)
    }

    fun removeFromCart(cake: Cake) {
        cartItems.remove(cake)
    }

    fun getCartItems(): List<Cake> {
        return cartItems
    }

    fun clearCart() {
        cartItems.clear()
    }
}