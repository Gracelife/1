package com.example.administrator.slopedisplacement.activity;


import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.slopedisplacement.MainActivity;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.base.BaseActivity;
import com.example.administrator.slopedisplacement.utils.GeTuiUtil;
import com.example.administrator.slopedisplacement.utils.PermissionsUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * 欢迎页面
 */
public class WelcomeActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        PermissionsUtils.requestPermissions(this, PermissionsUtils.PERMISSION_GETUI, new PermissionsUtils.PermissionCall() {
            @Override
            public void onSuccess() {
                GeTuiUtil.init(getActivity());
                //延迟两秒后跳转
                Observable.timer(3, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(l -> toMainActivity());
            }

            @Override
            public void onFail() {
                showToast("权限被拒绝，无法启动推送！");
            }
        });
    }

    private void toMainActivity() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}