package com.example.anuo.sixwork;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> title;
    private List<Fragment> fragmentList;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = MainActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.colorDeepGreen));
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ImageView imageView = (ImageView) findViewById(R.id.img_navigation);
        tabLayout = (TabLayout) findViewById(R.id.tab_title);
        viewPager = (ViewPager) findViewById(R.id.view_content);
        initView();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void initView() {
        title = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            title.add("第" + i + "个");
        }
        fragmentList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 3 == 0) {
                AboutFragment aboutFragment = new AboutFragment();
                aboutFragment.SetView(R.drawable.img_1, "我是第" + (i % 3 + 1) + "个fragment");
                fragmentList.add(aboutFragment);
            } else if (i % 3 == 1) {
                AboutFragment aboutFragment = new AboutFragment();
                aboutFragment.SetView(R.drawable.img_2, "我是第" + (i % 3 + 1) + "个fragment");
                fragmentList.add(aboutFragment);
            } else if (i % 3 == 2) {
                AboutFragment aboutFragment = new AboutFragment();
                aboutFragment.SetView(R.drawable.img_3, "我是第" + (i % 3 + 1) + "个fragment");
                fragmentList.add(aboutFragment);
            }
        }


        Adapter adapter = new Adapter(getSupportFragmentManager(), title, fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}