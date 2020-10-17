package project.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }
}
