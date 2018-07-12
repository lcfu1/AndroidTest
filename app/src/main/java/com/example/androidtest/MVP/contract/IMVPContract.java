package com.example.androidtest.MVP.contract;

public interface IMVPContract {
    interface View{
        void showToast(String s);
    }

    interface Presenter{
        //表示presenter被激活
        void start();
        //Button被点击调用的方法
        void BtnClick();
        //表示presenter结束
        void destroy();
    }
}
