package com.example.goodbyeda.tabhost;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by goodbyeda on 6/28/2017.
 */

public class Tab3ExpListAdptr extends BaseExpandableListAdapter {

    private final Context mContext;
    private List<String> mPeople;
    private HashMap<String, List<String>> mDetail;

    public Tab3ExpListAdptr(Context ctx, List<String> ppl, HashMap<String, List<String>> dtl) {
        mContext = ctx;
        mPeople = ppl;
        mDetail = dtl;
    }

    @Override
    public int getGroupCount() {
        return mPeople.size();
    }

    @Override
    public int getChildrenCount(int grpPos) {
        //return (mDetail.get(mPeople.get(grpPos)).size() >> 1);
        return 1;
    }

    @Override
    public Object getGroup(int grpPos) {
        return mPeople.get(grpPos);
    }

    @Override
    public Object getChild(int grpPos, int chPos) {
        return mDetail.get(mPeople.get(grpPos)).get(chPos);
    }

    @Override
    public long getGroupId(int grpPos) {
        return grpPos;
    }

    @Override
    public long getChildId(int grpPos, int chPos) {
        return chPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int grpPos, boolean isExpanded, View view, ViewGroup parent) {
        if (null == view) {
            LayoutInflater lif = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = lif.inflate(R.layout.tab3_list_people, null);
        }
        final String name = (String) getGroup(grpPos);
        TextView pplView = (TextView) view.findViewById(R.id.tab3_people);
        pplView.setText(name);

        return view;
    }

    @Override
    public View getChildView(int gp, int cp, boolean isLastChild, View view, ViewGroup parent) {

        if (null == view) {
            LayoutInflater inf = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.tab3_ppl_detail, null);
        }

        final String clrTxt = (String) getChild(gp, 0);
        final String codeTxt = (String) getChild(gp, 1);

        TextView clrView = (TextView) view.findViewById(R.id.tab3_color_view);
        TextView codeView = (TextView) view.findViewById(R.id.tab3_code_view);

        clrView.setText("Color: " + clrTxt);
        codeView.setText("Code: " + codeTxt);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
