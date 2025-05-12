package com.example.wadaihjparty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wadaihjparty.CakeAdapter
import com.example.wadaihjparty.CustomCakeFragment
import com.example.wadaihjparty.DetailKueFragment
import com.example.wadaihjparty.R
import com.example.wadaihjparty.databinding.FragmentHomeBinding
import com.example.wadaihjparty.model.Cake

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cakeList = listOf(
            Cake("Black Forest Cake", R.drawable.lapissurabayaistimewa, "Coklat dengan cherry dan krim", "Rp195.000"),
            Cake("Toblerone Cake", R.drawable.puding, "Toblerone coklat lezat", "Rp200.000"),
            Cake("Lapis Legit", R.drawable.putrikeraton, "Kue lapis khas Nusantara", "Rp150.000")
        )

        val adapter = CakeAdapter(cakeList) { selectedCake ->
            val fragment = DetailKueFragment()
            val bundle = Bundle()
            bundle.putParcelable("cake", selectedCake)
            fragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()

        }
        binding.btnCustomCake.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CustomCakeFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.recyclerViewKue.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerViewKue.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}