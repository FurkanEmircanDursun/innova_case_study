package com.furkandursun.innova_case_study.ui.currency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import androidx.lifecycle.viewModelScope
import com.furkandursun.innova_case_study.model.Currency
import com.furkandursun.innova_case_study.xmlService.XMLResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyViewModel : ViewModel() {

    private val _currencyList = MutableLiveData<List<Currency>>()
    val currencyList: LiveData<List<Currency>> = _currencyList

    init {
        fetchCurrencyData()
    }

    private fun fetchCurrencyData() {
        viewModelScope.launch {
            val currencies = withContext(Dispatchers.IO) {
                XMLResult().xmlDoviz()
            }
            _currencyList.value = currencies
        }
    }
}
