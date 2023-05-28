package com.yaseminegeli.picmatching
//kayit ol sayfasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.yaseminegeli.picmatching.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    lateinit var binding: ActivityMainKayitOlBinding
    private  lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference?=null //baslangıç boş olabilir
    var database:FirebaseDatabase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //var database = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("kullanici") //başlangıç değerini boş geçmesin

        //kayıt ol butonu ile kayıt
        binding.btnKaydet.setOnClickListener{

            var kayitkullaniciadi = binding.KayitKullaniciAdi.text.toString()
            var kayitmailadresi = binding.KayitMailAdresi.text.toString()
            var kayitparola = binding.KayitParola.text.toString()

            if (TextUtils.isEmpty(kayitkullaniciadi)){
                binding.KayitKullaniciAdi.error = "Lütfen kullanıcı adı giriniz!"
                return@setOnClickListener
            }else if (TextUtils.isEmpty(kayitmailadresi)){
                binding.KayitMailAdresi.error = "Lütfen mail adresi giriniz!"

                return@setOnClickListener
            }else if (TextUtils.isEmpty(kayitparola)){
                binding.KayitParola.error = "Lütfen parola giriniz!"
                return@setOnClickListener
            }

            // mail, parola ve kullanıcı bilgilerini veritabanına ekleme
            auth.createUserWithEmailAndPassword(binding.KayitMailAdresi.text.toString(), binding.KayitParola.text.toString())
                .addOnCompleteListener(this){ task->
                    if(task.isSuccessful) {
                        //kullanıcı bilgilerini alalım
                        var currentUser = auth.currentUser
                        //kullanıcı id sini alıp o id adı altında kullanıcı adımızı kayıt edelim
                        var currentUserDb = currentUser?.let { it1->databaseReference?.child(it1.uid)}
                        currentUserDb?.child("kullaniciadi")?.setValue(binding.KayitKullaniciAdi.text.toString())
                        Toast.makeText(this@MainKayitOl, "Kayıt Başarılı!", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@MainKayitOl, "Kayıt Hatalı!", Toast.LENGTH_LONG).show()
                    }
                }

        }

        binding.btnGirisDon.setOnClickListener{
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}



//var KayitMailAdresi = binding.KayitMailAdresi.text.toString()
//var KayitKullaniciAdi = binding.KayitKullaniciAdi.text.toString()
//var KayitParola = binding.KayitParola.text.toString()
//database.setValue(Kullanici(KayitMailAdresi, KayitKullaniciAdi, KayitParola))
//database.child(KayitKullaniciAdi).setValue(Kullanici(KayitMailAdresi, KayitParola))

//Toast.makeText(applicationContext,"Kayıt Başarılı!", Toast.LENGTH_LONG).show()

//binding.KayitMailAdresi.text.clear()
//binding.KayitKullaniciAdi.text.clear()
//binding.KayitParola.text.clear()