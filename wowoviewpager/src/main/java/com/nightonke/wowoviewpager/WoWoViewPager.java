package com.nightonke.wowoviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Weiping on 2016/3/3.
 */
public class WoWoViewPager extends ViewPager {

    /**
     * viewAnimations for many views
     */
    private ArrayList<ViewAnimation> viewAnimations;

    public WoWoViewPager(Context context) {
        super(context);
        viewAnimations = new ArrayList<>();
    }

    public WoWoViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewAnimations = new ArrayList<>();
    }

    /**
     * add a viewAnimation to WoWo
     * @param viewAnimation the new viewAnimation
     */
    public void addAnimation(ViewAnimation viewAnimation) {
        viewAnimations.add(viewAnimation);
    }

    /**
     * get the starting page and the positionOffset to play all pageAnimations in each viewAnimation
     * @param position start page
     * @param positionOffset positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        super.onPageScrolled(position, positionOffset, positionOffsetPixels);

        for (int i = 0; i < viewAnimations.size(); i++) {
            viewAnimations.get(i).play(position, positionOffset);
        }

    }

    private int lastPosition = -1;
}
