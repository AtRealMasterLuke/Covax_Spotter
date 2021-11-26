package com.example.covaxspotter.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covaxspotter.CountyApplication
import com.example.covaxspotter.adapter.CountyAdapter
import com.example.covaxspotter.databinding.FragmentCountiesBinding
import com.example.covaxspotter.viewmodel.MainViewModel
import com.example.covaxspotter.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch

class CountiesFragment : Fragment() {
    private var _binding: FragmentCountiesBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    private val viewModel: MainViewModel by activityViewModels {
        MainViewModelFactory(
            (activity?.application as CountyApplication).repository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCountiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

        val countyAdapter = CountyAdapter {
            val action = CountiesFragmentDirections
                    .actionCountiesFragmentToSubCountiesFragment(
                  it.countyName
            )
            view.findNavController().navigate(action)
        }
        recyclerView.adapter = countyAdapter

        lifecycle.coroutineScope.launch {
            viewModel.readAll.observe(viewLifecycleOwner, {
                countyAdapter.submitList(it)
            })
        }
    }

    private fun setUpRecyclerView() {
        Log.i("CountyFragment", "Adapter Called")
        recyclerView = binding.rvCountiesList
        binding.rvCountiesList.layoutManager = LinearLayoutManager(activity)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}