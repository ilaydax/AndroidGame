package com.yaseminegeli.picmatching
//parola sifirla sayfasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.yaseminegeli.picmatching.databinding.ActivityMainParolaSifirlaBinding

class MainParolaSifirla : AppCompatActivity() {
    lateinit var binding: ActivityMainParolaSifirlaBinding
    private  lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  binding = ActivityMainParolaSifirlaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.psifirlabtn.setOnClickListener{
            var psifirlamail = binding.psifirlamail.text.toString().trim()
            if(TextUtils.isEmpty(psifirlamail)){
                binding.psifirlamail.error = "Lütfen mail adresinizi yazınız."
            }else{
                auth.sendPasswordResetEmail(psifirlamail)
                    .addOnCompleteListener(this){ sifirlama->
                        if (sifirlama.isSuccessful){
                            Toast.makeText(this@MainParolaSifirla, "Mail adresinize sıfırlama bağlantısı gönderildi. ", Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this@MainParolaSifirla, "Sıfırlama işlemi başarısız.", Toast.LENGTH_LONG).show()
                        }
                    }
               }
           }

        //giris sayfasına gitmek için
        binding.psifirlagirisbtn.setOnClickListener{
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}