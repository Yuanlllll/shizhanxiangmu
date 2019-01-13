package bwie.com.shizhan2.presenter;

import bwie.com.shizhan2.MainActivity;
import bwie.com.shizhan2.api.Api;
import bwie.com.shizhan2.model.LoginClassModel;
import bwie.com.shizhan2.model.LoginInterModel;

public class LoginPresenterClass implements LoginPresenterInter {

    private final LoginClassModel loginClassModel;
    MainActivity mainActivity;
    public LoginPresenterClass(MainActivity mainActivity)
    {
        loginClassModel = new LoginClassModel();
        this.mainActivity =mainActivity;
    }


    @Override
    public void loginPresenter(String phone, String pwd) {
        loginClassModel.loginModel(Api.LOGIN, phone, pwd, new LoginInterModel.NetLoginCallBack() {
            @Override
            public void loginSuccess(Object data) {

            }

            @Override
            public void loginFail() {

            }
        });
    }
}
