package com.nightonke.wowoviewpagerexample;

import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.nightonke.wowoviewpager.Eases.EaseType;
import com.nightonke.wowoviewpager.ViewAnimation;
import com.nightonke.wowoviewpager.WoWoPathAnimation;
import com.nightonke.wowoviewpager.WoWoPathView;
import com.nightonke.wowoviewpager.WoWoRotationAnimation;
import com.nightonke.wowoviewpager.WoWoUtil;
import com.nightonke.wowoviewpager.WoWoViewPager;
import com.nightonke.wowoviewpager.WoWoViewPagerAdapter;

public class WoWoPathAnimationActivity extends AppCompatActivity {

    private WoWoViewPager wowo;
    private WoWoViewPagerAdapter adapter;

    private EaseType easeType = EaseType.EaseInCubic;
    private boolean useSameEaseTypeBack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_wowo_path_animation);

        init();

        wowo = (WoWoViewPager)findViewById(R.id.wowo_viewpager);
        adapter = new WoWoViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragmentsNumber(2);
        adapter.setColorRes(R.color.light_blue);
        wowo.setAdapter(adapter);
        setPageTV(wowo);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        WoWoPathView pathView = (WoWoPathView)findViewById(R.id.pathview);

        int screenW = WoWoUtil.getScreenWidth(this);
        int screenH = WoWoUtil.getScreenHeight(this);

        int xoff = 0;
        int yoff = screenH / 2 - 303 - 80;

        Path path = new Path();
        path.moveTo(screenW + 300 + xoff, 303 + yoff);
        path.cubicTo(
                557 + xoff, 385 + yoff, 412 + xoff, 409 + yoff, 348 + xoff, 398 + yoff);
        path.cubicTo(
                307 + xoff, 391 + yoff, 194 + xoff, 355 + yoff, 151 + xoff, 314 + yoff);
        path.cubicTo(
                132 + xoff, 296 + yoff, 111 + xoff, 260 + yoff, 108 + xoff, 210 + yoff);
        path.cubicTo(
                105 + xoff, 163 + yoff, 110 + xoff, 133 + yoff, 131 + xoff, 93 + yoff);
        path.cubicTo(
                146 + xoff, 64 + yoff, 162 + xoff, 50 + yoff, 201 + xoff, 27 + yoff);
        path.cubicTo(
                222 + xoff, 15 + yoff, 263 + xoff, 5 + yoff, 299 + xoff, 3 + yoff);
        path.cubicTo(
                346 + xoff, 1 + yoff, 411 + xoff, 1 + yoff, 449 + xoff, 14 + yoff);
        path.cubicTo(
                482 + xoff, 25 + yoff, 498 + xoff, 31 + yoff, 523 + xoff, 53 + yoff);
        path.cubicTo(
                550 + xoff, 77 + yoff, 574 + xoff, 102 + yoff, 581 + xoff, 133 + yoff);
        path.cubicTo(
                589 + xoff, 168 + yoff, 579 + xoff, 225 + yoff, 566 + xoff, 245 + yoff);
        path.cubicTo(
                548 + xoff, 272 + yoff, 514 + xoff, 308 + yoff, 469 + xoff, 324 + yoff);
        path.cubicTo(
                430 + xoff, 338 + yoff, 139 + xoff, 413 + yoff, -100 + xoff, 393 + yoff);

        pathView.setPath(path);
        ViewAnimation animation = new ViewAnimation(pathView);
        animation.addPageAnimaition(new WoWoPathAnimation(
                0, 0f, 1f,
                easeType,
                useSameEaseTypeBack));
        wowo.addAnimation(animation);
    }

    private void setPageTV(WoWoViewPager wowo) {
        wowo.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((TextView)findViewById(R.id.page)).setText((position + 1) + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void init() {
        useSameEaseTypeBack = getIntent().getBooleanExtra("useSameEaseTypeBack", true);
        int easeTypeNumber = getIntent().getIntExtra("easeType", -1);
        switch (easeTypeNumber) {
            case 0: easeType = EaseType.EaseInSine; break;
            case 1: easeType = EaseType.EaseOutSine; break;
            case 2: easeType = EaseType.EaseInOutSine; break;
            case 3: easeType = EaseType.EaseInQuad; break;
            case 4: easeType = EaseType.EaseOutQuad; break;
            case 5: easeType = EaseType.EaseInOutQuad; break;
            case 6: easeType = EaseType.EaseInCubic; break;
            case 7: easeType = EaseType.EaseOutCubic; break;
            case 8: easeType = EaseType.EaseInOutCubic; break;
            case 9: easeType = EaseType.EaseInQuart; break;
            case 10: easeType = EaseType.EaseOutQuart; break;
            case 11: easeType = EaseType.EaseInOutQuart; break;
            case 12: easeType = EaseType.EaseInQuint; break;
            case 13: easeType = EaseType.EaseOutQuint; break;
            case 14: easeType = EaseType.EaseInOutQuint; break;
            case 15: easeType = EaseType.EaseInExpo; break;
            case 16: easeType = EaseType.EaseOutExpo; break;
            case 17: easeType = EaseType.EaseInOutExpo; break;
            case 18: easeType = EaseType.EaseInCirc; break;
            case 19: easeType = EaseType.EaseOutCirc; break;
            case 20: easeType = EaseType.EaseInOutCirc; break;
            case 21: easeType = EaseType.EaseInBack; break;
            case 22: easeType = EaseType.EaseOutBack; break;
            case 23: easeType = EaseType.EaseInOutBack; break;
            case 24: easeType = EaseType.EaseInElastic; break;
            case 25: easeType = EaseType.EaseOutElastic; break;
            case 26: easeType = EaseType.EaseInOutElastic; break;
            case 27: easeType = EaseType.EaseInBounce; break;
            case 28: easeType = EaseType.EaseOutBounce; break;
            case 29: easeType = EaseType.EaseInOutBounce; break;
            case 30: easeType = EaseType.Linear; break;
        }
    }
}
