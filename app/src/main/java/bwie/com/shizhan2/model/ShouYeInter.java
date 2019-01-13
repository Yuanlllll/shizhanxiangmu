package bwie.com.shizhan2.model;

public interface ShouYeInter
{
    public void getShouYeDataModel(String url,ShouYeCallBack shouYeCallBack);
    interface ShouYeCallBack
    {
        public void Success(Object data);
        public void Fail();
    }
}
