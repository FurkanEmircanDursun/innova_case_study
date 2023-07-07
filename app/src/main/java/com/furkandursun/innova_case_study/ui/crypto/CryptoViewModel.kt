package com.furkandursun.innova_case_study.ui.crypto

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkandursun.innova_case_study.model.CryptoModel
import com.furkandursun.innova_case_study.retrofitServices.CyrptoApiClient
import com.furkandursun.innova_case_study.retrofitServices.CyrptoService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CryptoViewModel : ViewModel() {

    private val _cryptoList = MutableLiveData<List<CryptoModel>>()
    val cryptoList: LiveData<List<CryptoModel>> = _cryptoList

    init {
        fetchCryptoData()
    }

    private fun fetchCryptoData() {
        viewModelScope.launch {
            var service = CyrptoApiClient.getClient().create(CyrptoService::class.java)
            service.getAllCrypto().enqueue(object : Callback<List<CryptoModel>> {
                override fun onResponse(
                    call: Call<List<CryptoModel>>,
                    response: Response<List<CryptoModel>>
                ) {
                    _cryptoList.value=response.body()
                    Log.d("trtr",response.body().toString())
                }

                override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                    Log.d("trtr",t.message.toString())
                }


            })
        }
    }

}
