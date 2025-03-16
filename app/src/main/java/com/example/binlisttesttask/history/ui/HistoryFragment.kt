package com.example.binlisttesttask.history.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.binlisttesttask.databinding.FragmentHistoryBinding
import com.example.binlisttesttask.history.ui.models.HistoryState
import com.example.binlisttesttask.history.ui.presentation.HistoryAdapter
import com.example.binlisttesttask.history.ui.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var historyAdapter: HistoryAdapter

    private val viewModel: HistoryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getListOfBins()

        historyAdapter = HistoryAdapter()

        binding.recyclerView.adapter = historyAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.observeState().observe(viewLifecycleOwner) {
            render(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun render(state: HistoryState) {
        if (state is HistoryState.Content) {
            historyAdapter.bins.clear()
            historyAdapter.bins.addAll(state.listOfBins)
            historyAdapter.notifyDataSetChanged()
            binding.recyclerView.visibility = View.VISIBLE
        }
    }
}