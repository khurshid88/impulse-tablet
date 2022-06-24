package com.impulse.impulse_driver.activity

import android.graphics.Color
import android.hardware.input.InputManager
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.impulse.impulse_driver.R
import com.impulse.impulse_driver.databinding.ActivitySignInBinding
import com.impulse.impulse_driver.databinding.ActivitySignUpBinding
import com.impulse.impulse_driver.databinding.ActivitySplashBinding
import com.impulse.impulse_driver.manager.PrefsManager

/**
 * To register the application driver (can only use a special code)
 * **/

class SignUpActivity : BaseActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private var isSignIn : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        initViews()
    }

    private fun initViews() {
        var specialId = 13331
        binding.apply {
            bOpenActivity.setOnClickListener {
                var registerId = etDriverID.text.toString().trim()
                var etDriverNames = etDriverName.text.toString().trim()
                var et_hospitals = etHospital.text.toString().trim()
            if (!registerId.equals(specialId.toString())) {
                etPasswordLayout.error = "Notog'ri Id raqami"

            }else if (etDriverNames==""||etDriverNames.length<5){
                etDriverName.error = "Notog'ri Ism"
            }else if (et_hospitals==""||et_hospitals.length<5) {
                etHospital.error = "Notog'ri joy"
            }else {
                isSignIn = false
                PrefsManager.getInstance(context)!!.setFirstTime("safe",isSignIn)
                bOpenActivity.setTextColor(Color.WHITE)
                callSplashActivity(this@SignUpActivity)
                finish()
            }
            }
        }
    }
}