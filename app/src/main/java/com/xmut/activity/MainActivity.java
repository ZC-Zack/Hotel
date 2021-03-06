package com.xmut.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.activity.R;
import com.xmut.adapter.HomeFragmentAdapter;
import com.xmut.fragment.ChatFragment;
import com.xmut.fragment.FriendFragment;
import com.xmut.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private String TAG="FLOP";

    private BottomNavigationView  bottomNavigationView;
    private HomeFragmentAdapter homeFragmentAdapter;
    private ViewPager viewPager;
    private MenuItem menuItem;
    List<Fragment> fragmentList;
    private Intent intent;

    private DrawerLayout drawerLayout;
    private ActionBar actionBar;
    private NavigationView navigationView;
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        initNavView();
        //initSlideMenu();
        Button loginButton = (Button)findViewById(R.id.login_button);
//        Log.i("log", "loginButton "+loginButton);
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(intent);
//            }
//        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.menu_chat:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.menu_friend:
                        viewPager.setCurrentItem(2);
                        return true;
                        default:
                            break;

                }
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void init(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        viewPager = findViewById(R.id.main_frame);
       /* noScrollViewPager = (NoScrollViewPager)findViewById(R.id.main_frame);

        noScrollViewPager.setScroll(false);*/
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ChatFragment());
        fragmentList.add(new FriendFragment());
        homeFragmentAdapter = new HomeFragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(homeFragmentAdapter);
        viewPager.setCurrentItem(0);
    }

    private void initSlideMenu(){
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.men);
        }
    }

    public void initNavView(){
        navigationView = findViewById(R.id.nav_view);
        /*navigationView.setCheckedItem(R.id.order);
        navigationView.setCheckedItem(R.id.unused);
        navigationView.setCheckedItem(R.id.pay);
        navigationView.setCheckedItem(R.id.comment);*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.order:
                        intent = new Intent(MainActivity.this, OrderActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.unused:
                        Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.pay:
                        Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.comment:
                        Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }

}
