package com.zhxh.xmvvm.ui.vm;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.zhxh.xmvvm.R;
import com.zhxh.xmvvm.entity.DemoEntity;
import com.zhxh.xmvvm.ui.fragment.DetailFragment;

import com.zhxh.mvvm.base.BaseViewModel;
import com.zhxh.mvvm.binding.command.BindingAction;
import com.zhxh.mvvm.binding.command.BindingCommand;
import com.zhxh.mvvm.bus.Messenger;
import com.zhxh.mvvm.utils.ToastUtils;

/**

 */

public class NetWorkItemViewModel extends BaseViewModel {
    public DemoEntity.ItemsEntity entity;
    public Drawable drawableImg;
    public NetWorkItemViewModel(Context context, DemoEntity.ItemsEntity entity) {
        super(context);
        this.entity = entity;
        //ImageView的占位图片，可以解决RecyclerView中图片错误问题
        drawableImg = ContextCompat.getDrawable(context, R.mipmap.ic_launcher);
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //这里可以通过一个标识,做出判断，已达到跳入不能界面的逻辑
            if (entity.getId() == -1) {
                ToastUtils.showShort(entity.getName());
            } else {
                //跳转到详情界面,传入条目的实体对象
                Bundle mBundle = new Bundle();
                mBundle.putParcelable("entity", entity);
                startContainerActivity(DetailFragment.class.getCanonicalName(), mBundle);
            }
        }
    });
    //条目的长按事件
    public BindingCommand itemLongClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //使用Messenger发送事件，在NetWorkViewModel中完成删除逻辑
            Messenger.getDefault().send(NetWorkItemViewModel.this, NetWorkViewModel.TOKEN_NETWORKVIEWMODEL_DELTE_ITEM);
        }
    });
//    /**
//     * 可以在xml中使用binding:currentView="@{viewModel.titleTextView}" 拿到这个控件的引用, 但是不推荐这样做
//     **/
//    private TextView tv;
//    //将标题TextView控件回调到ViewModel中
//    public BindingCommand<TextView> titleTextView = new BindingCommand(new BindingConsumer<TextView>() {
//        @Override
//        public void call(TextView tv) {
//            NetWorkItemViewModel.this.tv = tv;
//        }
//    });

}
