package com.hp.utils;

import org.apache.logging.log4j.util.Base64Util;
import org.springframework.util.Base64Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SafeUtils {
    public static String md5(String txt) {
        MessageDigest md = null;
        String result = "";
        try {
            md = MessageDigest.getInstance("md5");
            md.update(txt.getBytes());
            byte[] ds = md.digest();
            result = Base64Utils.encodeToString(ds);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
