package com.kao.instagram.main.camera.presentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

class ViewPagerAdapter extends FragmentStatePagerAdapter {

  private final ArrayList<Fragment> fragments = new ArrayList<>(2);

  public ViewPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int i) {
    return fragments.get(i);
  }

  @Override
  public int getCount() {
    return fragments.size();
  }

  void add(Fragment fragment) {
    this.fragments.add(fragment);
  }

}
