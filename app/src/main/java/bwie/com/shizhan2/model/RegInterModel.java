package bwie.com.shizhan2.model;

public interface RegInterModel
{
    public  void regModel(String phone,String pass,RegCallBack regCallBack);
    interface RegCallBack{
        void regSuccess(Object obj);
        void regFail();
    }
}
