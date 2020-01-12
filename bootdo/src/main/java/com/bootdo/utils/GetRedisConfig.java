package com.bootdo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetRedisConfig {

    private final static String CONFIG_PATH = "\\src\\main\\resources\\config\\Config.properties";
    public static String getRedisIp() {
        try {
            Properties properties = null;
            properties = new Properties();
            File file = new File(getConfigPath());
            InputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return properties.get("redis.ip") + "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getRedisPassword() {
        try {
            Properties properties = null;
            properties = new Properties();
            File file = new File(getConfigPath());
            InputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return properties.get("redis.password") + "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getRedisPort() {
        try {
            Properties properties = null;
            properties = new Properties();
            File file = new File(getConfigPath());
            InputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return Integer.valueOf(properties.get("redis.port") + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getConfigPath() {
        File directory = new File("./");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseFile + CONFIG_PATH;
    }
}
