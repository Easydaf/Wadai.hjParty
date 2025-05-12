package com.example.wadaihjparty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wadaihjparty.databinding.FragmentCustomBinding


class CustomCakeFragment : Fragment() {
    private var _binding: FragmentCustomBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCustomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val jenisKue = listOf("Black Forest", "Toblerone", "Lapis Legit")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, jenisKue)
        binding.dropdownType.setAdapter(adapter)

        binding.btnAddCustom.setOnClickListener {
            val tema = binding.etTheme.text.toString()
            val tulisan = binding.etText.text.toString()
            val jenis = binding.dropdownType.text.toString()

            Toast.makeText(requireContext(), "Kue custom ditambahkan: $tema, $tulisan, $jenis", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}