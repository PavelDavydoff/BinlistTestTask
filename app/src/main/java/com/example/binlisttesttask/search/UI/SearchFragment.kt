package com.example.binlisttesttask.search.UI

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import com.example.binlisttesttask.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var textWatcher: TextWatcher

    private val viewModel by viewModel<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observeState().observe(viewLifecycleOwner) {
            render(it)
        }

        var queryText = ""

        textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                queryText = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }

        textWatcher.let { binding.editText.addTextChangedListener(it) }

        binding.editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.searchRequest(queryText)
                queryText = ""
            }
            false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun render(state: SearchState) {
        when (state) {
            is SearchState.Content -> {
                showContent(state)
            }

            is SearchState.Error -> {
                binding.resultText.text = state.errorCode.toString()
            }
        }
    }

    private fun showContent(state: SearchState.Content) {
        val bin = state.bin
        with(binding) {
            content.visibility = View.VISIBLE
            scheme.text = bin.scheme
            brand.text = bin.brand
            length.text = bin.number?.length.toString()
            luhn.text = when (bin.number?.luhn) {
                true -> "Yes"
                false -> "No"
                else -> "Yes/No"
            }
            type.text = bin.type
            prepaid.text = when (bin.prepaid) {
                true -> "Yes"
                false -> "No"
                null -> "Yes/No"
            }
            country.text = bin.country?.name
            coordinates.text = "latitude ${bin.country?.latitude} longitude ${bin.country?.longitude}"
            name.text = bin.bank?.name
            url.text = bin.bank?.url
            phone.text = bin.bank?.phone
        }
    }

    private fun showError(state: SearchState.Error) {
        with(binding){
            content.visibility = View.GONE
            resultText.text = "Error ${state.errorCode}"
        }
    }
}