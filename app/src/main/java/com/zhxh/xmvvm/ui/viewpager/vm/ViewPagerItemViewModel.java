package com.zhxh.xmvvm.ui.viewpager.vm;

import android.content.Context;

import com.zhxh.mvvm.base.BaseViewModel;

/**

 */

public class ViewPagerItemViewModel extends BaseViewModel {
    public String text;

    public ViewPagerItemViewModel(Context context, String text) {
        super(context);
        this.text = text;
    }
}
