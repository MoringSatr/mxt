package com.hoolai.mxt.common;

import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author liubowen
 * @date 2018/3/16 17:55
 * @description
 */
public class Util {

    public static void addLocalInfo(ModelAndView modelAndView) {
        modelAndView.addObject("serverUrl", Constant.SERVER_URL);
        modelAndView.addObject("resources_url", Constant.RESOURCE_URL);
        modelAndView.addObject("game_name", Constant.GAME_NAME);
    }

    /**
     * MD5加密
     *
     * @param str
     * @return
     */
    public static String encodeByMD5(String str) {
        if (null == str || 0 == str.length()) {
            return null;
        }
        String resutl = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");// 获取MD5算法对象
            byte[] digest = instance.digest(str.getBytes());// 对字符串加密,返回字节数组
            StringBuffer strBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);// 将整数转为16进制
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;// 如果是1位的话,补0
                }
                strBuffer.append(hexString);
            }
            resutl = strBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resutl;
    }

    /**
     * SHA1加密
     *
     * @param str
     * @return
     */
    public static String encodeBySha1(String str) {
        if (null == str || 0 == str.length()) {
            return null;
        }
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }

            return new String(buf);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encodePassword(String password) {
        if (null == password || 0 == password.length()) {
            return null;
        }
        return encodeBySha1(encodeByMD5(password)).toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        System.err.println(Util.encodePassword("wqeqweqweq213123"));
    }
}
