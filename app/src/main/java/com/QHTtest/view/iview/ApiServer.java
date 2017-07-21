package com.QHTtest.view.iview;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 仇海涛 on 2017/7/13.
 * class ：
 * content ：
 */

public interface ApiServer {

    @GET()
    Observable<String> getTest(@Url String url,@QueryMap Map<String,String> map);

    @FormUrlEncoded
    @POST()
    Observable<String> postTest(@Url String url,@FieldMap Map<String,String> map);

}
