package com.nightonke.wowoviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Weiping on 2016/3/3.
 */
public class WoWoViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<WoWoViewPagerFragment> fragments;
    private int fragmentsNumber;

    /**
     * fragments' color
     */
    private Integer colorRes = null;
    private Integer color = null;
    private ArrayList<Integer> colorsRes = null;
    private ArrayList<Integer> colors = null;

    public WoWoViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
    }

    public int getFragmentsNumber() {
        return fragmentsNumber;
    }

    public void setFragmentsNumber(int fragmentsNumber) {
        this.fragmentsNumber = fragmentsNumber;
    }

    @Override
    public Fragment getItem(int position) {
        WoWoViewPagerFragment fragment = null;

        if (position < fragments.size()) fragment = fragments.get(position);

        if (fragment == null) {
            fragment = new WoWoViewPagerFragment();
            fragment.setBackground(colorRes);
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return fragmentsNumber;
    }

    public static class WoWoViewPagerFragment extends Fragment {

        private Integer colorRes = null;
        private Integer color = null;

        public WoWoViewPagerFragment() {
            this.colorRes = android.R.color.transparent;
        }

        public void setBackground(int colorRes) {
            this.colorRes = colorRes;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout view = new LinearLayout(getActivity());
            view.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            view.setOrientation(LinearLayout.VERTICAL);
            view.setBackgroundColor(ContextCompat.getColor(getActivity(), colorRes));
            return view;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }
    }

    public int getColorRes() {
        return colorRes;
    }

    public void setColorRes(int colorRes) {
        this.colorRes = colorRes;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public ArrayList<Integer> getColorsRes() {
        return colorsRes;
    }

    public void setColorsRes(ArrayList<Integer> colorsRes) {
        this.colorsRes = colorsRes;
    }

    public ArrayList<Integer> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Integer> colors) {
        this.colors = colors;
    }
}
