package com.QHTtest.view.activity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.QHTtest.R;
import com.QHTtest.presenter.UpLoadPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Title:视频上传
 * Thinking:
 * 作者：邹诗惠 on 2017/7/27 09:38
 */

public class UploadVideoActivity extends BaseActivity<UpLoadPresenter> {

    private Map<String, String> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UpLoadPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_upload_video;
    }

    public void upload(View view) {
        List<File> pathList = new ArrayList<>();
        pathList.add(new File(Environment.getExternalStorageDirectory() + "/local_zsh_mp4.mp4"));
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("mediaDescription", "一个视频")
                .addFormDataPart("mediaDictionaryValue", "1")
                .addFormDataPart("mediaUserId", "1");
        for (int i = 0; i < pathList.size(); i++) {
            RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), pathList.get(i));
            builder.addFormDataPart("file", "guo.mp4", imageBody);
        }
        List<MultipartBody.Part> parts = builder.build().parts();
        mPresenter.filePost("media/uploadMedia", parts, null);

    }
}
