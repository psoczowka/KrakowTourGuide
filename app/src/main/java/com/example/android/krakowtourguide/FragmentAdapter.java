package com.example.android.krakowtourguide;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static android.R.attr.dial;

/**
 * Created by kiwi on 2017-07-08.
 */

public class FragmentAdapter extends FragmentPagerAdapter  {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    final int PAGE_COUNT = 4;

    @Override
    public Fragment getItem(int position){

        switch (position) {
            case 0:
                return new MonumentsFragment();
            case 1:
                return new RestaurantsFragment();
            case 2:
                return new HotelsFragment();
            case 3:
                return new EventsFragment();
            default:
                return new MonumentsFragment();
        }

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}