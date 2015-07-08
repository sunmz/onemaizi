package com.e8net.onemaizi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Window;

import com.e8net.onemaizi.Fragment.LeftFragment;
import com.e8net.onemaizi.Fragment.MainFragMent;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class MainActivity extends SlidingFragmentActivity {

    private Fragment contentFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 初始化SlideMenu
        initRightMenu();

        if(savedInstanceState == null){//== null的时辰新建Fragment1
            contentFragment = new MainFragMent();
        } else {//不是null，直接get出来
                //不是null，找出之前保存的当前Activity显示的Fragment
            contentFragment = getSupportFragmentManager().getFragment(savedInstanceState,"contentFragment");
        }
        //设置内容Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.id_main_frame,contentFragment).commit();

    }

    private void initRightMenu()
    {

        LeftFragment leftFragment = new LeftFragment();
        setBehindContentView(R.layout.left_menu_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.id_left_menu_frame, leftFragment).commit();

        SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindWidth(getScreenWidth());
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);

        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.setBehindScrollScale(0.3f);
        menu.setSecondaryShadowDrawable(R.drawable.shadow);
    }

    public int getScreenWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        return width*2/3;
    }



}
