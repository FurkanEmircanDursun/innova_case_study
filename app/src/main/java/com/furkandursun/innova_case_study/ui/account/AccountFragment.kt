package com.furkandursun.innova_case_study.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.furkandursun.innova_case_study.databinding.FragmentAccountBinding



import android.widget.Button
import com.furkandursun.innova_case_study.SignInActivity
import com.furkandursun.innova_case_study.SignUpActivity
import com.furkandursun.innova_case_study.firebaseServices.AuthService
import com.google.firebase.auth.FirebaseAuth

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // FirebaseAuth örneğini alarak auth özelliğini başlatın
        auth = FirebaseAuth.getInstance()

        val signOutButton: Button = binding.btnSignOut

        signOutButton.setOnClickListener {
            // Çıkış işlemini gerçekleştirin
            auth.signOut()

            val intent = Intent(requireContext(), SignInActivity::class.java)
            startActivity(intent)
           activity?.finish()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

