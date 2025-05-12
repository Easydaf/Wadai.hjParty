package com.example.wadaihjparty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wadaihjparty.databinding.FragmentCheckoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CheckoutBottomSheetDialog (
    private val totalItems: Int,
    private val totalPrice: String
) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCheckoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvTotalItems.text = totalItems.toString()
        binding.tvTotalPrice.text = totalPrice

        binding.btnWhatsapp.setOnClickListener {
            // TODO: Intent ke WhatsApp
            dismiss()
        }
    }
}