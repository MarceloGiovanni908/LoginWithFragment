package com.example.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        RegisterFragment mRegisterFragment = new RegisterFragment();
        mFragmentTransaction.add(R.id.container1, mRegisterFragment, RegisterFragment.class.getSimpleName());

        Log.d("Fragment1", "Fragment Name :" + RegisterFragment.class.getSimpleName());
        mFragmentTransaction.commit();
    }
}