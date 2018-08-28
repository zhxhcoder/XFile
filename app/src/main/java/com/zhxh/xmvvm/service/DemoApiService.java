package com.zhxh.xmvvm.service;

import com.zhxh.xmvvm.entity.DemoEntity;

import io.reactivex.Observable;
import com.zhxh.mvvm.http.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**

 */

public interface DemoApiService {
    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("id") String id);
}
