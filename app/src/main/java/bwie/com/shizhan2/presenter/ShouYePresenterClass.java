package bwie.com.shizhan2.presenter;

import bwie.com.shizhan2.api.Api;
import bwie.com.shizhan2.fragment.ShouYeFragment;
import bwie.com.shizhan2.model.ShouYeClass;
import bwie.com.shizhan2.model.ShouYeInter;

public class ShouYePresenterClass implements ShouYePresenterInter
{


    private final ShouYeClass shouYeClass;
    ShouYeFragment shouYeFragment;
    public ShouYePresenterClass(ShouYeFragment shouYeFragment)
    {
        shouYeClass = new ShouYeClass();
        this.shouYeFragment =shouYeFragment;

    }
    @Override
    public void getShouYePresenterData() {
        shouYeClass.getShouYeDataModel(Api.SHOPLIST, new ShouYeInter.ShouYeCallBack() {
            @Override
            public void Success(Object data) {
                shouYeFragment.getData(data);
            }
            @Override
            public void Fail() {

            }
        });

    }
}
