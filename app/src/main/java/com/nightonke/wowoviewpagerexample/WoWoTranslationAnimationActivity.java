package com.nightonke.wowoviewpagerexample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.nightonke.wowoviewpager.Eases.EaseType;
import com.nightonke.wowoviewpager.ViewAnimation;
import com.nightonke.wowoviewpager.WoWoTranslationAnimation;
import com.nightonke.wowoviewpager.WoWoUtil;
import com.nightonke.wowoviewpager.WoWoViewPager;
import com.nightonke.wowoviewpager.WoWoViewPagerAdapter;

public class WoWoTranslationAnimationActivity extends AppCompatActivity {

    private WoWoViewPager wowo;
    private WoWoViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_wowo_translation_animation);

        int screenW = WoWoUtil.getScreenWidth(this);
        int screenH = WoWoUtil.getScreenHeight(this);

        wowo = (WoWoViewPager)findViewById(R.id.wowo_viewpager);
        adapter = new WoWoViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragmentsNumber(3);
        adapter.setColorRes(R.color.white);
        wowo.setAdapter(adapter);
        setPageTV(wowo);

        ViewAnimation animation = new ViewAnimation(findViewById(R.id.android));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0, 1,
                -screenW / 2 + WoWoUtil.dp2px(40, this),
                -screenH / 2 + WoWoUtil.dp2px(40, this),
                EaseType.EaseInBounce,
                true));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                1, 0, 1,
                screenW - WoWoUtil.dp2px(80, this),
                screenH - WoWoUtil.dp2px(80, this),
                EaseType.EaseOutBounce,
                true));
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
}
