package com.zhxh.xmvvm.ui.activity;

import android.os.Bundle;

import com.zhxh.xmvvm.BR;
import com.zhxh.xmvvm.R;
import com.zhxh.xmvvm.databinding.ActivityDemoBinding;
import com.zhxh.xmvvm.ui.vm.DemoViewModel;

import com.zhxh.mvvm.base.BaseActivity;

/**

 */

public class DemoActivity extends BaseActivity<ActivityDemoBinding, DemoViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_demo;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public DemoViewModel initViewModel() {
        return new DemoViewModel(this);
    }
}
