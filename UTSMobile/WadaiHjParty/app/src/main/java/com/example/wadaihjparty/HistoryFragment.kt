package com.example.wadaihjparty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wadaihjparty.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dummyRiwayat = listOf(
            RiwayatPesanan("Toblerone Cake", R.drawable.puding, "Rp200.000", 2),
            RiwayatPesanan("Lapis Legit", R.drawable.putrikeraton, "Rp150.000", 1)
        )

        val adapter = RiwayatAdapter(dummyRiwayat)
        binding.recyclerViewRiwayat.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewRiwayat.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}