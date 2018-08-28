package com.zhxh.xmvvm.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhxh.xmvvm.BR;
import com.zhxh.xmvvm.R;
import com.zhxh.xmvvm.entity.DemoEntity;
import com.zhxh.xmvvm.ui.vm.DetailViewModel;

import com.zhxh.mvvm.base.BaseFragment;

/**

 * 详情界面
 */

public class DetailFragment extends BaseFragment{

    private DemoEntity.ItemsEntity entity;

    @Override
    public void initParam() {
        //获取列表传入的实体
        Bundle mBundle = getArguments();
        if (mBundle != null) {
            entity = mBundle.getParcelable("entity");
        }
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_detail;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public DetailViewModel initViewModel() {
        return new DetailViewModel(entity);
    }
}
