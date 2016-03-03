package com.nightonke.wowoviewpager;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Weiping on 2016/3/3.
 */

/**
 * animation to translate view's position
 */
public class WoWoTranslationAnimation extends PageAnimation {

    private float targetX;
    private float targetY;
    private float fromX;
    private float fromY;

    public WoWoTranslationAnimation(int page, float targetX, float targetY) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.targetX = targetX;
        this.targetY = targetY;
    }

    public WoWoTranslationAnimation(int page, float startOffset, float endOffset, float targetX, float targetY) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.targetX = targetX;
        this.targetY = targetY;
        fromX = -1;
        fromY = -1;
    }

    @Override
    public void play(View onView, float positionOffset) {

//        if (positionOffset <= getStartOffset() || positionOffset >= getEndOffset()) return;

        if (positionOffset <= 0.0001) {

            fromX = onView.getTranslationX();
            fromY = onView.getTranslationY();

            return;
        }

        onView.setTranslationX((int)(targetX * positionOffset) + fromX);
        onView.setTranslationY((int)(targetY * positionOffset) + fromY);
        onView.requestLayout();

    }
}
