package com.example.danangdulich;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    TextView placename, timeOpen, tripPrice, Desc, Rate, arename;
    ImageView img, pic1, pic2, pic3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img = (ImageView)findViewById(R.id.imgBg);
        pic1 = (ImageView)findViewById(R.id.anh1);
        pic2 = (ImageView)findViewById(R.id.anh2);
        pic3 = (ImageView)findViewById(R.id.anh3);

        placename = (TextView)findViewById(R.id.place_name);
        timeOpen = (TextView)findViewById(R.id.time);
        tripPrice = (TextView)findViewById(R.id.price);
        Desc = (TextView)findViewById(R.id.desc);
        Rate = (TextView)findViewById(R.id.rate);
        arename = (TextView)findViewById(R.id.area_name);

        img.setImageResource(getIntent().getIntExtra("placeImage",0));
        pic1.setImageResource(getIntent().getIntExtra("pic1",0));
        pic2.setImageResource(getIntent().getIntExtra("pic2",0));
        pic3.setImageResource(getIntent().getIntExtra("pic3",0));

        placename.setText(getIntent().getStringExtra("place"));
        timeOpen.setText(getIntent().getStringExtra("openTime"));
        tripPrice.setText(getIntent().getStringExtra("price")+" Đ");
        Desc.setText(getIntent().getStringExtra("desc"));
        String rating = getIntent().getDoubleExtra("rating",0)+"";
        Rate.setText(rating);
        arename.setText(getIntent().getStringExtra("areaName"));
    }
    public void like(View v){
        final ImageView ig = (ImageView)findViewById(R.id.btnlike);
        Animation animation;
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
        ig.startAnimation(animation);
    }
}