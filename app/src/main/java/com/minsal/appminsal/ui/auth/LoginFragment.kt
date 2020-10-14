package com.minsal.appminsal.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.minsal.appminsal.databinding.FragmentLoginBinding
import com.minsal.appminsal.data.network.AuthApi
import com.minsal.appminsal.data.network.Resources
import com.minsal.appminsal.data.respository.AuthRepository
import com.minsal.appminsal.ui.base.BaseFragment
import com.minsal.appminsal.ui.enable
import com.minsal.appminsal.ui.home.HomeActivity
import com.minsal.appminsal.ui.startNewActivity
import com.minsal.appminsal.ui.visible
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding,AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.progressBar.visible(false)
        binding.btnLogin.enable(false)
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visible(false)

            when(it){
                is  Resources.Success -> {

                        viewModel.saveAuthToken(it.value.token)
                        requireActivity().startNewActivity(HomeActivity::class.java)

                }
                is Resources.Failure -> {
                    Toast.makeText(requireContext(),"Failed",Toast.LENGTH_LONG).show()
                }
            }
        })
        binding.edtPass.addTextChangedListener {
            val username = binding.edtUser.text.toString().trim()
            binding.btnLogin.enable(username.isNotEmpty() && it.toString().isNotEmpty())
        }
        binding.btnLogin.setOnClickListener{
            binding.progressBar.visible(true)
            val username = binding.edtUser.text.toString().trim()
            val password = binding.edtPass.text.toString().trim()
            viewModel.login(username,password)
        }

    }
    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentLoginBinding.inflate(inflater,container,false);

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java),userPreferences)

}