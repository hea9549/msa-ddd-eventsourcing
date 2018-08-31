package com.itchain.msadddeventsourcing.orderservice.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String getNowDateString(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
