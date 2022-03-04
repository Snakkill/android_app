package com.example.firstapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import androidx.annotation.RequiresApi
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat

class Webview : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val myWebView = WebView(this)
        setContentView(myWebView)
       // myWebView.loadUrl("https://www.google.com") loaded url

        // Create an unencoded HTML string
// then convert the unencoded HTML string into bytes, encode
// it with Base64, and load the data.
   /*     val unencodedHtml =
            "<html><body>'%23' is the percent code for ‘#‘ </body></html>";
        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
        myWebView.loadData(encodedHtml, "text/html", "base64")*/


//load local web page
        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(this))
            .addPathHandler("/res/", WebViewAssetLoader.ResourcesPathHandler(this))
            .build()
        myWebView.webViewClient = LocalContentWebViewClient(assetLoader)

        myWebView.loadUrl("https://appassets.androidplatform.net/assets/index.html")
    }
    private class LocalContentWebViewClient(private val assetLoader: WebViewAssetLoader) : WebViewClientCompat() {
        @RequiresApi(21)
        override fun shouldInterceptRequest(
            view: WebView,
            request: WebResourceRequest
        ): WebResourceResponse? {
            return assetLoader.shouldInterceptRequest(request.url)
        }

        // to support API < 21
        override fun shouldInterceptRequest(
            view: WebView,
            url: String
        ): WebResourceResponse? {
            return assetLoader.shouldInterceptRequest(Uri.parse(url))
        }
    }
}