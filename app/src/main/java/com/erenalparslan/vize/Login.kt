package com.erenalparslan.vize

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.erenalparslan.vize.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Tüm tikler gizlendi
        binding.eKontrol.visibility = View.INVISIBLE
        binding.rKontrol.visibility = View.INVISIBLE
        binding.eeKontrol.visibility = View.INVISIBLE
        binding.nKontrol.visibility = View.INVISIBLE
        binding.progress.visibility = View.INVISIBLE

        //Kontrolle tikleri açıyoruz
        binding.ilkE.setOnClickListener({
            binding.eKontrol.visibility = View.VISIBLE
            binding.rHarf.setOnClickListener({
                binding.rKontrol.visibility = View.VISIBLE
                binding.eHarf.setOnClickListener({
                    binding.eeKontrol.visibility = View.VISIBLE
                    binding.nHarf.setOnClickListener({
                        binding.nKontrol.visibility = View.VISIBLE
                        binding.progress.visibility = View.VISIBLE
                        object : CountDownTimer(3000, 1000) {
                            override fun onTick(p0: Long) {

                            }

                            override fun onFinish() {
                                //3sn bekleyip diğer sayfaya geçiyoruz
                                var gecis = Intent(applicationContext, Corba::class.java)
                                startActivity(gecis)
                                finish()
                            }
                        }.start()

                    })
                })
            })
        })
    }
}