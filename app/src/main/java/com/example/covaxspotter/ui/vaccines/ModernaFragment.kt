package com.example.covaxspotter.ui.vaccines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covaxspotter.R
import com.example.covaxspotter.databinding.FragmentModernaBinding
import com.example.covaxspotter.databinding.FragmentPfizerBinding
import com.example.covaxspotter.utils.moderna
import com.example.covaxspotter.utils.pfizer


/**
 * TODOS
 * Add binding object and inflate the layout using the binding object.
 */

class ModernaFragment : Fragment() {
    private var _binding: FragmentModernaBinding?= null // backing property
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentModernaBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.modText.text = moderna
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null //release memory at the end of lifecycle
    }
}