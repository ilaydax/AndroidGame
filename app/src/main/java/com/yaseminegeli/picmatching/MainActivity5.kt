package com.yaseminegeli.picmatching
//oyuna giris ekrani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yaseminegeli.picmatching.databinding.ActivityMain5Binding
import com.yaseminegeli.picmatching.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.devam.setOnClickListener { //başla butonuna basıldığında
            val chk1 = binding.checkBox
            val chk2 = binding.checkBox2
            val chk3 = binding.checkBox3
            val chk4 = binding.checkBox4
            val chk5 = binding.checkBox5

            if(chk1.isChecked && chk4.isChecked){
                intent = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intent)
            }
            if(chk1.isChecked && chk3.isChecked){
                intent = Intent(applicationContext, MainActivity3::class.java)
                startActivity(intent)
            }
            if(chk1.isChecked && chk5.isChecked){
                intent = Intent(applicationContext, MainActivity4::class.java)
                startActivity(intent)
            }

            if(chk2.isChecked && chk4.isChecked){
                intent = Intent(applicationContext, MainActivity22::class.java)
                startActivity(intent)
            }
            if(chk2.isChecked && chk3.isChecked){
                intent = Intent(applicationContext, MainActivity32::class.java)
                startActivity(intent)
            }
            if(chk2.isChecked && chk5.isChecked){
                intent = Intent(applicationContext, MainActivity42::class.java)
                startActivity(intent)
            }
        }

        /*binding.btncikis.setOnClickListener { //cikis yap butonuna basıldıgında
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        } */

        //binding.btndevam.setOnClickListener { //cikis yap butonuna basıldıgında
        //intent = Intent(applicationContext, MainActivity::class.java)
        //startActivity(intent)
        //}
    }
}