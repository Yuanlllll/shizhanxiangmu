package bwie.com.shizhan2.model;

import bwie.com.shizhan2.api.Api;
import bwie.com.shizhan2.bean.RegBean;
import bwie.com.shizhan2.http.OkHttp;

public class RegClassModel implements RegInterModel {
    @Override
    public void regModel(String phone, String pass, final RegCallBack regCallBack) {
        OkHttp.getInstance().doPost(Api.REG, RegBean.class, phone, pass, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                regCallBack.regSuccess(obj);
            }

            @Override
            public void LoadFail() {

            }
        });
    }
}
