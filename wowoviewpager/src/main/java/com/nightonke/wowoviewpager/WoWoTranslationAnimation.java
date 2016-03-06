package com.nightonke.wowoviewpager;

import android.util.Log;
import android.view.View;

import com.nightonke.wowoviewpager.Eases.EaseType;

/**
 * Created by Weiping on 2016/3/3.
 */

/**
 * animation to translate view's position
 */
public class WoWoTranslationAnimation extends PageAnimation {

    private EaseType easeType;
    private boolean useSameEaseTypeBack = true;

    private float targetX;
    private float targetY;
    private float fromX;
    private float fromY;

    public WoWoTranslationAnimation(
            int page, float startOffset, float endOffset,
            float fromX, float fromY,
            float targetX, float targetY,
            EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetX = targetX;
        this.targetY = targetY;
        this.fromX = fromX;
        this.fromY = fromY;
    }

    /**
     * every pageAnimation has extreme location of X and Y
     * we have to reset the extreme to prevent the offset while swiping quickly
     */
    private float extremeY = -1;
    private boolean extremeYIsSet = false;

    private float extremeX = -1;
    private boolean extremeXIsSet = false;

    private float lastPositionOffset = -1;

    private boolean firstTime = true;
    private boolean lastTimeIsExceed = false;
    private boolean lastTimeIsLess = false;

    @Override
    public void play(View onView, float positionOffset) {

        if (positionOffset <= getStartOffset()) {
            if (lastTimeIsLess) return;
            onView.setTranslationX(fromX);
            onView.setTranslationY(fromY);
            onView.requestLayout();
            lastTimeIsLess = true;
            return;
        }
        lastTimeIsLess = false;

        if (positionOffset >= getEndOffset()) {
            // if the positionOffset exceeds the endOffset,
            // we should set onView to targetPosition
            // otherwise there may be offsets between targetPosition and actuallyPosition
            if (lastTimeIsExceed) return;
            // if the last time we do this, just return
            onView.setTranslationX(targetX + fromX);
            onView.setTranslationY(targetY + fromY);
            onView.requestLayout();
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

        onView.setTranslationX(targetX * movementOffset + fromX);
        onView.setTranslationY(targetY * movementOffset + fromY);
        onView.requestLayout();

    }
}
