package com.hylaa.lib.net.common;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * TODO.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-6.
 * @tel 152-5320-8570
 */
public class NetUtil {

    /**
     * get utc time.
     *
     * @return UTC date for Strings
     */
    public static String getCurrentUTCDate() {
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'UTC'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String timeStr = sdf.format(cd.getTime());
        return timeStr.toString();
    }


    /**
     * md5
     *
     * @param bytes
     * @return
     */
    public static String getMD5(byte[] bytes) {
        String strTemp;
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(bytes);
            StringBuilder hexString = new StringBuilder();
            for (byte b : algorithm.digest()) {
                if (Integer.toHexString(0xFF & b).length() == 1)
                    hexString.append("0").append(Integer.toHexString(0xFF & b));
                else
                    hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (Exception e) {
            strTemp = "";
        }

        return strTemp;
    }


    /**
     * md5
     *
     * @param digestStr
     * @return
     */
    public static String getMD5(String digestStr) {
        String strTemp;
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(digestStr.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : algorithm.digest()) {
                if (Integer.toHexString(0xFF & b).length() == 1)
                    hexString.append("0").append(Integer.toHexString(0xFF & b));
                else
                    hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (Exception e) {
            strTemp = "";
        }

        return strTemp;
    }


}
