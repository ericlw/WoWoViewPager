package com.nightonke.wowoviewpager;

import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.nightonke.wowoviewpager.Eases.EaseType;

/**
 * Created by Weiping on 2016/3/3.
 */

/**
 * animation to change the text size of text view
 */
public class WoWoTextViewSizeAnimation extends PageAnimation {

    private EaseType easeType;
    private boolean useSameEaseTypeBack = true;

    private float targetSize;
    private float fromSize;

    public WoWoTextViewSizeAnimation(int page, float startOffset, float endOffset, float fromSize, float targetSize, EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetSize = targetSize;
        this.fromSize = fromSize;
    }

    private float lastPositionOffset = -1;
    private boolean lastTimeIsExceed = false;
    private boolean lastTimeIsLess = false;

    @Override
    public void play(View onView, float positionOffset) {

        if (positionOffset <= getStartOffset()) {
            if (lastTimeIsLess) return;
            if (onView instanceof TextView) {
                ((TextView) onView).setTextSize(TypedValue.COMPLEX_UNIT_SP, fromSize);
            }
            lastTimeIsLess = true;
            return;
        }
        lastTimeIsLess = false;

        if (positionOffset >= getEndOffset()) {
            // if the positionOffset exceeds the endOffset,
            // we should set onView to target alpha
            // otherwise there may be offsets between target alpha and actually alpha
            if (lastTimeIsExceed) return;
            // if the last time we do this, just return
            if (onView instanceof TextView) {
                ((TextView) onView).setTextSize(TypedValue.COMPLEX_UNIT_SP, targetSize);
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

        if (onView instanceof TextView) {
            ((TextView) onView).setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    fromSize + (targetSize - fromSize) * movementOffset);
        }
    }
}
