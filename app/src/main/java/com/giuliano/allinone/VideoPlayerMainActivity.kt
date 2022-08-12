package com.giuliano.allinone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import com.giuliano.allinone.databinding.ActivityVideoPlayerMainBinding

class VideoPlayerMainActivity : AppCompatActivity() {
    private val binding: ActivityVideoPlayerMainBinding by lazy {
        ActivityVideoPlayerMainBinding.inflate(layoutInflater)
    }

    private var uri: Uri? = null
    private var isContinuously = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val mediaController = MediaController(this)
        val viewVideo = binding.videoView
        mediaController.setAnchorView(viewVideo)

        val uriPath = "https://ia800209.us.archive.org/24/items/WildlifeSampleVideo/Wildlife.mp4"
        uri = Uri.parse(uriPath)
        viewVideo.setOnCompletionListener {
            if(isContinuously) {
                viewVideo.start()
            }
        }

        binding.pauseButton.setOnClickListener {
            viewVideo.pause()
        }

        binding.playButton.setOnClickListener {
            viewVideo.start()
        }

        binding.menuUpload.setOnClickListener {
            isContinuously = false
            binding.progressBar.visibility = View.VISIBLE
            viewVideo.setMediaController(mediaController)
            viewVideo.setVideoURI(uri)
            viewVideo.requestFocus()
            viewVideo.start()
        }

        binding.revertButton.setOnClickListener {
            isContinuously = true
            binding.progressBar.visibility = View.VISIBLE
            viewVideo.setMediaController(mediaController)
            viewVideo.setVideoURI(uri)
            viewVideo.requestFocus()
            viewVideo.start()
        }

        viewVideo.setOnPreparedListener { binding.progressBar.visibility = View.GONE }
    }
}