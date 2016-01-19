package com.coneptum.tabs;

/**
 * Created by coneptum on 9/12/15.
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PagerAdapter extends FragmentPagerAdapter {

    //variable
    int mNumOfTabs;

    //contructor
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    //returns fragment asked
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    //gets number of tabs
    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    //returns title tab
    public int getTitle(int position) {
        switch (position) {
            case 0:
                return R.id.dashboard;
            case 1:
                    return R.id.chats;
            case 2:
                return R.id.account;
            default:
                return -1;
        }
    }


}