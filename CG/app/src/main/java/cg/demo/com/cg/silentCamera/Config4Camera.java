package cg.demo.com.cg.silentCamera;

import android.os.Environment;

import java.util.ArrayList;
import java.util.List;

import cg.demo.com.cg.utils.SettingsUtils;

/**
 * 相机配置类
 */
public class Config4Camera {
    //存储路径
	public static String POTOPATH =   Environment.getExternalStorageDirectory()+ SettingsUtils.IMAGE_SILENTPATH;
	public static List<String> silentPotoList= new ArrayList<String>();

}
