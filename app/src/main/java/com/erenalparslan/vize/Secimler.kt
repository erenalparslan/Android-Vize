package com.erenalparslan.vize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.erenalparslan.vize.databinding.ActivitySecimlerBinding

class Secimler : AppCompatActivity() {
    lateinit var binding: ActivitySecimlerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecimlerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var corba = intent.getStringExtra("gidencorba")

        binding.icerikCorba.text = "${corba} Çorbası"

        binding.dil.visibility = View.INVISIBLE
        binding.limon.visibility = View.INVISIBLE
        binding.beyin.visibility = View.INVISIBLE
        binding.kitir.visibility = View.INVISIBLE
        binding.terbiye.visibility = View.INVISIBLE
        binding.krema.visibility = View.INVISIBLE
        binding.nane.visibility = View.INVISIBLE
        binding.yag.visibility = View.INVISIBLE
        binding.sirke.visibility = View.INVISIBLE
        binding.kasar.visibility = View.INVISIBLE
        binding.tozBiber.visibility = View.INVISIBLE
        binding.sarimsak.visibility = View.INVISIBLE
        var gecis1 = Intent(applicationContext, Siparis::class.java)

        //Seek barları kontrol ediyoruz

        binding.tuzSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1 == 2) {

                    val alertDialog = AlertDialog.Builder(this@Secimler)
                    alertDialog.setMessage("Bu kadar tuz istediğinize emin misiniz !")
                    alertDialog.setTitle("Uyarı!")
                    alertDialog.setCancelable(false)
                    alertDialog.setIcon(R.drawable.tuz)
                    alertDialog.setPositiveButton("Evet") { dialog, which ->

                        Toast.makeText(applicationContext, "Bol Tuzlu Çorba", Toast.LENGTH_SHORT)
                            .show()

                    }
                    alertDialog.setNegativeButton("Hayır") { dialog, which ->
                        binding.tuzSeek.progress = 1
                    }
                    alertDialog.show()
                }

                if (p1 == 2) {
                    var tuzOran = "Bol Tuzlu"
                    gecis1.putExtra("tuzOran", tuzOran)
                }

                if (p1 == 1) {
                    var tuzOran = "Orta Tuzlu"
                    gecis1.putExtra("tuzOran", tuzOran)
                }
                if (p1 == 0) {
                    var tuzOran = "Tuzsuz"
                    gecis1.putExtra("tuzOran", tuzOran)
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }


        })
        binding.aciSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1 == 2) {

                    val alertDialog = AlertDialog.Builder(this@Secimler)
                    alertDialog.setMessage("Bu kadar acı istediğinize emin misiniz !")
                    alertDialog.setTitle("Uyarı!")
                    alertDialog.setCancelable(false)
                    alertDialog.setIcon(R.drawable.aci)
                    alertDialog.setPositiveButton("Evet") { dialog, which ->
                        Toast.makeText(applicationContext, "Bol Acılı Çorba", Toast.LENGTH_SHORT)
                            .show()

                    }
                    alertDialog.setNegativeButton("Hayır") { dialog, which ->
                        binding.aciSeek.progress = 1
                    }
                    alertDialog.show()
                }

                if (p1 == 2) {
                    var acioran = "Bol Acılı"
                    gecis1.putExtra("aciOran", acioran)
                }
                if (p1 == 1) {
                    var acioran = "Orta Acılı"
                    gecis1.putExtra("aciOran", acioran)
                }
                if (p1 == 0) {
                    var acioran = "Acısız"
                    gecis1.putExtra("aciOran", acioran)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {


            }


        })





            //ÇORBAYA GÖRE EKLENECEK MALZEMENİN GÖRÜNÜRLÜĞÜ AYARLANIR.

        if (corba == "Mercimek" || corba == "Ezogelin" || corba == "Düğün") {
            binding.nane.visibility = View.VISIBLE
            binding.yag.visibility = View.VISIBLE
            binding.kitir.visibility = View.VISIBLE
            binding.limon.visibility = View.VISIBLE
            binding.tozBiber.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())


        }
        if (corba == "Domates") {
            binding.nane.visibility = View.VISIBLE
            binding.yag.visibility = View.VISIBLE
            binding.kitir.visibility = View.VISIBLE
            binding.limon.visibility = View.VISIBLE
            binding.tozBiber.visibility = View.VISIBLE
            binding.kasar.visibility = View.VISIBLE
            binding.terbiye.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())


        }
        if (corba == "Brokoli") {
            binding.krema.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())

        }
        if (corba == "Kelle-Paça") {
            binding.sarimsak.visibility = View.VISIBLE
            binding.dil.visibility = View.VISIBLE
            binding.beyin.visibility = View.VISIBLE
            binding.sirke.visibility = View.VISIBLE
            binding.yag.visibility = View.VISIBLE
            binding.limon.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())

        }
        if (corba == "Yayla") {
            binding.nane.visibility = View.VISIBLE
            binding.yag.visibility = View.VISIBLE
            binding.kitir.visibility = View.VISIBLE
            binding.tozBiber.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())

        }
        if (corba == "Şehriye") {
            binding.nane.visibility = View.VISIBLE
            binding.yag.visibility = View.VISIBLE
            binding.limon.visibility = View.VISIBLE
            binding.tozBiber.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())

        }
        if (corba == "Tarhana") {
            binding.yag.visibility = View.VISIBLE
            binding.tozBiber.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())

        }
        if (corba == "Mantar") {
            binding.krema.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())

        }
        if (corba == "İşkembe") {
            binding.sarimsak.visibility = View.VISIBLE
            binding.yag.visibility = View.VISIBLE
            binding.limon.visibility = View.VISIBLE
            binding.tozBiber.visibility = View.VISIBLE
            binding.sirke.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            gecis1.putExtra("ekstra", binding.baskaArzu.text.toString())

        }
        if (corba == "Tavuk") {
            binding.krema.visibility = View.VISIBLE
            binding.yag.visibility = View.VISIBLE
            binding.limon.visibility = View.VISIBLE
            gecis1.putExtra("gidencorba", corba)
            var ekstra = binding.baskaArzu.text.toString()
            gecis1.putExtra("ekstra", ekstra)

        }

        //EKLENECEK MALZEMELERİ DİĞER TARAFA YAZMAK İÇİN KONTROL EDİYORUZ

        binding.krema.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var krema1 = binding.krema.text.toString()
                gecis1.putExtra("krema", krema1)
            }
        })
        binding.yag.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var yag1 = binding.yag.text.toString()
                gecis1.putExtra("yag", yag1)
            }
        })
        binding.limon.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var limon1 = binding.limon.text.toString()
                gecis1.putExtra("limon", limon1)
            }
        })
        binding.sarimsak.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var sarimsak1 = binding.sarimsak.text.toString()
                gecis1.putExtra("sarimsak", sarimsak1)
            }
        })
        binding.tozBiber.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var tozBiber1 = binding.tozBiber.text.toString()
                gecis1.putExtra("tozBiber", tozBiber1)
            }
        })
        binding.sirke.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var sirke1 = binding.sirke.text.toString()
                gecis1.putExtra("sirke", sirke1)
            }
        })
        binding.kitir.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var kitir1 = binding.kitir.text.toString()
                gecis1.putExtra("kitir", kitir1)
            }
        })
        binding.dil.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var dil1 = binding.dil.text.toString()
                gecis1.putExtra("dil", dil1)
            }
        })
        binding.beyin.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var beyin1 = binding.beyin.text.toString()
                gecis1.putExtra("beyin", beyin1)
            }
        })
        binding.nane.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var nane1 = binding.nane.text.toString()
                gecis1.putExtra("nane", nane1)
            }
        })
        binding.terbiye.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var terbiye1 = binding.terbiye.text.toString()
                gecis1.putExtra("terbiye", terbiye1)
            }
        })
        binding.kasar.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked) {
                var kasar1 = binding.kasar.text.toString()
                gecis1.putExtra("kasar", kasar1)
            }
        })
        gecis1.putExtra("isim", corba)

        binding.siparisVer.setOnClickListener({

            var isim = binding.baskaArzu.text.toString()
            gecis1.putExtra("ekstra", isim)


            val alertDialog = AlertDialog.Builder(this@Secimler)
            alertDialog.setMessage("Siparişiniz Hazırlanacak .Devam etmek istediğinize emin misiniz !")
            alertDialog.setTitle("Siparişinizin Durumu")
            alertDialog.setIcon(R.drawable.ealogo)
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton("TEKRAR KONTROL ETMEK İSTİYORUM") { dialog, which -> }
            alertDialog.setNegativeButton("EVET") { dialog, which ->
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {


                    }

                    override fun onFinish() {
                        startActivity(gecis1)
                        finish()

                    }

                }.start()

            }
            alertDialog.show()


        })


    }

}