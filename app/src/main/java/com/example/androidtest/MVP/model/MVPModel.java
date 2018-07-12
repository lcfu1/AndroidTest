package com.example.androidtest.MVP.model;

public class MVPModel {
    private static MVPModel mInstance=null;
    public static MVPModel getmInstance(){
        if(mInstance==null){
            synchronized (MVPModel.class){
                if(mInstance==null){
                    mInstance=new MVPModel();
                }
            }
        }
        return mInstance;
    }
    public String showToast(){
        return "Toast";
    }
}

