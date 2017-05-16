package cg.demo.com.cg.utils;

/**
 * Created by ${LuoChen} on 2017/4/10 14:45.
 * email:luochen0519@foxmail.com
 * <p>
 * app中配置类
 */

public interface SettingsUtils {
    /**
     * SD卡中文件夹名称
     */
    String SD_DIR = "CG";

    /**
     * 地图路径保存文件夹名称
     */
    String RECORDPATH = "/CG/recordPath";
    /**
     * 地图路径保存文件夹名称
     */
    String IMAGE_SILENTPATH = "/CG/silent";

    /**
     * 外部内存权限的请求吗
     */
    int PREMIERE_REQUEST_CODE_STORAGE = 1;

    /**
     * sp的名称
     */
    String SP_NAME = "cg";


    /**
     * 是否第一次进入app
     */
    String IS_FIRST_ENTER = "IS_FIRST_ENTER";


    /**
     * mapActivity中最后一个定位点
     */
    String LASTLATLNG = "LASTLATLNG";

    /**
     * 静默拍照成功
     */
    String ACTION_SILENT_MASTER_OK = "ACTION_SILENT_MASTER_OK";
    /**
     * 静默拍照开启
     */
    String ACTION_SILENT_MASTER_START = "ACTION_SILENT_MASTER_START";
    /**
     * 静默拍照结束
     */
    String ACTION_SILENT_MASTER_STOP = "ACTION_SILENT_MASTER_STOP";
}
