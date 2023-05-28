package com.yaseminegeli.picmatching
// zorluk seviyesi 4*4

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.yaseminegeli.picmatching.databinding.ActivityMain2Binding
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaPlayer1 = MediaPlayer.create(this,R.raw.prologue)
        val mediaPlayer2 = MediaPlayer.create(this,R.raw.happywheels)
        val mediaPlayer3 = MediaPlayer.create(this,R.raw.shockedeffect)
        val mediaPlayer4 = MediaPlayer.create(this,R.raw.congratulations)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val images : MutableList<Int> = mutableListOf(
            R.drawable.harrypotter,
            R.drawable.harrypotter,
            R.drawable.gry8gonagall2,
            R.drawable.gry8gonagall2,
            R.drawable.hfp8hannah,
            R.drawable.hfp8hannah,
            R.drawable.hfp8sprout,
            R.drawable.hfp8sprout,
            R.drawable.rcv8myrtle,
            R.drawable.rcv8myrtle,
            R.drawable.rcv8patil,
            R.drawable.rcv8patil,
            R.drawable.sly8evanrosier,
            R.drawable.sly8evanrosier,
            R.drawable.sly8severus,
            R.drawable.sly8severus,
        )
        val evkatsayi = ArrayList<Int>()

        val buttons = arrayOf(
            button13, button14, button15, button16, button17, button18, button19,
            button20, button21, button22, button23, button24,button25,button26,button27,button28
        )
        val cardBack: MutableList<Int> = mutableListOf(
            R.drawable.arkayuz
        )
        var clicked = 0
        var turnOver = false
        var lastClicked = -1
        var katsayi = 1F
        var oyuncupuan= 1.0F
        var skor = 0F
        var skor2 = 0F
        var kalansure = 0
        var sayac = 0

        binding.basla2.setOnClickListener {
            mediaPlayer1.start()
            val sayici = object : CountDownTimer(45000,1000){

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
        binding.imageButton.setOnClickListener(){

            if(mediaPlayer1.isPlaying){
                mediaPlayer1.pause()
            }
            else if(!mediaPlayer1.isPlaying){
                mediaPlayer1.start()
            }
        }
        images.shuffle()

        for (i: Int in 0..15) {

            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            //evkatsayisi bulma
            buttons[i].setOnClickListener {
                if (buttons[i].text == "cardBack" && !turnOver) {

                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if(buttons[i].text.contains("gry8") ||  buttons[i].text.contains("harry")){
                        katsayi = 2F
                        puan2.text = katsayi.toString()
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
                        katsayi=1F
                        if(buttons[i].text.contains("hannah")){
                            oyuncupuan = 10F
                        }else{
                            oyuncupuan = 10F
                        }
                        //puan.text=katsayi.toString()
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
                        skor=((katsayi*oyuncupuan)/2.0F)
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

                puan2.text = skor2.toString()
                if(sayac>=35){

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