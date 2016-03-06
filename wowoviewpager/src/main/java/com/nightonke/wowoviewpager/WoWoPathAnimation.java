package com.nightonke.wowoviewpager;

import android.view.View;

import com.nightonke.wowoviewpager.Eases.EaseType;

/**
 * Created by Weiping on 2016/3/3.
 */

/**
 * animation to change the alpha of view
 */
public class WoWoPathAnimation extends PageAnimation {

    private EaseType easeType;
    private boolean useSameEaseTypeBack = true;

    public WoWoPathAnimation(int page, float startOffset, float endOffset, EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
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
            if (onView instanceof WoWoPathView) {
                ((WoWoPathView)onView).setPercentage(1);
            }
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

        if (onView instanceof WoWoPathView) {
            ((WoWoPathView)onView).setPercentage(movementOffset);
        }
    }
}
