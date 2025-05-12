package com.example.wadaihjparty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wadaihjparty.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val languageList = listOf("id", "en")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO: ambil data pengguna jika ada
        super.onViewCreated(view, savedInstanceState)

        binding.btnHistory.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HistoryFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}