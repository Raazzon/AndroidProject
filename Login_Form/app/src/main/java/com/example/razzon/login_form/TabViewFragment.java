package com.example.razzon.login_form;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TabViewFragment extends AppCompatActivity {

    TextView tab1, tab2, tab3;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view_fragment);

        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        tab3 = (TextView) findViewById(R.id.tab3);

        tab1.setOnClickListener(tabOnClickListener);
        tab2.setOnClickListener(tabOnClickListener);
        tab3.setOnClickListener(tabOnClickListener);

        tab1.setBackgroundColor(Color.parseColor("#fff012"));

        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager()));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tab1.setBackgroundColor(Color.parseColor("#555555"));
                tab2.setBackgroundColor(Color.parseColor("#555555"));
                tab3.setBackgroundColor(Color.parseColor("#555555"));

                if (position==0){
                    tab1.setBackgroundColor(Color.parseColor("#fff012"));
                }else if (position==1){
                    tab2.setBackgroundColor(Color.parseColor("#fff012"));
                }else
                    tab3.setBackgroundColor(Color.parseColor("#fff012"));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public View.OnClickListener tabOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.tab1) {
                viewPager.setCurrentItem(0);
                //getSupportFragmentManager().beginTransaction().replace(R.id.container,new LoginFragment()).commit();
            } else if (v.getId() == R.id.tab2) {
                viewPager.setCurrentItem(1);

                // getSupportFragmentManager().beginTransaction().replace(R.id.container,new RegisterFragmemnt()).commit();

            } else {
                viewPager.setCurrentItem(2);

                //getSupportFragmentManager().beginTransaction().replace(R.id.container,new RemainderFragment()).commit();

            }
        }
    };

    public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

        public ViewPagerFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new LoginFragment();
            } else if (position == 1) {
                return new RegisterFragmemnt();
            } else

                return new RemainderFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
