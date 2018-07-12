package com.example.androidtest.LitePal;

import org.litepal.crud.LitePalSupport;

public class AB extends LitePalSupport {
    private String A;
    private String B;

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }
}
