package com.conamobile.firebaseauth

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.conamobile.firebaseauth.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding { FragmentHomeBinding.bind(it) }
    private val shared by lazy { MySharedPreference(requireContext()) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            imageView.setImageURI(shared.getString("image")?.toUri())
            nameTxt.text = shared.getString("name")
            emailTxt.text = shared.getString("email")
            tokenTxt.text = shared.getString("token") ?: "Token qo'yilmagan"

            binding.logOutBtn.setOnClickListener {
                shared.saveBoolean("isLogin", false)
                findNavController().navigate(R.id.action_homeFragment_to_selectFragment)
            }
        }
    }
}