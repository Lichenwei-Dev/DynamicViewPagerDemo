package com.lcw.dynamicviewpager.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.lcw.dynamicviewpager.transformer.GalleryTransformer;
import com.lcw.dynamicviewpager.R;
import com.lcw.dynamicviewpager.adapter.ViewPagerAdapter;

public class GralleyVPActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private ViewPager mViewPager;
    private int[] mImages={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e};
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mRelativeLayout= (RelativeLayout) findViewById(R.id.rl_main_content);
        mViewPager= (ViewPager) findViewById(R.id.vp_main_pager);
        mViewPagerAdapter=new ViewPagerAdapter(this,mImages);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageMargin(10);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setPageTransformer(true,new GalleryTransformer());

        //事件分发，处理页面滑动问题
        mRelativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });

    }



}
