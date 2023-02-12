package com.erenalparslan.vize

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import com.erenalparslan.vize.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    //02205076019 EREN ALPARSLAN

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        object : CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {


            }

            override fun onFinish() {
                //5 sn bekleyip geçme
                var gecis = Intent(applicationContext, Login::class.java)
                startActivity(gecis)
                finish()
            }

        }.start()

        val corbaciEren = findViewById<TextView>(R.id.isim)


        val animasyonSuresi = 1000L

        ObjectAnimator.ofFloat(corbaciEren, "textSize", 0f, 50f).apply {
            duration = animasyonSuresi
            start()
        }

    }
}