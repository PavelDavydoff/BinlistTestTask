package com.example.binlisttesttask.search.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.example.binlisttesttask.databinding.FragmentSearchBinding
import com.example.binlisttesttask.search.ui.models.SearchState
import com.example.binlisttesttask.search.ui.presentation.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var textWatcher: TextWatcher

    private val viewModel by viewModel<SearchViewModel>()

    var latitude = 0
    var longitude = 0

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

        binding.button.setOnClickListener {
            viewModel.searchRequest(queryText)

            val imm =
                view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.editText.windowToken, 0)
        }

        binding.editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.searchRequest(queryText)
            }
            false
        }

        binding.phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = binding.phone.text.toString().toUri()
            }
            startActivity(intent)
        }

        binding.url.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = binding.url.text.toString().toUri()
            }
            startActivity(intent)
        }

        binding.country.setOnClickListener {
            val geoUri = "geo:$latitude,$longitude"
            val intent = Intent(Intent.ACTION_VIEW, geoUri.toUri())
            startActivity(intent)
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
                showError(state)
            }
        }
    }

    private fun showContent(state: SearchState.Content) {
        val bin = state.bin
        with(binding) {
            content.visibility = View.VISIBLE
            resultText.visibility = View.GONE
            scheme.text = bin.scheme
            brand.text = bin.brand
            length.text = bin.number?.length.toString()
            luhn.text = when (bin.number?.luhn) {
                true -> "Yes"
                false -> "No"
                else -> "-"
            }
            type.text = bin.type
            prepaid.text = when (bin.prepaid) {
                true -> "Yes"
                false -> "No"
                null -> "-"
            }
            country.text = bin.country?.name
            coordinates.text =
                "latitude ${bin.country?.latitude} longitude ${bin.country?.longitude}"
            name.text = bin.bank?.name
            url.text = bin.bank?.url
            phone.text = bin.bank?.phone

            latitude = bin.country?.latitude!!.toInt()
            longitude = bin.country.longitude.toInt()
        }
    }

    private fun showError(state: SearchState.Error) {
        with(binding) {
            content.visibility = View.GONE
            resultText.visibility = View.VISIBLE
            resultText.text = "Error code ${state.errorCode}"
        }
    }
}