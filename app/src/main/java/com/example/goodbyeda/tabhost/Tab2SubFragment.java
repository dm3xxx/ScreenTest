package com.example.goodbyeda.tabhost;

/**
 * Created by hello on 7/3/2017.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab2SubFragment extends Fragment {

    private static final String TAB2_ARG = "Tab 2 sub tab arg";
    private static final String T2SF_KEY = "Favorite ";
    private String mFavor[] = { "Food", "Animal", "Color" };

    public static Tab2SubFragment newInst(int pNum) {
        Tab2SubFragment fragment = new Tab2SubFragment();
        Bundle args = new Bundle();
        args.putInt(TAB2_ARG, pNum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inf, ViewGroup vg, Bundle savedInstanceState) {

        int slot = getArguments().getInt(TAB2_ARG, -1);
        View v = inf.inflate(R.layout.tab2_pager_tabs, vg, false);
        TextView tv = (TextView) v.findViewById(R.id.tab2_subtab_text_view);
        tv.setText(T2SF_KEY + mFavor[slot]);

        return v;
    }
}