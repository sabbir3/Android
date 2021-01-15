package com.example.myhtmldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String myText="<h1>this is heading 1</h1>\n"+
                      "<h2>this is heading 1</h1>\n"+
                      "<h3>this is heading 1</h1>\n"+
                      "<p>this is paragrapg</p>\n"+
                      "<p><u>this is an underline</u></p>\n"+
                      "<p><b>this is an bold</b></p>\n"+
                      "<p><i>this is an italic</i></p>\n";

        webView=findViewById(R.id.webViewId);
        webView.loadDataWithBaseURL(null,myText,"text/html","utf-8",null);
    }
}