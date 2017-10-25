package com.owangwang.viewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private View view1,view2,view3;
    private ViewPager viewPager;
    private List<View> viewList;
    private List<String> titleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater=getLayoutInflater();
        viewPager= (ViewPager) findViewById(R.id.view_pager);
        view1=inflater.inflate(R.layout.layout1,null);
        view2=inflater.inflate(R.layout.layout2,null);
        view3=inflater.inflate(R.layout.layout3,null);
        viewList=new ArrayList<View>();
        titleList=new ArrayList<String>();
        titleList.add("tab1");
        titleList.add("tab2");
        titleList.add("tab3");
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        PagerAdapter pagerAdapter=new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        };

        viewPager.setAdapter(pagerAdapter);
    }
}
