package com.infinitefarmer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BidActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Your Crops"));
        tabLayout.addTab(tabLayout.newTab().setText("Buyers"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        FragmentAdapterClass fragmentAdapter = new FragmentAdapterClass(getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(fragmentAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab LayoutTab) {

                viewPager.setCurrentItem(LayoutTab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab LayoutTab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab LayoutTab) {

            }
        });
    }



    class FragmentAdapterClass extends FragmentStatePagerAdapter {

        int tabCount;
        FragmentAdapterClass(FragmentManager fm, int countTabs) {
            super(fm);
            this.tabCount = countTabs;

        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new SelllersFrag();
                case 1:
                    return new BuyerFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabCount;
        }
    }
}
