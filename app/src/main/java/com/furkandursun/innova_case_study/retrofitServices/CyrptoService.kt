package com.furkandursun.innova_case_study.retrofitServices



import com.furkandursun.innova_case_study.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET


interface CyrptoService {


    @GET("coins/markets?vs_currency=try&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=tr")
    fun getAllCrypto(): Call<List<CryptoModel>>


}