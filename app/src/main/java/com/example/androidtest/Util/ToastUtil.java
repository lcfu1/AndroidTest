package com.example.androidtest.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast sToast;
    @SuppressLint("ShowToast")
    public static void showToast(Context context, String content){
        if(sToast==null){
            sToast=Toast.makeText(context,content,Toast.LENGTH_SHORT);
        }else {
            sToast.setText(content);
        }
        sToast.show();
    }
}
