package com.david.xrecyclerview;

import android.app.Application;

/**
 * Created by zhanghewei on 17/3/24.
 */

public class AppContext extends Application {

    private static AppContext instance;

    public static AppContext getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
