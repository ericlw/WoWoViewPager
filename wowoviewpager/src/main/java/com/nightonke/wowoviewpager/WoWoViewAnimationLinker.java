package com.nightonke.wowoviewpager;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by Weiping on 2016/3/3.
 */

/**
 * play several animations continuous
 */
public class WoWoViewAnimationLinker extends PageAnimation {

    private ArrayList<PageAnimation> viewAnimations = new ArrayList<>();

    public WoWoViewAnimationLinker(ArrayList<PageAnimation> pageAnimations) {
        this.viewAnimations = pageAnimations;
    }

    public void addViewAnimation(PageAnimation pageAnimation) {
        if (viewAnimations == null) viewAnimations = new ArrayList<>();
        viewAnimations.add(pageAnimation);
    }

    @Override
    public void play(View onView, float positionOffset) {



    }
}
