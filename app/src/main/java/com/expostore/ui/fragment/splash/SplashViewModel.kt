package com.expostore.ui.fragment.splash

import android.content.Context
import com.expostore.R
import com.expostore.data.AppPreferences
import com.expostore.ui.base.BaseViewModel
import com.expostore.ui.fragment.splash.interactor.SplashInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Fedotov Yakov
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val interactor: SplashInteractor,
    private val context: Context
) : BaseViewModel() {


    override fun onStart() {
        navController.navigate(R.id.action_splashFragment_to_mainFragment)
    }
}