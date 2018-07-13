package com.example.androidtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtest.LitePal.LitePalActivity;
import com.example.androidtest.MVP.view.MVPActivity;
import com.example.androidtest.Theme.SetThemeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mWebViewBtn;
    Button mHttpURLConnectionBtn;
    Button mOkHttpBtn;
    Button mXMLBtn;
    Button mJSONBtn;
    Button mLitePalBtn;
    Button mMVPBtn;
    Button mThemeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebViewBtn=(Button)findViewById(R.id.web_view_btn);
        mWebViewBtn.setOnClickListener(this);

        mHttpURLConnectionBtn=(Button)findViewById(R.id.http_url_connection_btn);
        mHttpURLConnectionBtn.setOnClickListener(this);

        mOkHttpBtn=(Button)findViewById(R.id.ok_http_btn);
        mOkHttpBtn.setOnClickListener(this);

        mXMLBtn=(Button)findViewById(R.id.xml_btn);
        mXMLBtn.setOnClickListener(this);

        mJSONBtn=(Button)findViewById(R.id.json_btn);
        mJSONBtn.setOnClickListener(this);

        mLitePalBtn=(Button)findViewById(R.id.litepal_btn);
        mLitePalBtn.setOnClickListener(this);

        mMVPBtn=(Button)findViewById(R.id.mvp_btn);
        mMVPBtn.setOnClickListener(this);

        mThemeBtn=(Button)findViewById(R.id.theme_btn);
        mThemeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent intent;
        if(id == R.id.web_view_btn){
            intent=new Intent(this,WebViewActivity.class);
            startActivity(intent);
        }else if(id == R.id.http_url_connection_btn){
            intent=new Intent(this,HttpURLConnectionActivity.class);
            startActivity(intent);
        }else if(id == R.id.ok_http_btn){
            intent=new Intent(this,OkHttpActivity.class);
            startActivity(intent);
        }else if(id == R.id.xml_btn){
            intent=new Intent(this,XMLActivity.class);
            startActivity(intent);
        }else if(id == R.id.json_btn){
            intent=new Intent(this,JSONActivity.class);
            startActivity(intent);
        }else if(id == R.id.litepal_btn){
            intent=new Intent(this,LitePalActivity.class);
            startActivity(intent);
        }else if(id == R.id.mvp_btn){
            intent=new Intent(this,MVPActivity.class);
            startActivity(intent);
        }else if(id == R.id.theme_btn){
            intent=new Intent(this, SetThemeActivity.class);
            startActivity(intent);
        }
    }
}
