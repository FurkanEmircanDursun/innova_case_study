package com.furkandursun.innova_case_study.ui.currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.furkandursun.innova_case_study.adapter.CurrencyAdapter
import com.furkandursun.innova_case_study.databinding.FragmentCurrencyBinding

class CurrencyFragment : Fragment() {

    private var _binding: FragmentCurrencyBinding? = null
    private val binding get() = _binding!!

    private lateinit var currencyAdapter: CurrencyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val currencyViewModel =
            ViewModelProvider(this).get(CurrencyViewModel::class.java)

        _binding = FragmentCurrencyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.recyclerView
        currencyAdapter = CurrencyAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = currencyAdapter
        }

        currencyViewModel.currencyList.observe(viewLifecycleOwner) { currencies ->
            currencyAdapter.submitList(currencies)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
