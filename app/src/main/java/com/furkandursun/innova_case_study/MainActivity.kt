package com.furkandursun.innova_case_study

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.furkandursun.innova_case_study.databinding.ActivityMainBinding
import com.furkandursun.innova_case_study.model.CryptoModel
import com.furkandursun.innova_case_study.retrofitServices.CyrptoApiClient
import com.furkandursun.innova_case_study.retrofitServices.CyrptoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_crypto, R.id.navigation_currency, R.id.navigation_account
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        var service = CyrptoApiClient.getClient().create(CyrptoService::class.java)
        service.getAllCrypto().enqueue(object : Callback<List<CryptoModel>> {
            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
              Log.d("trtr",response.body().toString())
            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                Log.d("trtr",t.message.toString())
            }


        })

    }
}