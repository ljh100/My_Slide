package com.example.my_slide;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    //이 어댑터는 프래그 먼트를 갖고 있으므로
    //이미 우리가 만들었던 ColorFrag,ItemFrag,PlusOneFrag 프래그먼트를
    //main AC 의 pager 에 넣주려면
    private ArrayList<Fragment> mData;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        mData = new ArrayList<>();
        mData.add(new ColorFragment());
        mData.add(new ItemFragment());
        mData.add(new PlusOneFragment());

    }

    @Override
    public Fragment getItem(int positon) {
        return mData.get(positon);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       // return super.getPageTitle(position);
        //간단히 주기위해
        return position + "번째";
    }
}
