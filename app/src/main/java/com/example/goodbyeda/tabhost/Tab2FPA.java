package com.example.goodbyeda.tabhost;

/**
 * Created by hello on 7/3/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Tab2FPA extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    private ArrayList<String> mSubNum;

    public Tab2FPA(FragmentManager fm) {
        super(fm);

        mSubNum = new ArrayList<>();
        mSubNum.add("ONE");
        mSubNum.add("TWO");
        mSubNum.add("THREE");
    }

    @Override
    public Fragment getItem(int pos) {
        return Tab2SubFragment.newInst(pos);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int pos) {
        return "SUB TAB " + mSubNum.get(pos);
    }
}