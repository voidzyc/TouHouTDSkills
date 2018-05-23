package com.example.touhoutd.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * author:admin
 * createTime:2018/5/23 18:22
 * remake:
 */
public abstract class BaseActivity extends AppCompatActivity {

//    private final String CLASS_NAME = this.getClass().getName();
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("TAG", "onStart+" + CLASS_NAME);
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.d("TAG", "onCreate+" + CLASS_NAME);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("TAG", "onDestroy+" + CLASS_NAME);
//    }

    /**
     * 点击Actionbar中的返回按钮会触发将要返回Activity的onCreate
     *
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        this.onBackPressed();
        return true;
    }
}
