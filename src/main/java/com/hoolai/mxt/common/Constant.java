package com.hoolai.mxt.common;

import java.io.IOException;
import java.io.InputStream;
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

    public static String GAME_NAME;

    public static String GAME_ICON_URL;

    public static String GAME_PROTOCOL_URL;

    public static void load(String springProfiles) {
        try {
            Properties properties = new Properties();
            loadPlatformProperties(properties, springProfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadPlatformProperties(Properties properties, String springProfiles) throws IOException {
        InputStream resourceAsStream = Constant.class.getClassLoader().getResourceAsStream("platform" + "-" + springProfiles + ".properties");
        properties.load(resourceAsStream);
        RESOURCE_URL = properties.getProperty("resource_url");
        SERVER_URL = properties.getProperty("server_url");
        DISPATCH_URL = properties.getProperty("dispatch_url");
        SERVER_ID = Integer.parseInt(properties.getProperty("server_id"));
        IS_LOCAL = Boolean.parseBoolean(properties.getProperty("is_local"));
        GAME_URL = properties.getProperty("game_url");
        GAME_NAME = properties.getProperty("game_name");
        GAME_ICON_URL = properties.getProperty("game_icon_url");
        GAME_PROTOCOL_URL = properties.getProperty("game_protocol_url");
    }

}
