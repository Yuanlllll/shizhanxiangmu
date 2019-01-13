package bwie.com.shizhan2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;

import bwie.com.shizhan2.fragment.FaXianFragment;
import bwie.com.shizhan2.fragment.FenLeiFragment;
import bwie.com.shizhan2.fragment.GouWuCheFragment;
import bwie.com.shizhan2.fragment.SheZhiFragment;
import bwie.com.shizhan2.fragment.ShouYeFragment;

public  class HomeActivity  extends AppCompatActivity
{
    private BottomTabBar bom;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bom = findViewById(R.id.bottom);

        bom.init(getSupportFragmentManager())
               . setImgSize(50,50)
                .setChangeColor(Color.BLUE,Color.BLACK)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .addTabItem("首页",R.drawable.ic_home_black_24dp,ShouYeFragment.class)
                .addTabItem("分类",R.drawable.ic_casino_black_24dp,FenLeiFragment.class)
                .addTabItem("购物车",R.drawable.ic_local_grocery_store_black_24dp,GouWuCheFragment.class)
                .addTabItem("发现",R.drawable.ic_visibility_black_24dp,FaXianFragment.class)
                .addTabItem("设置",R.drawable.ic_settings_black_24dp,SheZhiFragment.class);
    }
}
