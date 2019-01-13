package bwie.com.shizhan2.model;

import bwie.com.shizhan2.api.Api;
import bwie.com.shizhan2.bean.ShouYeBean;
import bwie.com.shizhan2.http.OkHttp;

public class ShouYeClass implements ShouYeInter{
    @Override
    public void getShouYeDataModel(String url, final ShouYeCallBack shouYeCallBack) {
        OkHttp.getInstance().doGet(url, ShouYeBean.class, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                shouYeCallBack.Success(obj);
            }

            @Override
            public void LoadFail() {

            }
        });
    }
}
