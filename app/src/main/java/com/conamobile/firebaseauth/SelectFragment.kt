package com.conamobile.firebaseauth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.conamobile.firebaseauth.databinding.FragmentSelectBinding

class SelectFragment : Fragment(R.layout.fragment_select) {
    private val binding by viewBinding { FragmentSelectBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("key1", false)
            findNavController().navigate(R.id.action_selectFragment_to_registerFragment, bundle)
        }
        binding.registerBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("key1", true)
            findNavController().navigate(R.id.action_selectFragment_to_registerFragment, bundle)
        }

    }
}