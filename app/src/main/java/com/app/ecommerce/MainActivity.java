package com.app.ecommerce;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.ecommerce.fragment.SearchFragment;
import com.app.ecommerce.fragment.HomeFragment;
import com.app.ecommerce.fragment.SettingsFragment;
import com.app.ecommerce.ui.views.CustomViewPager;
import com.app.ecommerce.ui.views.TabsBarView;

public class MainActivity extends AppCompatActivity implements TabsBarView.onSelectTabListener ,ViewPager.OnPageChangeListener{


    private HomeFragment        mHomeFragment;
    private SettingsFragment    mSettingsFragment;
    private SearchFragment mSearchFragment;
    private TabsBarView         mTabsBarView;
    private CustomViewPager     mMainPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializePager();
        initializeFragments();
        applyListeners();
        onSelectTeb(0);
    }


    private void initializeViews() {
//        mActionBarView    =   (ActionBarView) findViewById(R.id.action_bar_home);
        mMainPager        =   (CustomViewPager) findViewById(R.id.main_flipper);
        mTabsBarView      =   (TabsBarView) findViewById(R.id.tabs_bar_view);
    }

    private void initializePager() {
        mMainPager.setOffscreenPageLimit(3);
        mMainPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    private void initializeFragments(){
        mHomeFragment        =   new HomeFragment();
        mSettingsFragment    =   new SettingsFragment();
        mSearchFragment =   new SearchFragment();
    }


    private void applyListeners() {
        mTabsBarView.setmOnSelectTabListener(this);
        mMainPager.setOnPageChangeListener(this);
    }





    @Override
    public void onSelectTeb(int position) {
        mMainPager.setCurrentItem(position, true);
    }


    public class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return mHomeFragment;
                case 1: return mSettingsFragment;
                case 2: return mSearchFragment;
            }
            return null;
        }

        @Override
        public int getItemPosition(Object object)
        {
            return POSITION_UNCHANGED;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTabsBarView.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}

