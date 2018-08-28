package com.zhxh.mvvm.binding.command;

import com.zhxh.mvvm.R;

/**
 * Represents a function with zero arguments.
 *
 * @param <T> the result type
 */
public interface BindingFunction<T> {
    T call();
}
