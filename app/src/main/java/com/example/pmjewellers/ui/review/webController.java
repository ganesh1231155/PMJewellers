package com.example.pmjewellers.ui.review;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webController extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view,String url) {
        view.loadUrl(url);
        return true;
    }
}
