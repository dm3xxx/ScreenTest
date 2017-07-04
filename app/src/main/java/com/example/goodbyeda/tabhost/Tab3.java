package com.example.goodbyeda.tabhost;

/**
 * Created by goodbyeda on 6/27/2017.
 */

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//public class Tab3 extends AppCompatActivity {
//public class Tab3 extends Activity implements OnChildClickListener, OnGroupClickListener,
//    OnGroupCollapseListener, OnGroupExpandListener {
public class Tab3 extends FragmentActivity implements OnChildClickListener, OnGroupClickListener,
        OnGroupCollapseListener, OnGroupExpandListener {

    ExpandableListView mXpbListView;
    Tab3ExpListAdptr mXpbListAdptr;
    private List<String> mPerson;
    private HashMap<String, List<String>> mInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        mXpbListView = (ExpandableListView ) findViewById(R.id.tab3_xb_list_view);
        initData();
        mXpbListAdptr = new Tab3ExpListAdptr(this, mPerson, mInfo);
        mXpbListView.setAdapter(mXpbListAdptr);

        mXpbListView.setOnGroupClickListener(this);
        mXpbListView.setOnGroupExpandListener(this);
        mXpbListView.setOnGroupCollapseListener(this);
        mXpbListView.setOnChildClickListener(this);
    }

    private void initData() {
        mPerson = new ArrayList<>();
        mInfo = new HashMap<>();

        mPerson.add("tom");
        mPerson.add("maria");
        mPerson.add("michael");

        List<String> tom = new ArrayList<>();
        tom.add("Red");
        tom.add("1234");

        List<String> maria = new ArrayList<>();
        maria.add("Yellow");
        maria.add("5354");

        List<String> michael = new ArrayList<>();
        michael.add("Green");
        michael.add("3333");

        mInfo.put(mPerson.get(0), tom);
        mInfo.put(mPerson.get(1), maria);
        mInfo.put(mPerson.get(2), michael);
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        // Toast.makeText(getApplicationContext(),
        // "Group Clicked " + listDataHeader.get(groupPosition),
        // Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onGroupExpand(int groupPosition) {
//        Toast.makeText(//                getApplicationContext(),//                mPerson.get(groupPosition) + " Expanded",//                Toast.LENGTH_SHORT).show();

        int cnt = mXpbListAdptr.getGroupCount();
        for (int i = 0; i < cnt; ++i) {
            if (i != groupPosition) {
                mXpbListView.collapseGroup(i);
            }
        }
    }

    @Override
    public void onGroupCollapse(int groupPosition) {
//        Toast.makeText(//                getApplicationContext(),//                mPerson.get(groupPosition) + " Collapsed",//                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {
        // TODO Auto-generated method stub
//        Toast.makeText(//                getApplicationContext(),//                mPerson.get(groupPosition) + " : " + mInfo.get(mPerson.get(groupPosition)).get(childPosition),//                Toast.LENGTH_SHORT).show();
        return false;
    }
}
