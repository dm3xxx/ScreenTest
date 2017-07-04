package com.example.goodbyeda.tabhost;

/**
 * Created by goodbyeda on 6/27/2017.
 */

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

//public class Tab1 extends AppCompatActivity {
//public class Tab1 extends Activity {
public class Tab1 extends FragmentActivity {

    public enum FragOrder { Input, Picker, List, Detail }

    private final int TotalFragments = 4;
    private final Fragment[] mFrags = new Fragment[TotalFragments];
    private int mCurFgmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1);

        FragmentManager fm = getSupportFragmentManager();
        mFrags[FragOrder.Detail.ordinal()] = fm.findFragmentById(R.id.tab1_detail_frag);
        fm.beginTransaction().hide(mFrags[FragOrder.Detail.ordinal()]).commit();
        mFrags[FragOrder.List.ordinal()] = fm.findFragmentById(R.id.tab1_list_frag);
        fm.beginTransaction().hide(mFrags[FragOrder.List.ordinal()]).commit();
        mFrags[FragOrder.Picker.ordinal()] = fm.findFragmentById(R.id.tab1_picker_frag);
        fm.beginTransaction().hide(mFrags[FragOrder.Picker.ordinal()]).commit();
        mFrags[FragOrder.Input.ordinal()] = fm.findFragmentById(R.id.tab1_input_frag);
        fm.beginTransaction().show(mFrags[FragOrder.Input.ordinal()]).commit();

        mCurFgmt = FragOrder.Input.ordinal();
    }

    public void showFgmt (int fmId) {
        if (mFrags[fmId].isVisible()) return;

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.hide(mFrags[mCurFgmt]);
        trans.show(mFrags[fmId]);
//        trans.addToBackStack(null);
        trans.commit();

        mCurFgmt = fmId;
    }

    @Override
    public void onBackPressed() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (FragOrder.Detail.ordinal() == mCurFgmt) {
            ft.hide(mFrags[mCurFgmt]);
            ft.show(mFrags[FragOrder.List.ordinal()]);
            ft.commit();
            mCurFgmt = FragOrder.List.ordinal();
        } else if (FragOrder.List.ordinal() == mCurFgmt) {
            ft.hide(mFrags[mCurFgmt]);
            ft.show(mFrags[FragOrder.Input.ordinal()]);
            ft.commit();
            mCurFgmt = FragOrder.Input.ordinal();
        } else if (FragOrder.Picker.ordinal() == mCurFgmt) {
            ft.hide(mFrags[mCurFgmt]);
            ft.commit();
            mCurFgmt = FragOrder.Input.ordinal();
        } else {
            super.onBackPressed();
        }

//        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
//            getSupportFragmentManager().popBackStack();
//            if (FragOrder.List.ordinal() == mCurFgmt) mCurFgmt = FragOrder.Input.ordinal();
//            else --mCurFgmt;
////        if (FragOrder.Input.ordinal() != mCurFgmt) {
//        } else {
//            super.onBackPressed();
//        }
    }
}
