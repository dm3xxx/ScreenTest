package com.example.goodbyeda.tabhost;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TabHost;
import android.widget.Toast;

//public class MainActivity extends Activity implements TabHost.OnTabChangeListener {
public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalActivityManager lam = new LocalActivityManager(this, false);
        lam.dispatchCreate(savedInstanceState);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost); // initiate TabHost
        tabHost.setup(lam);

        TabHost.TabSpec spec; // Reusable TabSpec for each tab
        Intent intent; // Reusable Intent for each tab

        spec = tabHost.newTabSpec("TAB_ONE"); // Create a new TabSpec using tab host
        spec.setIndicator("Tab 1"); // set the “HOME” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, Tab1.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs

        spec = tabHost.newTabSpec("TAB_TWO"); // Create a new TabSpec using tab host
        spec.setIndicator("Tab 2"); // set the “CONTACT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, Tab2.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("TAB_THREE"); // Create a new TabSpec using tab host
        spec.setIndicator("Tab 3"); // set the “ABOUT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, Tab3.class);
        spec.setContent(intent);
        tabHost.addTab(spec);
        //set tab which one you want to open first time 0 or 1 or 2
        tabHost.setCurrentTab(0);
        tabHost.setOnTabChangedListener(this);
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String tabId) {
//                // display the name of the tab whenever a tab is changed
//                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onTabChanged(String tabId) {
        //Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
    }

}