package com.example.android.krakowtourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Create an adapter that knows which fragment should be shown on each page
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());

        //Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        //set adapter onto view pager
        viewPager.setAdapter(adapter);

        //set icons for all tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_map_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_restaurant_white_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_hotel_white_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_event_note_white_24dp);

        //set text for all tabs
        tabLayout.getTabAt(0).setText(R.string.tab0_string);
        tabLayout.getTabAt(1).setText(R.string.tab1_string);
        tabLayout.getTabAt(2).setText(R.string.tab2_string);
        tabLayout.getTabAt(3).setText(R.string.tab3_string);

    }
}