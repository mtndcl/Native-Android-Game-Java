package com.mockingbird.magiccolors;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Contant.SCREEN_WIDHT=dm.widthPixels;
        Contant.SCREEN_HEIGHT=dm.heightPixels;
        super.onCreate(savedInstanceState);

        setContentView(new GamePanel(this));
    }
}