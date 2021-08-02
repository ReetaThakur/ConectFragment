package com.example.conectfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnAddFirst;
    private Button mBtnAddSecond;
    private Button mBtnReplaceFirstWithoutStackSecond;
    private Button mBtnReplaceSecondWithFirst;
    private Button mBtnRemoveFirst;
    private Button mBtnRemoveSecond;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnAddFirst=findViewById(R.id.btnAddA);
        mBtnAddSecond = findViewById(R.id.btnAddB);
        mBtnReplaceFirstWithoutStackSecond=findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnReplaceSecondWithFirst=findViewById(R.id.btnReplaceBWithA);
        mBtnRemoveFirst=findViewById(R.id.btnRemoveA);
        mBtnRemoveSecond=findViewById(R.id.btnRemoveB);
        fragmentManager=getSupportFragmentManager();
        mBtnAddFirst.setOnClickListener(this);
        mBtnAddSecond.setOnClickListener(this);
        mBtnReplaceFirstWithoutStackSecond.setOnClickListener(this);
        mBtnReplaceSecondWithFirst.setOnClickListener(this);
        mBtnRemoveFirst.setOnClickListener(this);
        mBtnRemoveSecond.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        FragmentTransaction fragmentTransaction;
        FirstFragment firstFragment;
        SecondFragment SecondFragment;
        switch (id) {
            case R.id.btnAddA:
                fragmentTransaction = fragmentManager.beginTransaction();
                firstFragment = new FirstFragment();
                fragmentTransaction.add(R.id.flContainer, firstFragment, "FirstFragment").commit();
                break;
            case R.id.btnAddB:
                fragmentTransaction = fragmentManager.beginTransaction();
                SecondFragment = new SecondFragment();
                fragmentTransaction.add(R.id.flContainer, SecondFragment, "SecondFragment").commit();
                break;
            case R.id.btnRemoveA:
                fragmentTransaction = fragmentManager.beginTransaction();
                firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("FirstFragment");
                if (firstFragment != null) {
                    fragmentTransaction.remove(firstFragment);
                } else {
                    Toast.makeText(this, " first Fragment is not present", Toast.LENGTH_LONG).show();
                }


                break;
            case R.id.btnRemoveB:
                fragmentTransaction = fragmentManager.beginTransaction();
                SecondFragment = (SecondFragment) fragmentManager.findFragmentByTag("SecondFragment");
                if (SecondFragment != null) {
                    fragmentTransaction.remove(SecondFragment);
                } else {
                    Toast.makeText(this, " Second Fragment is not present", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btnReplaceAWithB:
                fragmentTransaction = fragmentManager.beginTransaction();
                SecondFragment = new SecondFragment();
                fragmentTransaction.replace(R.id.flContainer, SecondFragment, "SecondFragment").commit();
                break;
            case R.id.btnReplaceBWithA:
                fragmentTransaction = fragmentManager.beginTransaction();
                firstFragment = new FirstFragment();
                fragmentTransaction.replace(R.id.flContainer, firstFragment, "FirstFragment").commit();

                break;
        }
    }
}
