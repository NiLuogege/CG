package cg.demo.com.cg.service;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;

import cg.demo.com.cg.BuildConfig;
import cg.demo.com.cg.bean.ImagePush;
import cg.demo.com.cg.utils.SettingsUtils;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData  处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class CGIntentService extends GTIntentService {

    private static final String TAG = "NDemoIntentService";

    public CGIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    /**
     * 拍照的格式为
     * {
     * "type": "cg",
     * "data": {
     * "url": "lalal"
     * }
     * }
     */
    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        byte[] payload = msg.getPayload();
        String s = new String(payload);
        Gson gson = new Gson();
        ImagePush imagePush = gson.fromJson(s, ImagePush.class);

        String type = imagePush.type;
        if (BuildConfig.DEBUG) Log.e(TAG, "收到透传信息了 type= "+type);
        if (TextUtils.equals(type, "cg")) {
//            Handler handler = new Handler(getMainLooper());
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    SilentCamera.openCamera();
//                }
//            });
            Intent intent = new Intent();
            intent.setAction(SettingsUtils.ACTION_SILENT_MASTER_START);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }


    }


    /**
     * onReceiveClientId 接收 cid <br>
     *
     * @param context
     * @param clientid
     */
    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
    }

    /**
     * cid 离线上线通知
     *
     * @param context
     * @param online
     */
    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
        Log.e(TAG, "onReceiveOnlineState -> " + "online = " + online);
    }

    /**
     * 各种事件处理回执
     *
     * @param context
     * @param cmdMessage
     */
    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
        Log.e(TAG, "onReceiveCommandResult -> " + "cmdMessage = " + cmdMessage.toString());
    }

    public static char byteToChar(byte[] b) {
        char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
        return c;
    }
}
