package com.itchain.msadddeventsourcing.deliveryservice.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String getNowDateString(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
