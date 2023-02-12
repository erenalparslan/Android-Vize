package com.erenalparslan.vize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.erenalparslan.vize.databinding.ActivitySiparisBinding
import java.util.*
import kotlin.collections.ArrayList

class Siparis : AppCompatActivity() {
    lateinit var binding: ActivitySiparisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siparis)
        binding = ActivitySiparisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // ÖNCE TÜM MALZEMELERİ ALIYORUZ VE DEĞİŞKENE ATIYORUZ

        var icerikList = ArrayList<String>()
        var corba = intent.getStringExtra("gidencorba")
        var ekstra = intent.getStringExtra("ekstra")
        var aciOran = intent.getStringExtra("aciOran")
        var tuzOran = intent.getStringExtra("tuzOran")
        var krema = intent.getStringExtra("krema")
        var yag = intent.getStringExtra("yag")
        var limon = intent.getStringExtra("limon")
        var nane = intent.getStringExtra("nane")
        var beyin = intent.getStringExtra("beyin")
        var dil = intent.getStringExtra("dil")
        var kitir = intent.getStringExtra("kitir")
        var terbiye = intent.getStringExtra("terbiye")
        var tozBiber = intent.getStringExtra("tozBiber")
        var sarimsak = intent.getStringExtra("sarimsak")
        var kasar = intent.getStringExtra("kasar")
        var sirke = intent.getStringExtra("sirke")

        //Animasyonumuzu tanımlıyoruz

        val animasyon: Animation = AlphaAnimation(-1f, 1.0f)
        animasyon.duration = 1000

        animasyon.repeatMode = Animation.ABSOLUTE
        animasyon.repeatCount = Animation.INFINITE
        binding.yeni.startAnimation(animasyon)

        //Ekstra boşsa gizli olacak değilse yazılacak

        if (ekstra == "") {
            binding.ekstra.visibility == View.INVISIBLE
        } else {
            binding.ekstra.text = "Ekstra istek: $ekstra"
        }

        //Progges durumundaki seekbar null döndürüyordu eğer değiştirilmezse null dönmemesi için yazıldı

        if (aciOran == null) {
            aciOran = "Acısız"
        }
        if (tuzOran == null) {
            tuzOran = "Tuzsuz"
        }

        binding.check.text = "Bir ${corba} Çorbası Çeeeek,$tuzOran ve $aciOran Olsunn"

        //Yeni sipariş tıklanması

        binding.yeni.setOnClickListener({

            var gecis = Intent(applicationContext, Corba::class.java)
            startActivity(gecis)
            finish()
        })
        binding.cikis.setOnClickListener({

            val alertDialog = AlertDialog.Builder(this@Siparis)
            alertDialog.setMessage("Çıkış İstediğinize Emin Misiniz ?")
            alertDialog.setTitle("Çıkış")
            alertDialog.setIcon(R.drawable.ealogo)
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton("Hayır") { dialog, which -> }
            alertDialog.setNegativeButton("Evet") { dialog, which ->
                finish()

            }
            alertDialog.show()
        })

        //   Seçimler Activitysinde her malzeme bu Activitye aktarılır ancak seçilmeyenler null değeri alır,bunları ayıklamak için
        // malzemeleri if koşulu ile arrayListe attım


        if (krema != null) {
            icerikList.add(krema)

        }
        if (yag != null) {
            icerikList.add(yag)

        }
        if (limon != null) {
            icerikList.add(limon)

        }
        if (nane != null) {
            icerikList.add(nane)

        }
        if (beyin != null) {
            icerikList.add(beyin)

        }
        if (dil != null) {
            icerikList.add(dil)

        }
        if (kitir != null) {
            icerikList.add(kitir)

        }
        if (terbiye != null) {
            icerikList.add(terbiye)

        }
        if (tozBiber != null) {
            icerikList.add(tozBiber)

        }
        if (sarimsak != null) {
            icerikList.add(sarimsak)

        }
        if (kasar != null) {
            icerikList.add(kasar)

        }
        if (sirke != null) {
            icerikList.add(sirke)

        }

        //Tekrardan boşları temizliyorum
        icerikList.trimToSize()

        //Hiçbir malzeme seçilmediyse liste boyutu 0 olacak ve bu 3 ü gereksiz olacağından görünmez yapıyorum

        if (icerikList.size == 0) {
            binding.icinde.visibility = View.INVISIBLE
            binding.check2.visibility = View.INVISIBLE
            binding.olsun.visibility = View.INVISIBLE
        }

        //Malzeme sayısına göre String oluşturuyorum

        if (icerikList.size == 1) {
            binding.check2.text = "${icerikList.get(0)}"
        }
        if (icerikList.size == 2) {
            binding.check2.text = "${icerikList.get(0)}, ${icerikList.get(1)}"
        }
        if (icerikList.size == 3) {
            binding.check2.text = "${icerikList.get(0)}, ${icerikList.get(1)},${icerikList.get(2)}"
        }
        if (icerikList.size == 4) {
            binding.check2.text =
                "${icerikList.get(0)}, ${icerikList.get(1)},${icerikList.get(2)}, ${icerikList.get(3)}"
        }
        if (icerikList.size == 5) {
            binding.check2.text =
                "${icerikList.get(0)}, ${icerikList.get(1)},${icerikList.get(2)}, ${icerikList.get(3)},${
                    icerikList.get(4)
                }"
        }
        if (icerikList.size == 6) {
            binding.check2.text =
                "${icerikList.get(0)}, ${icerikList.get(1)},${icerikList.get(2)}, ${icerikList.get(3)},${
                    icerikList.get(4)
                }, ${icerikList.get(5)}"
        }

        //Ödevde maksimum 7 malzeme seçiliyor
        if (icerikList.size == 7) {
            binding.check2.text =
                "${icerikList.get(0)}, ${icerikList.get(1)},${icerikList.get(2)}, ${icerikList.get(3)},${
                    icerikList.get(4)
                }, ${icerikList.get(5)},${icerikList.get(6)}"
        }


    }


}