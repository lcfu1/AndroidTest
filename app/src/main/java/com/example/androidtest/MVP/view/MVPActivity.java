package com.example.androidtest.MVP.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidtest.MVP.contract.IMVPContract;
import com.example.androidtest.MVP.presenter.MVPPresenter;
import com.example.androidtest.R;

public class MVPActivity extends AppCompatActivity implements IMVPContract.View {
    private Button mBtnMVP;
    private IMVPContract.Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        //构建presenter
        mPresenter=new MVPPresenter(this);
        //初始化View
        mBtnMVP=(Button)findViewById(R.id.mvp);
        mBtnMVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.BtnClick();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onDestroy() {
        if(mPresenter!=null){
            mPresenter.destroy();
            mPresenter=null;
        }
        super.onDestroy();
    }
    @Override
    public void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}

