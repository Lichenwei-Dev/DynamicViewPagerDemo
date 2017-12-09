package com.lcw.dynamicviewpager.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.lcw.dynamicviewpager.transformer.CardTransformer;
import com.lcw.dynamicviewpager.transformer.GalleryTransformer;
import com.lcw.dynamicviewpager.R;
import com.lcw.dynamicviewpager.adapter.ViewPagerAdapter;

public class CardVPActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private ViewPager mViewPager;
    private int[] mImages={R.mipmap.b,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.h};
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        mRelativeLayout= (RelativeLayout) findViewById(R.id.rl_main_content);
        mViewPager= (ViewPager) findViewById(R.id.vp_main_pager);
        mViewPagerAdapter=new ViewPagerAdapter(this,mImages);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setPageTransformer(true,new CardTransformer());
    }



}
