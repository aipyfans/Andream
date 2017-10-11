/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hylaa.lib.mvp;

import android.content.Context;

public interface BaseView<T> {

    Context getContext();

    String getStr(int resId);

    String getStr(int resId, Object... formatArgs);

    void setPresenter(T presenter);

    /**
     * 显示加载过程的进度条的视图.
     */
    void onShowLoading();


    /**
     * 隐藏加载视图.
     */
    void onHideLoading();


    /**
     * 当加载数据出错时,尝试重试.
     */
    void onRetryAgain();


    /**
     * 设置【没有网络】的视图
     */
    void onNetErrorView();

    /**
     * 设置【通用错误】的视图
     */
    void onNotErrorView();

    /**
     * 设置【无数据】的视图
     */
    void onDataEmptyView();

    /**
     * 设置【没有更多数据】的视图
     */
    void onNoMoreView();

}
