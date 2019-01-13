package bwie.com.shizhan2.model;

public interface LoginInterModel
{
    public void loginModel(String utl,String phone,String pass,NetLoginCallBack loginCallBack);
    interface NetLoginCallBack{
        public void loginSuccess(Object data);
        public void loginFail();
    }
}
