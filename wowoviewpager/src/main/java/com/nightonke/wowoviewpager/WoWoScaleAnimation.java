package com.nightonke.wowoviewpager;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nightonke.wowoviewpager.Eases.EaseType;

/**
 * Created by Weiping on 2016/3/3.
 */

/**
 * animation to translate view's position
 */
public class WoWoScaleAnimation extends PageAnimation {

    private EaseType easeType;
    private boolean useSameEaseTypeBack = true;

    private float targetWidth;
    private float targetHeight;
    private float fromWidth;
    private float fromHeight;

    public WoWoScaleAnimation(int page, float targetWidth, float targetHeight) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = true;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        fromWidth = -1;
        fromHeight = -1;
    }

    public WoWoScaleAnimation(int page, float targetWidth, float targetHeight, EaseType easeType) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = easeType;
        this.useSameEaseTypeBack = true;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        fromWidth = -1;
        fromHeight = -1;
    }

    public WoWoScaleAnimation(int page, float targetWidth, float targetHeight, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        fromWidth = -1;
        fromHeight = -1;
    }

    public WoWoScaleAnimation(int page, float targetWidth, float targetHeight, EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(0);
        setEndOffset(1);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        fromWidth = -1;
        fromHeight = -1;
    }

    public WoWoScaleAnimation(int page, float startOffset, float endOffset, float targetWidth, float targetHeight) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = true;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        fromWidth = -1;
        fromHeight = -1;
    }

    public WoWoScaleAnimation(int page, float startOffset, float endOffset, float targetWidth, float targetHeight, EaseType easeType) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = true;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        fromWidth = -1;
        fromHeight = -1;
    }

    public WoWoScaleAnimation(int page, float startOffset, float endOffset, float targetWidth, float targetHeight, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = EaseType.Linear;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        fromWidth = -1;
        fromHeight = -1;
    }

    public WoWoScaleAnimation(int page, float startOffset, float endOffset, float targetWidth, float targetHeight, EaseType easeType, boolean useSameEaseTypeBack) {
        setPage(page);
        setStartOffset(startOffset);
        setEndOffset(endOffset);

        this.easeType = easeType;
        this.useSameEaseTypeBack = useSameEaseTypeBack;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        fromWidth = -1;
        fromHeight = -1;
    }

    /**
     * every pageAnimation has extreme scale of width and height
     * we have to reset the extreme to prevent the offset of size
     */
    private float extremeWidth = -1;
    private boolean extremeWidthIsSet = false;

    private float extremeHeight = -1;
    private boolean extremeHeightIsSet = false;

    private float lastPositionOffset = -1;

    private boolean firstTime = true;
    private boolean lastTimeIsExceed = false;
    private boolean lastTimeIsLess = false;

    @Override
    public void play(View onView, float positionOffset) {

        Log.d("WoWo", getPage() + " " + positionOffset);

        if (positionOffset < getStartOffset()) {
            return;
        }

        if (positionOffset >= getEndOffset()) {
            // if the positionOffset exceeds the endOffset,
            // we should set onView to targetSize
            // otherwise there may be offsets between targetSize and actuallySize
            if (lastTimeIsExceed) return;
            // if the last time we do this, just return
            ViewGroup.LayoutParams param = onView.getLayoutParams();
            param.width = (int)(fromWidth * targetWidth);
            param.height = (int)(fromHeight * targetHeight);
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

        if (firstTime) {
            firstTime = false;

            fromWidth = onView.getLayoutParams().width;
            fromHeight = onView.getLayoutParams().height;

            if (!extremeHeightIsSet) {
                extremeHeightIsSet = true;
                extremeHeight = fromHeight;
            } else {
                fromHeight = extremeHeight;
            }

            if (!extremeWidthIsSet) {
                extremeWidthIsSet = true;
                extremeWidth = fromWidth;
            } else {
                fromWidth = extremeWidth;
            }

            return;
        }

        ViewGroup.LayoutParams param = onView.getLayoutParams();
        param.width = (int)(fromWidth + (targetWidth - 1) * fromWidth * movementOffset);
        param.height = (int)(fromHeight + (targetHeight - 1) * fromHeight * movementOffset);
        onView.setLayoutParams(param);

    }
}
