package com.zhxh.xmvvm.ui.vm;

import com.zhxh.xmvvm.entity.DemoEntity;

import com.zhxh.mvvm.base.BaseViewModel;

/**

 */

public class DetailViewModel extends BaseViewModel {
    public DemoEntity.ItemsEntity entity;

    public DetailViewModel(DemoEntity.ItemsEntity entity) {
        this.entity = entity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        entity = null;
    }
}
