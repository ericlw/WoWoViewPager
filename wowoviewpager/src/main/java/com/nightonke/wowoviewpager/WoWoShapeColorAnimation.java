package com.nightonke.wowoviewpager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;

import com.nightonke.wowoviewpager.Eases.EaseType;

/**
 * Created by Weiping on 2016/3/3.
 */

/**
 * animation to change the color of drawable of view
 */
public class WoWoShapeColorAnimation extends PageAnimation {

    private EaseType easeType;
    private boolean useSameEaseTypeBack = true;

    private int targetColor;
    private int fromColor;

    public WoWoShapeColorAnimation(int page, int fromColor, int targetColor) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = true;
        this.fromColor = fromColor;
        this.targetColor = targetColor;
    }

    public WoWoShapeColorAnimation(int page, int fromColor, int targetColor, EaseType easeType) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = easeType;
        this.useSameEaseTypeBack = true;
        this.fromColor = fromColor;
        this.targetColor = targetColor;
    }

    public WoWoShapeColorAnimation(int page, int fromColor, int targetColor, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.fromColor = fromColor;
        this.targetColor = targetColor;
    }

    public WoWoShapeColorAnimation(int page, int fromColor, int targetColor, EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.fromColor = fromColor;
        this.targetColor = targetColor;
    }

    public WoWoShapeColorAnimation(int page, float startOffset, float endOffset, int fromColor, int targetColor) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = true;
        this.fromColor = fromColor;
        this.targetColor = targetColor;
    }

    public WoWoShapeColorAnimation(int page, float startOffset, float endOffset, int fromColor, int targetColor, EaseType easeType) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = true;
        this.fromColor = fromColor;
        this.targetColor = targetColor;
    }

    public WoWoShapeColorAnimation(int page, float startOffset, float endOffset, int fromColor, int targetColor, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.fromColor = fromColor;
        this.targetColor = targetColor;
    }

    public WoWoShapeColorAnimation(int page, float startOffset, float endOffset, int fromColor, int targetColor, EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.fromColor = fromColor;
        this.targetColor = targetColor;
    }

    private float lastPositionOffset = -1;

    private boolean firstTime = true;
    private boolean lastTimeIsExceed = false;

    @Override
    public void play(View onView, float positionOffset) {

        if (positionOffset < getStartOffset()) {
            return;
        }

        if (positionOffset >= getEndOffset()) {
            // if the positionOffset exceeds the endOffset,
            // we should set onView to target color
            // otherwise there may be offsets between target color and actually color
            if (lastTimeIsExceed) return;
            // if the last time we do this, just return
            ((GradientDrawable)onView.getBackground()).setColor(targetColor);
            lastTimeIsExceed = true;
            return;
        }
        lastTimeIsExceed = false;

        // get the true offset
        positionOffset = (positionOffset - getStartOffset()) / (getEndOffset() - getStartOffset());
        float movementOffset;

        if (lastPositionOffset == -1) {
            // first movement
            movementOffset = easeType.getOffset(positionOffset);
        } else {
            if (positionOffset < lastPositionOffset) {
                // back
                if (useSameEaseTypeBack) {
                    movementOffset = 1 - easeType.getOffset(1 - positionOffset);
                } else {
                    movementOffset = easeType.getOffset(positionOffset);
                }
            } else {
                // forward
                movementOffset = easeType.getOffset(positionOffset);
            }
        }
        lastPositionOffset = positionOffset;

        int nowColor = Color.argb(
                Color.alpha(fromColor) + (int)((Color.alpha(targetColor) - Color.alpha(fromColor)) * movementOffset),
                Color.red(fromColor) + (int)((Color.red(targetColor) - Color.red(fromColor)) * movementOffset),
                Color.green(fromColor) + (int)((Color.green(targetColor) - Color.green(fromColor)) * movementOffset),
                Color.blue(fromColor) + (int)((Color.blue(targetColor) - Color.blue(fromColor)) * movementOffset));
        ((GradientDrawable)onView.getBackground()).setColor(nowColor);

    }
}
