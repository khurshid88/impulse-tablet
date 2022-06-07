package com.impulse.impulse_driver.activity

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.impulse.impulse_driver.R
import com.impulse.impulse_driver.databinding.ActivityAmbulanceBinding
import com.impulse.impulse_driver.databinding.ActivitySplashBinding
import com.impulse.impulse_driver.manager.PrefsManager
import java.util.*

/** The application for high volume message **/

class AmbulanceActivity : BaseActivity() {

    lateinit var mediaPlayer : MediaPlayer
    private lateinit var binding: ActivityAmbulanceBinding
    private var turnOn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAmbulanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

        binding.apply {
            lottieAnimation.setAnimation("sos_animation_plus.json")
            lottieAnimationAmbulance.setAnimation("ambulance_ways.json")
            sosView()

            lottieAnimation.setOnClickListener {
                callMainActivity(this@AmbulanceActivity)
                mediaPlayer.stop()
                saveLoggedState()
                finish()
            }

            callCancel.setOnClickListener {
                mediaPlayer.stop()
                callSplashActivity(this@AmbulanceActivity)
                finish()
            }
        }
    }

    private fun sosView() {
        mediaPlayer = MediaPlayer.create(this,R.raw.siren)
        mediaPlayer .start()
        mediaPlayer.isLooping = true
    }

    private fun saveLoggedState() {
        turnOn = false
        PrefsManager.getInstance(context)!!.setFirstTime("turnOn",turnOn)
    }
}