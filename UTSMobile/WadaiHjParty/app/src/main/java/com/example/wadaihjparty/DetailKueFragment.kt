package com.example.wadaihjparty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.wadaihjparty.databinding.FragmentDetailKueBinding
import com.example.wadaihjparty.model.Cake

class DetailKueFragment : Fragment() {

    private var _binding: FragmentDetailKueBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailKueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil data dari argument
        val cake = arguments?.getParcelable<Cake>("cake")

        cake?.let {
            binding.tvcake.text = it.name
            binding.tvCakeDesc.text = it.description
            binding.tvPrice.text = it.price

            Glide.with(requireContext())
                .load(it.image)
                .into(binding.imgCake)
        }
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.btnAdd.setOnClickListener {
            cake?.let {
                Toast.makeText(requireContext(), "${it.name} ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}