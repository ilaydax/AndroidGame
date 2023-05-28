package com.yaseminegeli.picmatching
//2 kisilik 6*6

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.yaseminegeli.picmatching.databinding.ActivityMain22Binding
import com.yaseminegeli.picmatching.databinding.ActivityMain42Binding
import kotlinx.android.synthetic.main.activity_main22.*
import kotlinx.android.synthetic.main.activity_main22.textViewsure202
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_main42.*

class MainActivity42 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaPlayer1 = MediaPlayer.create(this,R.raw.prologue)
        val mediaPlayer2 = MediaPlayer.create(this,R.raw.happywheels)
        val mediaPlayer3 = MediaPlayer.create(this,R.raw.shockedeffect)
        val mediaPlayer4 = MediaPlayer.create(this,R.raw.congratulations)
        val binding = ActivityMain42Binding.inflate(layoutInflater)
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
        val evkatsayi = ArrayList<Int>()

        val buttons = arrayOf(
            button3302, button3402, button3502, button3602, button3702, button3802, button3902,button4002,
            button4102, button4202, button4302, button4402,button4502,button4602,button4702,button4802,
            button4902, button5002, button5102, button5202, button5302, button5402, button5502, button5602,
            button5702, button5802, button5902, button6002, button6102,button6202,button6302,button6402,button6502,
            button6602,button6702,button6802
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
        var sayac = 0
        var hesap = 0F
        var toplampuan1 = 0F
        var toplampuan2 = 0F
        var kontrol = toplampuan1
        var skor3 = 0F

        binding.basla402.setOnClickListener {
            mediaPlayer1.start()
            val sayici = object : CountDownTimer(60000,1000){

                override fun onTick(y: Long) {
                    textViewsure202.text = "Kalan süre: ${y / 1000} sn"
                    kalansure = (y/1000).toInt()
                }

                override fun onFinish() {
                    textViewsure202.text = "Oyun BİTTİ"
                    if(mediaPlayer1.isPlaying || mediaPlayer2.isPlaying){
                        mediaPlayer2.pause()
                        mediaPlayer1.pause()
                    }
                    mediaPlayer3.start()
                }
            }
            sayici.start()
        }
        binding.imageButton302.setOnClickListener(){

            if(mediaPlayer1.isPlaying){
                mediaPlayer1.pause()
            }
            else if(!mediaPlayer1.isPlaying){
                mediaPlayer1.start()
            }
        }
        images.shuffle()

        for (i: Int in 0..35) {

            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            //evkatsayisi bulma
            buttons[i].setOnClickListener {
                if (buttons[i].text == "cardBack" && !turnOver) {

                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if(buttons[i].text.contains("gry8") ||  buttons[i].text.contains("harry")){
                        katsayi = 2F
                        puan402.text = katsayi.toString()
                        if(buttons[i].text.contains("gonagall")){
                            oyuncupuan = 13F
                        }else{
                            oyuncupuan = 10F
                        }
                    }else if(buttons[i].text.contains("rcv8")){
                        katsayi=1F
                        if(buttons[i].text.contains("myrtle")){
                            oyuncupuan = 5F
                        }else{
                            oyuncupuan = 10F
                        }
                        //puan.text=katsayi.toString()
                    }else if(buttons[i].text.contains("sly8")){
                        katsayi = 2F
                        if(buttons[i].text.contains("severus")){
                            oyuncupuan = 18F
                        }else{
                            oyuncupuan = 10F
                        }
                        //puan.text=katsayi.toString()
                    }else if(buttons[i].text.contains("hfp8")){
                        katsayi = 1F
                        if(buttons[i].text.contains("hannah")){
                            oyuncupuan = 10F
                        }else{
                            oyuncupuan = 10F
                        }
                        //puan.text = katsayi.toString()
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
                        //skor += skor
                        //skor3 = skor*(kalansure/10F)
                        skor2 += skor*(kalansure/10F)
                        sayac++
                        if ((kontrol == toplampuan1)){
                            toplampuan1 += skor2
                            kontrol = toplampuan1
                        }else if(kontrol == toplampuan2){
                            toplampuan2 += skor2
                            kontrol = toplampuan2
                        }
                    }
                    else{
                        skor = (oyuncupuan/katsayi)
                        skor2 = skor*(kalansure/10F)

                        if(kontrol == toplampuan1){
                            toplampuan1 -= skor2
                            kontrol = toplampuan2
                        }else if(kontrol == toplampuan2){
                            toplampuan2 -= skor2
                            kontrol = toplampuan1
                        }
                    }

                }else if(clicked == 0){

                    turnOver = false
                }


                if(sayac >= 35){

                    if(mediaPlayer1.isPlaying || mediaPlayer2.isPlaying || mediaPlayer3.isPlaying){
                        mediaPlayer1.pause()
                        mediaPlayer2.pause()
                        mediaPlayer3.pause()
                    }
                    mediaPlayer4.start()
                    textViewsure202.text = "Oyun BİTTİ"
                }

                puan402.text = toplampuan1.toString()
                puan404.text = toplampuan2.toString()
            }
        }
    }
}