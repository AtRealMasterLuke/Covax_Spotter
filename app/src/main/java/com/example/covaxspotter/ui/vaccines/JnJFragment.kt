package com.example.covaxspotter.ui.vaccines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covaxspotter.databinding.FragmentJnJBinding
import com.example.covaxspotter.utils.johnsons


class JnJFragment : Fragment() {
    private var _binding: FragmentJnJBinding?= null // backing property
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentJnJBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.JnJText.text = johnsons
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null //release memory at the end of lifecycle
    }
}