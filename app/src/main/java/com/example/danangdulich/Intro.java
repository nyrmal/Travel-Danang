package com.example.danangdulich;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.example.danangdulich.model.ScreenItem;
import com.example.danangdulich.adapter.IntroViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Intro extends AppCompatActivity {
    private ViewPager screenPaper;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicartor;
    Button btnNext;
    int postition =0;
    Button btnGetStarted;
    Animation btnAnima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


      requestWindowFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        if (restorePrefData()){
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            finish();
        }

        //getSupportActionBar().hide();

        btnNext=findViewById(R.id.btn_Next);
        btnGetStarted=findViewById(R.id.btn_get_started);
        tabIndicartor =findViewById(R.id.tabLayout);
        btnAnima= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_arimation);

        final List<ScreenItem> mList=new ArrayList<>();
        mList.add(new ScreenItem("Du lịch Đà Nẵng","Thiên đường thu hút hàng triệu khách du lịch mỗi năm ",R.drawable.img1));
        mList.add(new ScreenItem("Lựa chọn địa điểm du lịch","Giúp bạn chọn những địa điểm du an toàn, nỗi tiếng tại đà nẵng",R.drawable.img2));
        mList.add(new ScreenItem("Thông tin điểm đến du lịch","Theo giỏi thông tin chi tiết giá thành các địa điểm phù hợp với bạn",R.drawable.img3));



        screenPaper=findViewById(R.id.screen_viewpaper);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPaper.setAdapter(introViewPagerAdapter);

        tabIndicartor.setupWithViewPager(screenPaper);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postition = screenPaper.getCurrentItem();
                if (postition<mList.size()){
                    postition++;
                    screenPaper.setCurrentItem(postition);
                }
                if (postition == mList.size()-1){
                   loadLastScreen();
                }

            }
        });

//        tabIndicartor.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener<>() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                if(tab.getPosition()==mList.size()-1);
//                loadLastScreen();
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
        tabIndicartor.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(MainActivity);

                savePrefsData();
                finish();
            }
        });
    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isOpenBefore = pref.getBoolean("isOpenBefore",false);
        return isOpenBefore;
    }

    private void savePrefsData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }

    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicartor.setVisibility(View.INVISIBLE);
        btnGetStarted.setAnimation(btnAnima);

    }



}