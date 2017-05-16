package cg.demo.com.cg.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.igexin.sdk.PushManager;

import cg.demo.com.cg.service.CGIntentService;
import cg.demo.com.cg.service.GTPushService;

/**
 * Created by ${LuoChen} on 2017/5/16 10:13.
 * email:luochen0519@foxmail.com
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initGTPush();
    }

    private void initGTPush() {
        //GTPushService为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(), GTPushService.class);
        //NDemoIntentService为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), CGIntentService.class);
    }
}
