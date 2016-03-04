package com.nightonke.wowoviewpager;

import android.view.View;
import android.view.ViewGroup;

import com.nightonke.wowoviewpager.Eases.EaseType;

/**
 * Created by Weiping on 2016/3/3.
 */

/**
 * animation to change the a
 */
public class WoWoAlphaAnimation extends PageAnimation {

    private EaseType easeType;
    private boolean useSameEaseTypeBack = true;

    private float targetAlpha;
    private float fromAlpha;

    public WoWoAlphaAnimation(int page, float targetAlpha) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = true;
        this.targetAlpha = targetAlpha;
        fromAlpha = -1;
    }

    public WoWoAlphaAnimation(int page, float targetAlpha, EaseType easeType) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = easeType;
        this.useSameEaseTypeBack = true;
        this.targetAlpha = targetAlpha;
        fromAlpha = -1;
    }

    public WoWoAlphaAnimation(int page, float targetAlpha, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetAlpha = targetAlpha;
        fromAlpha = -1;
    }

    public WoWoAlphaAnimation(int page, float targetAlpha, EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetAlpha = targetAlpha;
        fromAlpha = -1;
    }

    public WoWoAlphaAnimation(int page, float startOffset, float endOffset, float targetAlpha) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = true;
        this.targetAlpha = targetAlpha;
        fromAlpha = -1;
    }

    public WoWoAlphaAnimation(int page, float startOffset, float endOffset, float targetAlpha, EaseType easeType) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = true;
        this.targetAlpha = targetAlpha;
        fromAlpha = -1;
    }

    public WoWoAlphaAnimation(int page, float startOffset, float endOffset, float targetAlpha, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetAlpha = targetAlpha;
        fromAlpha = -1;
    }

    public WoWoAlphaAnimation(int page, float startOffset, float endOffset, float targetAlpha, EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetAlpha = targetAlpha;
        fromAlpha = -1;
    }

    /**
     * every pageAnimation has extreme alpha
     * we have to reset the extreme to prevent the offset of alpha
     */
    private float extremeAlpha = -1;
    private boolean extremeAlphaIsSet = false;

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
            // we should set onView to target alpha
            // otherwise there may be offsets between target alpha and actually alpha
            if (lastTimeIsExceed) return;
            // if the last time we do this, just return
            onView.setAlpha(targetAlpha);
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

        if (firstTime) {
            firstTime = false;

            fromAlpha = onView.getAlpha();

            if (!extremeAlphaIsSet) {
                extremeAlphaIsSet = true;
                extremeAlpha = fromAlpha;
            } else {
                fromAlpha = extremeAlpha;
            }

            return;
        }

        onView.setAlpha(fromAlpha + (targetAlpha - fromAlpha) * movementOffset);

    }
}
