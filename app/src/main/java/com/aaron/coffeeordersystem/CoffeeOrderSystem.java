package com.aaron.coffeeordersystem;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.aaron.coffeeordersystem.fragment.ListFragment;
import com.aaron.coffeeordersystem.fragment.PurchaseFragment;

public class CoffeeOrderSystem extends AppCompatActivity {

    private FragmentTransaction mFragmentTransaction;
    private ListFragment mFragmentList = new ListFragment();
    private PurchaseFragment mFragmentPurchase = new PurchaseFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_order_system);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mFragmentTransaction = getFragmentManager().beginTransaction();

        mFragmentTransaction.add(R.id.framlayout, mFragmentList);
        mFragmentTransaction.add(R.id.framlayout, mFragmentPurchase);

        mFragmentTransaction.show(mFragmentPurchase).hide(mFragmentList);
        mFragmentTransaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mFragmentTransaction = getFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_purchase:
                    mFragmentTransaction.show(mFragmentPurchase).hide(mFragmentList).commit();
                    return true;
                case R.id.navigation_list:
                    mFragmentTransaction.show(mFragmentList).hide(mFragmentPurchase).commit();
                    return true;
            }
            return false;
        }
    };
}
