package bwie.com.shizhan2.model;

import java.net.URI;

import bwie.com.shizhan2.bean.LoginBean;
import bwie.com.shizhan2.http.OkHttp;

public class LoginClassModel implements LoginInterModel {
    @Override
    public void loginModel(String utl, String phone, String pass, final NetLoginCallBack loginCallBack) {
        OkHttp.getInstance().doPost(utl,LoginBean.class,phone,pass, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                loginCallBack.loginSuccess(obj);
            }

            @Override
            public void LoadFail() {

            }
        });
    }
}
