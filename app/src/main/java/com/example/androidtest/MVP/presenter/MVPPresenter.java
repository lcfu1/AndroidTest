package com.example.androidtest.MVP.presenter;

import com.example.androidtest.MVP.contract.IMVPContract;
import com.example.androidtest.MVP.model.MVPModel;

public class MVPPresenter implements IMVPContract.Presenter {
    private IMVPContract.View mView;
    public MVPPresenter(IMVPContract.View view){
        mView=view;
    }
    @Override
    public void start() {

    }

    @Override
    public void BtnClick() {
        String t= MVPModel.getmInstance().showToast();
        mView.showToast(t);
    }

    @Override
    public void destroy() {
        mView=null;
    }
}

