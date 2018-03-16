package com.hoolai.mxt.common;

import java.io.IOException;
import java.util.Properties;

/**
 * @author liubowen
 * @date 2018/3/16 17:43
 * @description
 */
public class Constant {

    public static String RESOURCE_URL;

    public static String SERVER_URL;

    public static String DISPATCH_URL;

    public static int SERVER_ID;

    public static boolean IS_LOCAL;

    public static String GAME_URL;

    static {
        try {
            Properties properties = new Properties();
            loadPlatformProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadPlatformProperties(Properties properties) throws IOException {
        properties.load(Constant.class.getClassLoader().getResourceAsStream("constant_file.properties"));
        String platformPath = properties.getProperty("platform_path");
        properties.clear();
        properties.load(Constant.class.getClassLoader().getResourceAsStream(platformPath));

        RESOURCE_URL = properties.getProperty("resource_url");
        SERVER_URL = properties.getProperty("server_url");
        DISPATCH_URL = properties.getProperty("dispatch_url");
        SERVER_ID = Integer.parseInt(properties.getProperty("server_id"));
        IS_LOCAL = Boolean.parseBoolean(properties.getProperty("is_local"));
        GAME_URL = properties.getProperty("game_url");
    }

}
