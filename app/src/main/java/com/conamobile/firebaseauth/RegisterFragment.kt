package com.conamobile.firebaseauth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.conamobile.firebaseauth.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private val binding by viewBinding { FragmentRegisterBinding.bind(it) }
    private lateinit var auth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val status = requireArguments().getBoolean("key1")

        binding.apply {
            statusTxt.text = if (status) "Register" else "Login"
            doneBtn.setOnClickListener {
                if (status) {
                    auth.createUserWithEmailAndPassword(
                        emailEdit.text.toString(),
                        passwordEdit.text.toString()
                    )
                }else {
                    auth.signInWithEmailAndPassword(
                        emailEdit.text.toString(),
                        passwordEdit.text.toString()
                    )
                }

                auth.addAuthStateListener { state->
                    state.currentUser?.uid?.let {
                        binding.apply {
                            MySharedPreference(requireContext()).apply {
                                saveBoolean("isLogin", true)
                                saveString("token", state.currentUser?.uid.toString())
                                saveString("name", nameEdit.text.toString())
                                saveString("email", emailEdit.text.toString())
                                saveString("password", passwordEdit.text.toString())
                                saveString("photo", state.currentUser?.photoUrl.toString())
                            }
                        }
                        findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
                    } ?: run {
                        requireContext().toast("xatolik")
                    }
                }
            }
        }
    }
}