package com.giuliano.allinone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.giuliano.allinone.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private val binding: ActivityWebViewBinding by lazy {
        ActivityWebViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val webView = binding.webView
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if(view != null && url != null) {
                    view.loadUrl(url)
                }
                return true
            }
        }
        webView.settings.javaScriptEnabled
        webView.loadUrl("https://github.com/giulianoaccorsi")
    }
}