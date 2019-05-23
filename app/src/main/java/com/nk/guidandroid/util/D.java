package com.nk.guidandroid.util;

import android.util.TypedValue;

import com.nk.guidandroid.MyApplication;

public class D {

    public static float dp2px(int dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, MyApplication.getInstance().getResources().getDisplayMetrics());
    }
}
