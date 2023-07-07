package com.furkandursun.innova_case_study.ui.crypto

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.furkandursun.innova_case_study.adapter.CryptoAdapter
import com.furkandursun.innova_case_study.databinding.FragmentCryptoBinding
import com.furkandursun.innova_case_study.model.CryptoModel
import com.furkandursun.innova_case_study.retrofitServices.CyrptoApiClient
import com.furkandursun.innova_case_study.retrofitServices.CyrptoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CryptoFragment : Fragment() {

    private var _binding: FragmentCryptoBinding? = null
    private val binding get() = _binding!!

    private lateinit var cryptoAdapter: CryptoAdapter

    private val cryptoViewModel: CryptoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCryptoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()

        cryptoViewModel.cryptoList.observe(viewLifecycleOwner) { cryptoList ->
            cryptoAdapter.submitList(cryptoList)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        cryptoAdapter = CryptoAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cryptoAdapter
        }
    }
}
