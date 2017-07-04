package com.example.goodbyeda.tabhost;

/**
 * Created by goodbyeda on 6/27/2017.
 */

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class Tab2 extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        ViewPager vp = (ViewPager) findViewById(R.id.tab2_viewPager);
        vp.setAdapter(new Tab2FPA(getSupportFragmentManager()));
    }

//    public class TabPagerAdapter extends FragmentPagerAdapter {
//        private final int PAGE_COUNT = 3;
//        private ArrayList<String> mSubNum;
//
//        public TabPagerAdapter(FragmentManager fm) {
//            super(fm);
//
//            mSubNum = new ArrayList<>();
//            mSubNum.add("ONE");
//            mSubNum.add("TWO");
//            mSubNum.add("THREE");
//        }
//
//        @Override
//        public int getCount() {
//            return PAGE_COUNT;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return SubTabFgmt.getTab(position);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int pos) {
//            return "SUB TAB " + mSubNum.get(pos);
//        }
//    }
//
//    public static class SubTabFgmt extends Fragment {
//
//        private static final String STF_KEY = "Favorite ";
//        private String mFavor[] = { "Food", "Animal", "Color" };
//        private int mPg;
//
//        public static SubTabFgmt getTab(int page) {
//            SubTabFgmt stFgmt = new SubTabFgmt();
//            Bundle args = new Bundle();
//            args.putInt(STF_KEY, page);
//            stFgmt.setArguments(args);
//            return stFgmt;
//        }
//
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            mPg = getArguments().getInt(STF_KEY);
//            //mPage = getArguments().getInt(ARG_PAGE);
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inf, ViewGroup vGrp, Bundle savedInstanceState) {
//            View vw = inf.inflate(R.layout.tab2_pager_tabs, vGrp, false);
//            TextView txtVw = vw.findViewById(R.id.sub_tab_textView);
//            txtVw.setText(STF_KEY + mFavor[mPg]);
//            return vw;
//        }
//    }
}
