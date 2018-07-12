package com.example.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtest.Util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JSONActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        Button get=(Button)findViewById(R.id.get_btn);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }

    private void sendRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url=new URL("https://raw.githubusercontent.com/lcfu1/test/master/json_data.json");
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url(url).build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();

                    //parseJSONWithJSONObject(responseData);
                    parseJSONWithGSON(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithGSON(String responseData) {
        Gson gson=new Gson();
        //App app=gson.fromJson(responseData,App.class);
        List<App> appList=gson.fromJson(responseData,new TypeToken<List<App>>(){}.getType());
        for(App app:appList){
            LogUtil.d("JSONActivity----------id=", app.getId());
            LogUtil.d("JSONActivity----------name=", app.getName());
        }
    }

    private void parseJSONWithJSONObject(String responseData) {
        try{
            JSONArray jsonArray=new JSONArray(responseData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String id=jsonObject.getString("id");
                String name=jsonObject.getString("name");
                LogUtil.d("JSONActivity----------id=", id);
                LogUtil.d("JSONActivity----------name=", name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}