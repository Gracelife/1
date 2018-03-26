package com.example.administrator.slopedisplacement.http;


import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.PanoramaImgBean;
import com.example.administrator.slopedisplacement.bean.ProjectBean;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;
import com.example.administrator.slopedisplacement.bean.SchemeBean;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeFixedListJson;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeFixedListLogJson;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeMonitorListLogJson;
import com.example.administrator.slopedisplacement.url.UrlHelper;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by GaoSheng on 2016/9/13.
 * 网络请求的接口都在这里
 */

public interface ApiService {
    //获取banner
    //String url = "";

    @FormUrlEncoded
    @POST(UrlHelper.API + "Login")
    Observable<HttpResponse<LoginBean>> login(@Field("userPassWord") String passWord, @Field("userName") String userName);

    @FormUrlEncoded
    @POST(UrlHelper.API + "UpdateLoginMessage")
    Observable<HttpResponse> updateLoginMessage(@Field("userName") String userName, @Field("clentid") String clentid);

    @FormUrlEncoded
    @POST(UrlHelper.API + "GetVideoMonitorList")
    Observable<HttpResponse<ProjectBean>> getVideoMonitorList(@Field("keyword") String keyword, @Field("sysId") String sysId, @Field("status") String status, @Field("pageindex") String pageindex, @Field("pagesize") String pagesize, @Field("ismode") String ismode, @Field("areaName") String areaName, @Field("uid") String uid);

    @FormUrlEncoded
    @POST(UrlHelper.API + "GetVideoCamList")
    Observable<HttpResponse<DriverBean>> getVideoCamList(@Field("projId") String projId, @Field("uid") String uid);

    @FormUrlEncoded
    @POST(UrlHelper.API + "GetSchemeList")
    Observable<HttpResponse<SchemeBean>> getSchemeList(@Field("camId") String projId, @Field("uid") String uid);

    @FormUrlEncoded
    @POST(UrlHelper.API + "GetPanoramaImg")
    Observable<HttpResponse<PanoramaImgBean>> getPanoramaImg(@Field("camId") String camId, @Field("startime") String startime, @Field("endTime") String endTime, @Field("pageindex") String pageindex, @Field("pagesize") String pagesize, @Field("uid") String uid);

    /**
     * 获取区域(巡航)列表
     *
     * @param schemeID 方案id
     * @param uid      用户id
     * @return
     */
    @FormUrlEncoded
    @POST(UrlHelper.API + "GetDatSchemeAreaList")
    Observable<HttpResponse<GetDatSchemeAreaListJson>> getDatSchemeAreaList(@Field("schemeID") String schemeID, @Field("uid") String uid);

    /**
     * 获取定点列表
     *
     * @param schemeID 方案id
     * @param uid      用户id
     * @return
     */
    @FormUrlEncoded
    @POST(UrlHelper.API + "GetDatSchemeFixedList")
    Observable<HttpResponse<GetDatSchemeFixedListJson>> getDatSchemeFixedList(@Field("schemeID") String schemeID, @Field("uid") String uid);

    /**
     * 获取区域监测点日志top1(最新一条)
     *
     * @param schemeID 方案id
     * @param uid      用户id
     * @return
     */
    @FormUrlEncoded
    @POST(UrlHelper.API + "GetSchemeMonitorLog")
    Observable<HttpResponse<GetDatSchemeFixedListJson>> getSchemeMonitorLog(@Field("schemeID") String schemeID, @Field("uid") String uid);


    @FormUrlEncoded
    @POST(UrlHelper.API + "GetSchemeAlarmList")
    Observable<HttpResponse<SchemeAlarmListBean>> getSchemeAlarmList(@Field("schemeID") String schemeID, @Field("states") String states, @Field("startTime") String startTime, @Field("endTime") String endTime, @Field("pageindex") String pageindex, @Field("pagesize") String pagesize, @Field("uid") String uid);

    @FormUrlEncoded
    @POST(UrlHelper.API + "GetSchemeAlarm")
    Observable<HttpResponse<PanoramaImgBean>> getSchemeAlarm(@Field("schemeID") String schemeID, @Field("states") String states, @Field("uid") String uid);

    @FormUrlEncoded
    @POST(UrlHelper.API + "UpdateSchemeAlarmByAlarmID")
    Observable<HttpResponse<HttpResponse>> updateSchemeAlarmByAlarmID(@Field("alarmID") String schemeID, @Field("states") String states, @Field("uid") String uid);


    @FormUrlEncoded
    @POST(UrlHelper.API + "GetSchemeMonitorListLog")
    Observable<HttpResponse<GetSchemeMonitorListLogJson>> getSchemeMonitorListLog(@Field("schemeID") String schemeID, @Field("areaID") String areaID, @Field("startTime") String startTime, @Field("endTime") String endTime, @Field("monitorID") String monitorID, @Field("pageindex") int pageindex, @Field("pagesize") int pagesize, @Field("uid") String uid);

    @FormUrlEncoded
    @POST(UrlHelper.API + "GetSchemeFixedListLog")
    Observable<HttpResponse<GetSchemeFixedListLogJson>> getSchemeFixedListLog(@Field("schemeID") String schemeID, @Field("fixedID") String fixedID, @Field("startTime") String startTime, @Field("endTime") String endTime, @Field("monitorID") String monitorID, @Field("pageindex") int pageindex, @Field("pagesize") int pagesize, @Field("uid") String uid);

}
