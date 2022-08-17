package com.giuliano.allinone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.giuliano.allinone.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {

    private val animations = arrayOf("Blink","Bounce", "Fade In", "Fade Out", "Move", "Rotate", "Slide Down", "Slide Up", "Zoom In", "Zoom Out")
    private val animationID = intArrayOf(
        R.anim.animation1,
        R.anim.animation2,
        R.anim.animation3,
        R.anim.animation4,
        R.anim.animation5,
        R.anim.animation6,
        R.anim.animation7,
        R.anim.animation8,
        R.anim.animation9,
        R.anim.animation10)

    private val binding: ActivityAnimationBinding by lazy {
        ActivityAnimationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val animationListView = binding.listViewAnimation
        val textView = binding.textViewAnimation

        animationListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, animations)
        animationListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val animation = AnimationUtils.loadAnimation(this, animationID[position])
            textView.startAnimation(animation)
        }
    }
}