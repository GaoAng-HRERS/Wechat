package com.guanwei.wechat.utils;

import lombok.Cleanup;

import java.io.InputStream;
import java.util.Properties;

/**
 * 功能描述：
 * 读取配置文件的值.
 *
 * @version V1.0
 * @classname: com.metlife.wechat.common.utils.ConfigPropUtils.java
 * @copyright Powered By wechat
 * @author: somnus
 * @date: 2020-03-03 20:48:28
 */
public class ConfigPropUtils {

    /** Properties. */
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            //读取message配置文件属性
            @Cleanup InputStream in = ConfigPropUtils.class.getClassLoader().getResourceAsStream("message.properties");
            //读取common配置文件属性
            @Cleanup InputStream cm = ConfigPropUtils.class.getClassLoader().getResourceAsStream("common.properties");

            properties.load(in);
            properties.load(cm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key获取Value.
     * @param key 配置文件中的键
     * @return
     */
    public static String get(String key) {
        return properties.getProperty(key, null);
    }

}
