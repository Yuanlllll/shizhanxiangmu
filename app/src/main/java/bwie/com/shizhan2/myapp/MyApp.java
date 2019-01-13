package bwie.com.shizhan2.myapp;

import android.app.Application;

import bwie.com.shizhan2.view.CrashHandler;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this);
    }
}
