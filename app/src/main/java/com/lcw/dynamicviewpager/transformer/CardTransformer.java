package com.lcw.dynamicviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 卡片效果Transformer
 * Create by: chenwei.li
 * Date: 2017/12/8
 * time: 14:55
 * Email: lichenwei.me@foxmail.com
 */

public class CardTransformer implements ViewPager.PageTransformer {

    private int mOffset = 60;

    @Override
    public void transformPage(View page, float position) {

        if (position <= 0) {
            page.setRotation(45 * position);
            page.setTranslationX((page.getWidth() / 2 * position));
        } else {
            //移动X轴坐标，使得卡片在同一坐标
            page.setTranslationX(-position * page.getWidth());
            //缩放卡片并调整位置
            float scale = (page.getWidth() - mOffset * position) / page.getWidth();
            page.setScaleX(scale);
            page.setScaleY(scale);
            //移动Y轴坐标
            page.setTranslationY(position * mOffset);
        }


    }
}
