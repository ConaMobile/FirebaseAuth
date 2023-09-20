package com.conamobile.firebaseauth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            MySharedPreference(requireContext()).apply {
                if (getBoolean("isLogin")) {
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                } else findNavController().navigate(R.id.action_splashFragment_to_selectFragment)
            }
        }, 3000)
    }
}