package com.hotdogcode.notes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hotdogcode.notes.R
import com.hotdogcode.notes.utilities.Constants
import com.hotdogcode.notes.utilities.Injector
import com.hotdogcode.notes.utilities.ViewModelFactory
import com.hotdogcode.notes.viewModel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private var factory :ViewModelFactory? = null
    private var viewModel: SplashViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }
    private fun init(){
        factory = Injector.provideViewModelFactory(this)
        viewModel = ViewModelProvider(this,factory!!).get(SplashViewModel::class.java)
        viewModel!!._counter.observe(this, Observer {
            if(it==Constants.SPLASH_COUNTER)
                launchActivity()
        })
        viewModel!!.incCounter(Constants.SPLASH_COUNTER.toLong())
    }
    private fun launchActivity(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}
