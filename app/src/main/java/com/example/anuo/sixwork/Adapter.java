package com.example.anuo.sixwork;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class Adapter extends FragmentPagerAdapter {
    private List<String> title;
    private List<Fragment> fragmentList;

    public Adapter(FragmentManager fragmentManager, List<String> title, List<Fragment> fragmentList) {
        super(fragmentManager);
        this.title = title;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position % title.size());
    }
}
