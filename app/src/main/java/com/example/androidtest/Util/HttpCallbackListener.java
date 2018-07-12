package com.example.androidtest.Util;

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
