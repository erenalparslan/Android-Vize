package com.erenalparslan.vize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.erenalparslan.vize.databinding.ActivityCorbaBinding

class Corba : AppCompatActivity() {
    lateinit var binding: ActivityCorbaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCorbaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Çorbaları ve butonu gizledik
        binding.corbalar.visibility = View.INVISIBLE
        binding.devam.visibility = View.INVISIBLE
        //Çorba tıklandıktan  sonra çorbalar listelendi
        binding.isCorba.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                binding.corbalar.visibility = View.VISIBLE
                binding.devam.visibility = View.VISIBLE
            } else {
                binding.corbalar.visibility = View.INVISIBLE
                binding.devam.visibility = View.INVISIBLE

            }


        }

        //Seçim için bir değişken tanımladım.Seçilmediyse 0 seçilirse 1 olacak ve bunu kontrol edeceğiz.
        var isSelect = 0
        binding.corbalar.setOnCheckedChangeListener { radioGroup, i ->
            isSelect = 1


        }


        //Buton basımından sonra test yapılmalı
        binding.devam.setOnClickListener({
            if (isSelect == 1) {
                //Seçildiyse özel toast çıkar ve geçiş tamamlanır.

                var tasarim = layoutInflater.inflate(R.layout.toast_ozel, null)
                var id = binding.corbalar.checkedRadioButtonId
                var toasttakiyazi = findViewById<Button>(id)
                var corbaAdi = tasarim.findViewById<TextView>(R.id.corbaAdi)
                corbaAdi.text = "${toasttakiyazi.text} Çorbası"


                var toastozel = Toast(applicationContext)
                toastozel.view = tasarim
                toastozel.setGravity(Gravity.BOTTOM, 0, 0)
                toastozel.duration = Toast.LENGTH_SHORT

                toastozel.show()

                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {

                    }

                    override fun onFinish() {
                        var gecis = Intent(applicationContext, Secimler::class.java)
                        gecis.putExtra("gidencorba", toasttakiyazi.text)
                        startActivity(gecis)
                        finish()
                    }
                }.start()


            } else if (isSelect == 0) {

                //Seçilmediyse uyari mesajı verilir

                val alertDialog = AlertDialog.Builder(this@Corba)
                alertDialog.setMessage("Lütfen Seçim Yapınız !")
                alertDialog.setTitle("UYARİ")
                alertDialog.setCancelable(false)
                alertDialog.setIcon(R.drawable.ealogo)
                alertDialog.setNegativeButton("Tekrar Dene") { dialog, which -> dialog.cancel() }
                alertDialog.show()


            }
        })


    }
}