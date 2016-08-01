package com.advanced.huza.android_41_03_coordinatorlayoutproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn1:
                intent.setClass(this, CollapsingActivity.class);
                break;
            case R.id.btn2:
                intent.setClass(this, TabLayoutActivity.class);
                break;
        }
        startActivity(intent);
    }
}
