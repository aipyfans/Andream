package com.dream.william.net;


import com.hylaa.lib.net.model.BaseJsonBody;
import com.hylaa.lib.net.model.BodyWrapper;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface ServiceInterface {

    @GET("top250")
    Observable<Movies> getTopMovie(@Query("start") int start, @Query("count") int count);

    @POST("link2svc/sync")
    Observable<BaseJsonBody<String>> syscAll(@Body BodyWrapper bw);

}
