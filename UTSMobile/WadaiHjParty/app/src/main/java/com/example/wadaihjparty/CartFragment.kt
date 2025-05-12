package com.example.wadaihjparty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wadaihjparty.databinding.FragmentCartBinding
import com.example.wadaihjparty.data.cartManager
import com.example.wadaihjparty.model.Cake


class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (cartManager.getCartItems().isEmpty()) {
            // Data dumy aja supaya bagus UInya
            cartManager.addToCart(
                Cake("Black Forest Cake", R.drawable.lapissurabayaistimewa, "Coklat dan cherry", "Rp195.000")
            )

            binding.btnCheckout.setOnClickListener {
                val totalItem = cartManager.getCartItems().size
                val totalHarga = "Rp.600.000" // dumy aja

                val bottomSheet = CheckoutBottomSheetDialog(totalItem, totalHarga)
                bottomSheet.show(parentFragmentManager, "CheckoutBottomSheet")
            }
        }
        super.onViewCreated(view, savedInstanceState)

        val adapter = CartAdapter(cartManager.getCartItems())

        binding.recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCart.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}