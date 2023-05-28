package com.yaseminegeli.picmatching
//zorluk seviyesi 6*6

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.yaseminegeli.picmatching.databinding.ActivityMain4Binding
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_main4.textViewsure2

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaPlayer1 = MediaPlayer.create(this,R.raw.prologue)
        val mediaPlayer2 = MediaPlayer.create(this,R.raw.happywheels)
        val mediaPlayer3 = MediaPlayer.create(this,R.raw.shockedeffect)
        val mediaPlayer4 = MediaPlayer.create(this,R.raw.congratulations)
        val binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val images: MutableList<Int> = mutableListOf(
            R.drawable.gry8hermione,
            R.drawable.gry8hermione,
            R.drawable.gry8dumble2,
            R.drawable.gry8dumble2,
            R.drawable.gry8lilypotter2,
            R.drawable.gry8lilypotter2,
            R.drawable.gry8lupin,
            R.drawable.gry8lupin,
            R.drawable.hfp8cedric,
            R.drawable.hfp8cedric,
            R.drawable.hfp8helga,
            R.drawable.hfp8helga,
            R.drawable.hfp8leanne,
            R.drawable.hfp8leanne,
            R.drawable.hfp8macmillan,
            R.drawable.hfp8macmillan,
            R.drawable.hfp8tonks,
            R.drawable.hfp8tonks,
            R.drawable.rcv8garrick,
            R.drawable.rcv8garrick,
            R.drawable.rvc8lockhart,
            R.drawable.rvc8lockhart,
            R.drawable.rvc8luna,
            R.drawable.rvc8luna,
            R.drawable.rvc8chochang,
            R.drawable.rvc8chochang,
            R.drawable.rvc8trelawney,
            R.drawable.rvc8trelawney,
            R.drawable.sly8umbridge,
            R.drawable.sly8umbridge,
            R.drawable.sly8tomriddle,
            R.drawable.sly8tomriddle,
            R.drawable.sly8slughorn,
            R.drawable.sly8slughorn,
            R.drawable.sly8nrmalfoy,
            R.drawable.sly8nrmalfoy,
        )
        val buttons = arrayOf(
            button33, button34, button35, button36, button37, button38, button39,button40,
            button41, button42, button43, button44,button45,button46,button47,button48,
            button49, button50, button51, button52, button53, button54, button55, button56,
            button57, button58, button59, button60, button61,button62,button63,button64,button65,
            button66,button67,button68
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

        binding.basla4.setOnClickListener {
            mediaPlayer1.start()
            val sayici=object : CountDownTimer(45000,1000){

                override fun onTick(y: Long) {
                    textViewsure2.text = "Kalan süre: ${y / 1000} sn"
                    kalansure= (y/1000).toInt()
                }

                override fun onFinish() {
                    textViewsure2.text = "Oyun BİTTİ"
                    if(mediaPlayer1.isPlaying || mediaPlayer2.isPlaying){
                        mediaPlayer2.pause()
                        mediaPlayer1.pause()
                    }
                    mediaPlayer3.start()
                }

            }
            sayici.start()
        }
        binding.imageButton3.setOnClickListener(){

            if(mediaPlayer1.isPlaying){
                mediaPlayer1.pause()
            }
            else if(!mediaPlayer1.isPlaying){
                mediaPlayer1.start()
            }
        }
        images.shuffle()
        for (i: Int in 0..35) {
            //buttons[i].setBackgroundResource(harrypotter)
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                if (buttons[i].text == "cardBack" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if(buttons[i].text.contains("gry8")){
                        katsayi = 2F
                        puan4.text = katsayi.toString()
                        if(buttons[i].text.contains("hermione")){
                            oyuncupuan = 10F
                        }else if(buttons[i].text.contains("dumble2")){
                            oyuncupuan = 20F
                        }else if(buttons[i].text.contains("lilypotter2")){
                            oyuncupuan = 12F
                        }else if(buttons[i].text.contains("lupin")){
                            oyuncupuan = 10F
                        }
                    }else if(buttons[i].text.contains("rcv8")){
                        katsayi=1F
                        puan4.text = katsayi.toString()
                        if(buttons[i].text.contains("garrick")){
                            oyuncupuan = 15F
                        }else if(buttons[i].text.contains("lockhart")){
                            oyuncupuan = 13F
                        }else if(buttons[i].text.contains("luna")){
                            oyuncupuan = 9F
                        }else if(buttons[i].text.contains("chochang")){
                            oyuncupuan = 11F
                        }else if(buttons[i].text.contains("trelawney")){
                            oyuncupuan = 14F
                        }
                        //puan.text=katsayi.toString()
                    }else if(buttons[i].text.contains("sly8")){
                        katsayi=2F
                        puan4.text = katsayi.toString()
                        if(buttons[i].text.contains("umbridge")){
                            oyuncupuan = 10F
                        }else if(buttons[i].text.contains("tomriddle")){
                            oyuncupuan = 20F
                        }else if(buttons[i].text.contains("slughorn")){
                            oyuncupuan = 12F
                        }else if(buttons[i].text.contains("nrmalfoy")){
                            oyuncupuan = 12F
                        }
                        //puan.text=katsayi.toString()
                    }else if(buttons[i].text.contains("hfp8")){
                        katsayi=1F
                        puan4.text = katsayi.toString()
                        if(buttons[i].text.contains("cedric")){
                            oyuncupuan = 18F
                        }else if(buttons[i].text.contains("helga")){
                            oyuncupuan = 20F
                        }else if(buttons[i].text.contains("leanne")){
                            oyuncupuan = 10F
                        }else if(buttons[i].text.contains("macmillan")){
                            oyuncupuan = 5F
                        }else if(buttons[i].text.contains("tonks")){
                            oyuncupuan = 14F
                        }
                        //puan.text=katsayi.toString()
                    }
                    if (clicked == 0){
                        lastClicked =i
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

                puan4.text = skor2.toString()
                if(sayac >= 8){

                    if(mediaPlayer1.isPlaying || mediaPlayer2.isPlaying || mediaPlayer3.isPlaying){
                        mediaPlayer1.pause()
                        mediaPlayer2.pause()
                        mediaPlayer3.pause()
                    }
                    mediaPlayer4.start()
                    textViewsure2.text = "Oyun BİTTİ"
                }
            }
        }
    }
}