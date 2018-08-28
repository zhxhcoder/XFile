package com.zhxh.xmvvm.ui.vm;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.zhxh.mvvm.base.BaseViewModel;
import com.zhxh.mvvm.binding.command.BindingAction;
import com.zhxh.mvvm.binding.command.BindingCommand;

/**
 * 对应include标题的ViewModel
 * 所有例子仅做参考,理解如何使用才最重要。
 * Toolbar的封装方式有很多种，具体封装需根据项目实际业务和习惯来编写

 */

public class TitleViewModel extends BaseViewModel {
    public ObservableField<String> titleText = new ObservableField<>("");
    public ObservableField<String> rightText = new ObservableField<>("");
    public ObservableInt rightTextVisibility = new ObservableInt(View.GONE);

    public TitleViewModel(Context context) {
        super(context);
    }
    //点击返回
    public BindingCommand backOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ((Activity) context).finish();
        }
    });
    //右边文字点击事件
    public BindingCommand rightTextOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
        }
    });
}
