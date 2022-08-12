package com.giuliano.allinone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.giuliano.allinone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun acessarRecuperaFotos(view: View) {
        val intent = Intent(this, RecuperaFotosActivity::class.java)
        startActivity(intent)
    }

    fun acessarWebView(view: View) {
        val intent = Intent(this, WebViewActivity::class.java)
        startActivity(intent)
    }

    fun acessarMediaPlayer(view: View) {
        val intent = Intent(this, MediaPlayerActivity::class.java)
        startActivity(intent)
    }

    fun acessarVideoPlayer(view: View) {
        val intent = Intent(this, VideoPlayerMainActivity::class.java)
        startActivity(intent)
    }
}