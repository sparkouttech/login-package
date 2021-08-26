package com.sparkout.login_register_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sparkout.login_register_kotlin.R
import com.sparkout.login_register_kotlin.callback.LoginDataCallback
import com.sparkout.login_register_kotlin.common.Utils.Companion.preventDoubleClick
import com.sparkout.login_register_kotlin.common.Utils.Companion.showToast
import com.sparkout.login_register_kotlin.databinding.FragmentLoginBinding
import com.sparkout.login_register_kotlin.model.LoginDataModel

class LoginFragment : Fragment(), View.OnClickListener {
    var mFragmentLoginBinding: FragmentLoginBinding? = null
    var mLoginDataCallback: LoginDataCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mFragmentLoginBinding = FragmentLoginBinding.inflate(inflater)
        mLoginDataCallback = activity as LoginDataCallback

        mFragmentLoginBinding?.btnLogin?.setOnClickListener(this)
        return mFragmentLoginBinding?.root!!
    }

    private fun validate(): Boolean {
        return when {
            mFragmentLoginBinding?.etUsername?.text.toString().trim().isEmpty() -> {
                showToast(requireContext(), "Enter your username")
                mFragmentLoginBinding?.etUsername?.requestFocus()
                false
            }
            mFragmentLoginBinding?.etPassword?.text.toString().trim().isEmpty() -> {
                showToast(requireContext(), "Enter your password")
                mFragmentLoginBinding?.etPassword?.requestFocus()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun login() {
        if (validate()) {
            val mLoginDataModel = LoginDataModel()
            mLoginDataModel.username = mFragmentLoginBinding?.etUsername?.text.toString()
            mLoginDataModel.password = mFragmentLoginBinding?.etPassword?.text.toString()
            mLoginDataCallback?.let {
                mLoginDataCallback?.userData(mLoginDataModel)
            }
        }
    }

    override fun onClick(v: View?) {
        preventDoubleClick(v!!)
        when (v.id) {
            R.id.btn_login -> {
                login()
            }
        }
    }
}