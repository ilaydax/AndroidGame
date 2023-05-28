package com.yaseminegeli.picmatching
//giris sayfası

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.yaseminegeli.picmatching.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityMainBinding
    //lateinit var preferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        //kullanıcının oturum açıp açmadığını kontrol etme
        var currentUser = auth.currentUser
        //if (currentUser != null) {
        //startActivity(Intent(this@MainActivity,MainGiris::class.java))
        //finish()
        //}
        //giriş butonuna tıklandığında
        binding.btnGirisYap.setOnClickListener{
            var girismail = binding.GirisKullaniciAdi.text.toString()
            var girissifre = binding.GirisParola.text.toString()

            if(TextUtils.isEmpty(girismail)){
                binding.GirisKullaniciAdi.error = "Lütfen mail adresinizi yazınız."
                return@setOnClickListener
            }else if(TextUtils.isEmpty(girissifre)){
                binding.GirisParola.error = "Lütfen parolanızı yazınız."
                return@setOnClickListener
            }

            //giris bilgilerinizi doğrulayıp giriş yapma
            auth.signInWithEmailAndPassword(girismail,girissifre)
                .addOnCompleteListener(this){
                    if(it.isSuccessful){
                        intent = Intent(applicationContext, MainActivity5::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(applicationContext,"Giriş Hatalı!",Toast.LENGTH_LONG).show()
                    }
                }
        }

        //kayıt ol kısmına gitmek için
        binding.btnKayTOl.setOnClickListener{
            intent = Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
            finish()
        }

        //parolamı unuttum kısmına gitmek için
        binding.parolamiunuttum.setOnClickListener{
            intent = Intent(applicationContext,MainParolaSifirla::class.java)
            startActivity(intent)
            finish()
        }


    }

}
//user = FirebaseAuth.getInstance()
//preferences = getSharedPreferences("Kullanici", MODE_PRIVATE)
//binding.btnGirisYap.setOnClickListener{ //giris yap butonuna basıldıgında
//registerUser()



//var kayitliMail = preferences.getString("kullanicimail","")
//var kayitliKullaniciAdi = preferences.getString("kullaniciadi","")
//var kayitliParola = preferences.getString("kullaniciparola","")

//var girisKullanici = binding.GirisKullaniciAdi.text.toString()
//var girisParola = binding.GirisParola.text.toString()

//if( (kayitliKullaniciAdi == girisKullanici) && (kayitliParola == girisParola) ){
//intent = Intent(applicationContext,MainGiris::class.java)
//startActivity(intent)
//Toast.makeText(applicationContext, "Giriş başarılı!",Toast.LENGTH_LONG).show()
//}else{
//Toast.makeText(applicationContext, "Giriş bilgileri hatalı!",Toast.LENGTH_LONG).show()
//}

//}



//binding.btnKayTOl.setOnClickListener{ //giris yap butonuna basıldıgında
//intent = Intent(applicationContext,MainKayitOl::class.java)
//startActivity(intent)

//}
//}
//private fun registerUser(){

//val mail = binding.GirisKullaniciAdi.text.toString()
//val sifre = binding.GirisParola.text.toString()

//if(mail.isNotEmpty() && sifre.isNotEmpty()){
//user.createUserWithEmailAndPassword(mail,sifre).addOnCompleteListener(MainActivity()){task->
//if (task.isSuccessful){
//Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
//startActivity(Intent(this, MainGiris::class.java))
//finish()

//}else{
//user.signInWithEmailAndPassword(mail, sifre).addOnCompleteListener{mTask->
//if (mTask.isSuccessful){
//startActivity(Intent(this, MainGiris::class.java))
//finish()

//}else{
//Toast.makeText(this, task.exception!!.message, Toast.LENGTH_SHORT).show()
//}

//}
//}

//}

//}else{
//Toast.makeText(this, "Kullanıcı adı ve parola boş olamaz!! ", Toast.LENGTH_SHORT).show()
//}
//}

