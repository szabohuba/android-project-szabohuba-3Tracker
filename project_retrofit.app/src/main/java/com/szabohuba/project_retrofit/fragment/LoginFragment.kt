package com.szabohuba.project_retrofit.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.szabohuba.project_retorfit.R
import com.szabohuba.project_retrofit.App
import com.szabohuba.project_retrofit.api.ThreeTrackerRepository
import com.szabohuba.project_retrofit.manager.SharedPreferencesManager
import com.szabohuba.project_retrofit.viewmodel.LoginViewModel
import com.szabohuba.project_retrofit.viewmodel.LoginViewModelFactory


class LoginFragment : Fragment() {

    companion object {
        private val TAG: String = javaClass.simpleName
    }

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = LoginViewModelFactory(ThreeTrackerRepository())
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val userNameEditText: EditText = view.findViewById(R.id.edittext_name_login_fragment)
        val passwordEditText: EditText = view.findViewById(R.id.edittext_password_login_fragment)
        val button: Button = view.findViewById(R.id.button_login_fragment)

        Log.d(
            TAG,
            "token = " + App.sharedPreferences.getStringValue(
                SharedPreferencesManager.KEY_TOKEN,
                "Empty token!"
            )
        )

        button.setOnClickListener {
            val username = userNameEditText.text.toString()
            val password = passwordEditText.text.toString()

            loginViewModel.login(username, password)

            loginViewModel.isSuccessful.observe(this.viewLifecycleOwner) {
                Log.d(TAG, "Logged in successfully = $it")
                if (it) {
                    findNavController().navigate(R.id.action_loginFragment_to_listFragment)
                }
            }
        }

        return view
    }
}