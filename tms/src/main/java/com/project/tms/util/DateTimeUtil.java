package com.project.tms.util;

import com.project.tms.constant.DateConst;
import io.micrometer.common.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {

    public static Date stringToDate(String dateStr){
        Date date = null;
        if(StringUtils.isNotBlank(dateStr)){
            try{
                date = new SimpleDateFormat(DateConst.DATE_dd_MM_yyyy_FORMAT).parse(dateStr);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return date;
    }

    public static LocalDateTime convertDateTimeToDB(String dateStr){
        if(StringUtils.isNotBlank(dateStr)){
            try{
                ZonedDateTime localDateTime = ZonedDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
                return localDateTime.toLocalDateTime();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String convertDBToString(LocalDateTime localDateTime){
        String date = "";
        if(localDateTime != null){
            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateConst.DATE_d_MMMM_yyyy_h_mma);
                date = localDateTime.format(formatter);
                return date;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return date;
    }
}
