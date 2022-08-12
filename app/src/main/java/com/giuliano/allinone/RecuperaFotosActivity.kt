package com.giuliano.allinone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.giuliano.allinone.databinding.ActivityMainBinding
import com.giuliano.allinone.databinding.ActivityRecuperaFotosBinding

class RecuperaFotosActivity : AppCompatActivity() {
    private val binding: ActivityRecuperaFotosBinding by lazy {
        ActivityRecuperaFotosBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val textView1 = binding.textView1
        val textView2 = binding.textView2
        val textView3 = binding.textView3
        val textView4 = binding.textView4
        val textView5 = binding.textView5
        val textView6 = binding.textView6

        val imageView1 = binding.imageView1
        val imageView2 = binding.imageView2
        val imageView3 = binding.imageView3
        val imageView4 = binding.imageView4
        val imageView5 = binding.imageView5
        val imageView6 = binding.imageView6

        val equipes = arrayOf("Border Collie", "Pastor Alemão", "Golden", "Labrador", "Vira Lata", "Pug")

        textView1.setText(equipes[0])
        textView2.setText(equipes[1])
        textView3.setText(equipes[2])
        textView4.setText(equipes[3])
        textView5.setText(equipes[4])
        textView6.setText(equipes[5])

        val image1 = "https://blog.goapp.pet/wp-content/uploads/2021/05/1-945x532.png"
        val image2 = "https://static.wixstatic.com/media/db516d_568bdcda392b4a2a88169e089c6d1f81~mv2.jpg/v1/fill/w_640,h_426,al_c,q_80,usm_1.20_1.00_0.01,enc_auto/db516d_568bdcda392b4a2a88169e089c6d1f81~mv2.jpg"
        val image3 = "https://static.wixstatic.com/media/db516d_a7f7619f878f4c29948251d50d7f8de9~mv2.jpg/v1/fill/w_569,h_512,al_c,lg_1,q_80,usm_1.20_1.00_0.01,enc_auto/db516d_a7f7619f878f4c29948251d50d7f8de9~mv2.jpg"
        val image4 = "https://static.nationalgeographicbrasil.com/files/styles/image_3200/public/01-chocolate-lab-nationalgeographic_1154144.jpg?w=1600&h=900"
        val image5 = "https://cdn6.campograndenews.com.br/uploads/noticias/2020/12/11/5fd3c5095c3c9.jpg"
        val image6 = "https://s2.glbimg.com/YNb74ks3a6VTaMtfslAxCIJbFtI=/0x0:640x360/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2022/i/V/nVfRYsT1CwyuQJGudlhw/pug-bbc-2.jpg"

        Glide.with(this).load(image1).into(imageView1)
        Glide.with(this).load(image2).into(imageView2)
        Glide.with(this).load(image3).into(imageView3)
        Glide.with(this).load(image4).into(imageView4)
        Glide.with(this).load(image5).into(imageView5)
        Glide.with(this).load(image6).into(imageView6)
    }
}