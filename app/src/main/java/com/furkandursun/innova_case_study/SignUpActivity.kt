package com.furkandursun.innova_case_study


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.furkandursun.innova_case_study.databinding.ActivitySignUpBinding
import com.furkandursun.innova_case_study.firebaseServices.AuthService

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSignUp.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Üyelik oluşturma işlemi
            AuthService.signUpWithEmailAndPassword(email, password) { success, errorMessage ->
                if (success) {
                    // Üyelik oluşturma başarılı, MainActivity'ye geçiş yap
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Mevcut aktiviteyi kapat
                } else {
                    // Üyelik oluşturma başarısız, hata mesajını göster
                    Toast.makeText(this, "Üyelik oluşturma başarısız: $errorMessage", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
