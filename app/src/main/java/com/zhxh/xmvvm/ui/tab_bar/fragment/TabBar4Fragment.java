package com.zhxh.xmvvm.ui.tab_bar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhxh.xmvvm.BR;
import com.zhxh.xmvvm.R;

import com.zhxh.mvvm.base.BaseFragment;
import com.zhxh.mvvm.base.BaseViewModel;

/**

 */

public class TabBar4Fragment extends BaseFragment {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_tab_bar_4;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public BaseViewModel initViewModel() {
        return new BaseViewModel();
    }
}
