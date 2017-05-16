package cg.demo.com.cg.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.igexin.sdk.PushManager;

import cg.demo.com.cg.service.CGIntentService;
import cg.demo.com.cg.service.GTPushService;
import cg.demo.com.cg.utils.PermissionUtils;

/**
 * Created by ${LuoChen} on 2017/5/16 10:13.
 * email:luochen0519@foxmail.com
 */

public class BaseActivity extends AppCompatActivity {

    private PermissionHandler mHandler;

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

    /**
     * 请求权限
     *
     * @param permissions 权限列表
     * @param handler     回调
     */
    protected void requestPermission(String[] permissions, PermissionHandler handler) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PermissionUtils.hasSelfPermissions(this, permissions)) {//同意
                handler.onGranted();
            } else {
                mHandler = handler;
                ActivityCompat.requestPermissions(this, permissions, 001);
            }
        }
    }

    /**
     * 权限回调接口
     */
    public abstract class PermissionHandler {
        /**
         * 权限通过
         */
        public void onGranted() {
        }

        /**
         * 权限拒绝
         */
        public void onDenied() {
        }

        /**
         * 不再询问
         *
         * @return 如果要覆盖原有提示则返回true
         */
        public boolean onNeverAsk() {
            return false;
        }
    }
}
