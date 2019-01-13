package bwie.com.shizhan2.presenter;

import bwie.com.shizhan2.MainActivity;
import bwie.com.shizhan2.RegActivity;
import bwie.com.shizhan2.model.RegClassModel;
import bwie.com.shizhan2.model.RegInterModel;

public class RegPresenterClass implements RegPresenterInter {
    RegActivity regActivity;
    private final RegClassModel regClassModel;

    public RegPresenterClass(RegActivity regActivity) {
        regClassModel = new RegClassModel();
        this.regActivity =regActivity;
    }

    @Override
    public void reg(String phone, String pwd)
    {
        regClassModel.regModel(phone, pwd, new RegInterModel.RegCallBack() {
            @Override
            public void regSuccess(Object obj) {

            }

            @Override
            public void regFail() {

            }
        });

    }
}
