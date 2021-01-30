package com.test.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyViewPagerAdapter adapter;

    private boolean isActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "ON_CREATE");
        viewPager=findViewById(R.id.containerLay);
        tabLayout=findViewById(R.id.tabLayout);

        adapter=new MyViewPagerAdapter(getSupportFragmentManager(), Arrays.asList(new MondayFragment(), new TuesdayFragment(), new WednesdayFragment(), new ThursdayFragment(), new FridayFragment(), new SaturdayFragment(), new SundayFragment()));

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void addFragment(){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(tabLayout.getId(), new MondayFragment(),"Mon");
        fragmentTransaction.add(tabLayout.getId(), new TuesdayFragment(),"Tue");
        fragmentTransaction.add(tabLayout.getId(), new WednesdayFragment(),"Wed");
        fragmentTransaction.add(tabLayout.getId(), new ThursdayFragment(),"Thu");
        fragmentTransaction.add(tabLayout.getId(), new FridayFragment(),"Fri");
        fragmentTransaction.add(tabLayout.getId(), new SaturdayFragment(),"Sat");
        fragmentTransaction.add(tabLayout.getId(), new SundayFragment(),"Sun");


    }

    /*@Override
    protected void onStart(){
        super.onStart();

        Log.d("LifeCycle", "ON_START");
    }

    @Override
    protected void onResume(){
        super.onResume();
        isActive=true;
        Log.d("LifeCycle", "ON_RESUME");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.d("LifeCycle", "ON_PAUSE");
    }

    @Override
    protected void onStop(){
        super.onStop();
        isActive=false;
        Log.d("LifeCycle", "ON_STOP");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.d("LifeCycle", "ON_DESTROY");
    }*/
}