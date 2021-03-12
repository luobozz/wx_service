package com.luobo.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TimeStampHelper class
 *
 * @author chenlingyu
 * @date 2020/5/13 13:31
 */
public class TimeStampHelper {

    public static Timestamp getNow() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getNowOrderNo() {
        return new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
    }

}
