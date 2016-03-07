package com.nightonke.wowoviewpagerexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.nightonke.wowoviewpager.Color.ColorChangeType;
import com.nightonke.wowoviewpager.Eases.EaseType;
import com.nightonke.wowoviewpager.Eases.Linear;
import com.nightonke.wowoviewpager.ViewAnimation;
import com.nightonke.wowoviewpager.WoWoBackgroundColorAnimation;
import com.nightonke.wowoviewpager.WoWoRotationAnimation;
import com.nightonke.wowoviewpager.WoWoScaleAnimation;
import com.nightonke.wowoviewpager.WoWoTextViewSizeAnimation;
import com.nightonke.wowoviewpager.WoWoTranslationAnimation;
import com.nightonke.wowoviewpager.WoWoUtil;
import com.nightonke.wowoviewpager.WoWoViewPager;
import com.nightonke.wowoviewpager.WoWoViewPagerAdapter;

public class CVExampleActivity extends AppCompatActivity {

    private WoWoViewPager wowo;
    private WoWoViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_cvexample);

        wowo = (WoWoViewPager)findViewById(R.id.wowo_viewpager);
        adapter = new WoWoViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragmentsNumber(4);
        adapter.setColorRes(android.R.color.transparent);
        wowo.setAdapter(adapter);
    }

    private int screenW = 1;
    private int screenH = 1;
    private int circleR = 1;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        screenW = WoWoUtil.getScreenWidth(this);
        screenH = WoWoUtil.getScreenHeight(this);
        circleR = (int)Math.sqrt(screenW * screenW + screenH * screenH) + 10;

        RelativeLayout base = (RelativeLayout)findViewById(R.id.base);
        ViewGroup.LayoutParams layoutParams = base.getLayoutParams();
        layoutParams.height = circleR * 2;
        layoutParams.width = circleR * 2;
        base.setLayoutParams(layoutParams);

        RelativeLayout subBase = (RelativeLayout)findViewById(R.id.sub_base);
        layoutParams = subBase.getLayoutParams();
        layoutParams.height = screenH;
        layoutParams.width = screenW;
        subBase.setLayoutParams(layoutParams);

        setSubBase();
        setLogo();
        setName();
        setCV();
        setForAndroidDeveloper();
        setUniversityIcon();
        setUniversityText();
        setMailIcon();
        setMailText();

    }

    private void setSubBase() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.sub_base));
        animation.addPageAnimaition(new WoWoBackgroundColorAnimation(
                0, 0, 1,
                ContextCompat.getColor(this, R.color.light_blue),
                ContextCompat.getColor(this, R.color.my_pink),
                ColorChangeType.RGB,
                EaseType.Linear,
                true
        ));
        wowo.addAnimation(animation);
    }

    private void setLogo() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.cv_logo));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                findViewById(R.id.cv_logo).getTranslationX(),
                findViewById(R.id.cv_logo).getTranslationY(),
                -screenW / 2 + 150,
                -screenH / 2 + 200,
                EaseType.EaseOutBack,
                false
        ));
        animation.addPageAnimaition(new WoWoScaleAnimation(
                0, 0, 1,
                0.5f,
                0.5f,
                EaseType.EaseOutBack,
                false
        ));
        wowo.addAnimation(animation);
    }

    private void setName() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.name));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                findViewById(R.id.name).getTranslationX(),
                findViewById(R.id.name).getTranslationY(),
                - screenW / 2 + 150 + WoWoUtil.dp2px(105, this) + 20,
                - screenH / 2 + 200 - WoWoUtil.dp2px(70, this),
                EaseType.EaseOutBack,
                false
        ));
        animation.addPageAnimaition(new WoWoTextViewSizeAnimation(
                0, 0, 1,
                30f,
                22f,
                EaseType.Linear,
                false
        ));
        wowo.addAnimation(animation);
    }

    private void setCV() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.cv));
        animation.addPageAnimaition(new WoWoRotationAnimation(
                0, 0, 0,
                -20,
                findViewById(R.id.cv).getPivotY(),
                0,
                0,
                -15,
                EaseType.EaseInBack,
                false
        ));
        animation.addPageAnimaition(new WoWoRotationAnimation(
                0, 0, 1,
                -20,
                findViewById(R.id.cv).getPivotY(),
                0,
                0,
                -150,
                EaseType.EaseInBack,
                false
        ));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                findViewById(R.id.cv).getTranslationX(),
                findViewById(R.id.cv).getTranslationY(),
                -screenW / 3,
                findViewById(R.id.cv).getTranslationY(),
                EaseType.EaseInBack,
                false
        ));
        wowo.addAnimation(animation);
    }

    private void setForAndroidDeveloper() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.for_android_developer));
        animation.addPageAnimaition(new WoWoRotationAnimation(
                0, 0, 0,
                screenW + 80,
                findViewById(R.id.for_android_developer).getPivotY(),
                0,
                0,
                10,
                EaseType.EaseInBack,
                false
        ));
        animation.addPageAnimaition(new WoWoRotationAnimation(
                0, 0, 1,
                screenW + 80,
                findViewById(R.id.for_android_developer).getPivotY(),
                0,
                0,
                150,
                EaseType.EaseInBack,
                false
        ));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                findViewById(R.id.for_android_developer).getTranslationX(),
                findViewById(R.id.for_android_developer).getTranslationY(),
                -screenW / 3,
                findViewById(R.id.for_android_developer).getTranslationY(),
                EaseType.EaseInBack,
                false
        ));
        wowo.addAnimation(animation);
    }

    private void setUniversityIcon() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.university_icon));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                findViewById(R.id.university_icon).getTranslationX(),
                findViewById(R.id.university_icon).getTranslationY(),
                - screenW,
                0,
                EaseType.EaseInCubic,
                false
        ));
        wowo.addAnimation(animation);
    }

    private void setUniversityText() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.university_text));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                findViewById(R.id.university_text).getTranslationX(),
                findViewById(R.id.university_text).getTranslationY(),
                screenW,
                0,
                EaseType.EaseInCubic,
                false
        ));
        wowo.addAnimation(animation);
    }

    private void setMailIcon() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.mail_icon));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                findViewById(R.id.mail_icon).getTranslationX(),
                findViewById(R.id.mail_icon).getTranslationY(),
                - screenW,
                0,
                EaseType.EaseInCubic,
                false
        ));
        wowo.addAnimation(animation);
    }

    private void setMailText() {
        ViewAnimation animation = new ViewAnimation(findViewById(R.id.mail_text));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                findViewById(R.id.mail_text).getTranslationX(),
                findViewById(R.id.mail_text).getTranslationY(),
                screenW,
                0,
                EaseType.EaseInCubic,
                false
        ));
        wowo.addAnimation(animation);
    }


}
