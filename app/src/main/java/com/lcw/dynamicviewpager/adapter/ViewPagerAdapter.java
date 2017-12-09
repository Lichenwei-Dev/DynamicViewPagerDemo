package com.lcw.dynamicviewpager.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lcw.dynamicviewpager.utils.DensityUtil;

/**
 * ViewPager适配器
 * Create by: chenwei.li
 * Date: 2017/12/8
 * time: 15:17
 * Email: lichenwei.me@foxmail.com
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImages;

    public ViewPagerAdapter(Context context, int[] images) {
        this.mContext = context;
        this.mImages = images;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(DensityUtil.dip2px(mContext,200),DensityUtil.dip2px(mContext,400)));
        imageView.setImageResource(mImages[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
