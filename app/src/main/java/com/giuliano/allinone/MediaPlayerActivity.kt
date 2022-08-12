package com.giuliano.allinone

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.giuliano.allinone.databinding.ActivityMediaPlayerBinding


class MediaPlayerActivity : AppCompatActivity() {
    private val binding: ActivityMediaPlayerBinding by lazy {
        ActivityMediaPlayerBinding.inflate(layoutInflater)
    }

    var eleGosta: MediaPlayer? = null
    var cavalo: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        eleGosta = MediaPlayer.create(this, R.raw.ele_gosta)
        cavalo = MediaPlayer.create(this, R.raw.cavalo)

        val imageEleGosta = "https://observatoriodatv.uol.com.br/wp-content/uploads/2021/12/Rodrigo-Faro-no-Hora-do-Faro.jpg"
        val imageCavalo = "https://s1.static.brasilescola.uol.com.br/be/conteudo/images/cavalo.jpg"
        val imageView1 = binding.imageView
        val imageView2 = binding.imageView7

        Glide.with(this).load(imageEleGosta).into(imageView1)
        Glide.with(this).load(imageCavalo).into(imageView2)
    }

    fun soundEleGosta(view: View) {
        eleGosta!!.start()
    }

    fun cavalo(view: View) {
        cavalo!!.start()
    }
}