package com.zhxh.xmvvm.ui.fragment;

import android.databinding.Observable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhxh.xmvvm.BR;
import com.zhxh.xmvvm.R;
import com.zhxh.xmvvm.databinding.FragmentNetworkBinding;
import com.zhxh.xmvvm.ui.vm.NetWorkViewModel;

import com.zhxh.mvvm.base.BaseFragment;

/**

 * 网络请求列表界面
 */

public class NetWorkFragment extends BaseFragment<FragmentNetworkBinding, NetWorkViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_network;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public NetWorkViewModel initViewModel() {
        return new NetWorkViewModel(this.getContext());
    }

    @Override
    public void initViewObservable() {
        //监听下拉刷新完成
        viewModel.uc.isFinishRefreshing.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                //结束刷新
                binding.twinklingRefreshLayout.finishRefreshing();
            }
        });
        //监听上拉加载完成
        viewModel.uc.isFinishLoadmore.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                //结束刷新
                binding.twinklingRefreshLayout.finishLoadmore();
            }
        });
    }
}
