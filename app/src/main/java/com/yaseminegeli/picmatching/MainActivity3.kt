package com.yaseminegeli.picmatching
// zorluk seviyesi 2*2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.yaseminegeli.picmatching.databinding.ActivityMain3Binding
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaPlayer1 = MediaPlayer.create(this,R.raw.prologue)
        val mediaPlayer2 = MediaPlayer.create(this,R.raw.happywheels)
        val mediaPlayer3 = MediaPlayer.create(this,R.raw.shockedeffect)
        val mediaPlayer4 = MediaPlayer.create(this,R.raw.congratulations)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val images: MutableList<Int> = mutableListOf(
            R.drawable.gry8hagrid,
            R.drawable.gry8hagrid,
            R.drawable.sly8bellatrix,
            R.drawable.sly8bellatrix,
        )
        val buttons = arrayOf(
            button29, button30, button31, button32
        )
        val cardBack: MutableList<Int> = mutableListOf(
            R.drawable.arkayuz
        )
        var clicked = 0
        var turnOver = false
        var lastClicked = -1
        var katsayi = 1F
        var oyuncupuan = 1.0F
        var skor = 0F
        var skor2 = 0F
        var kalansure = 0
        var sayac = 0F

        binding.basla3.setOnClickListener {
            mediaPlayer1.start()
            val sayici = object : CountDownTimer(45000,1000){

                override fun onTick(y: Long) {
                    textViewsure3.text = "Kalan süre: ${y / 1000} sn"
                    kalansure = (y/1000).toInt()
                }

                override fun onFinish() {
                    textViewsure3.text = "Oyun BİTTİ"
                    if(mediaPlayer1.isPlaying || mediaPlayer2.isPlaying){
                        mediaPlayer2.pause()
                        mediaPlayer1.pause()
                    }
                    mediaPlayer3.start()
                }

            }
            sayici.start()
        }
        binding.imageButton2.setOnClickListener(){

            if(mediaPlayer1.isPlaying){
                mediaPlayer1.pause()
            }
            else if(!mediaPlayer1.isPlaying){
                mediaPlayer1.start()
            }
        }
        images.shuffle()
        for (i: Int in 0..3) {
            //buttons[i].setBackgroundResource(harrypotter)
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                if (buttons[i].text == "cardBack" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])

                    if(buttons[i].text.contains("gry8")){
                        katsayi = 2F
                        puan3.text = katsayi.toString()
                        oyuncupuan = 12F
                    }else if(buttons[i].text.contains("sly8")){
                        katsayi = 2F
                        puan3.text = katsayi.toString()
                        oyuncupuan = 13F

                    }
                    if (clicked == 0){
                        lastClicked = i
                    }
                    clicked++
                    }else if (buttons[i].text !in "cardBack"){
                        buttons[i].setBackgroundResource(R.drawable.arkayuz)
                        buttons[i].text = "cardBack"
                        clicked--
                    }

                if ( clicked == 2){
                    turnOver = true
                    if(buttons[i].text == buttons[lastClicked].text){
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0

                        mediaPlayer2.start()
                        //puan hesaplama
                        skor = ((katsayi*oyuncupuan)/2.0F)
                        skor += skor
                        skor2 += skor*(kalansure/10F)
                        sayac++
                    }


                }else if(clicked == 0){
                    if(skor2>0){
                        skor = (oyuncupuan/katsayi)
                        skor2 -= skor*(kalansure/10F)
                    }
                    turnOver = false
                }
                puan3.text = skor2.toString()
                if(sayac >= 2){

                    if(mediaPlayer1.isPlaying || mediaPlayer2.isPlaying || mediaPlayer3.isPlaying){
                        mediaPlayer1.pause()
                        mediaPlayer2.pause()
                        mediaPlayer3.pause()
                    }
                    mediaPlayer4.start()
                    textViewsure3.text = "Oyun BİTTİ"
                }
            }
        }
    }
}