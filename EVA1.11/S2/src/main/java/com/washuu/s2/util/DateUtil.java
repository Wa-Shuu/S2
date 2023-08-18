package com.washuu.s2.util;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class DateUtil {

    public static String getDateTime() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = dtf.format(ldt);
        System.out.println(dateTime);
        return dateTime;
    }

    public static String getDate() {
        LocalDate ld = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dtf.format(ld);
        System.out.println(date);
        return date;
    }

    public static int getYear() {
        LocalDate ld = LocalDate.now();
        return ld.getYear();
    }

    public static String getMonth() {
        LocalDate ld = LocalDate.now();
        String month = ld.getMonth().toString();
        return month;
    }


    public static String getTime() {
        LocalTime lt = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = dtf.format(lt);
        System.out.println(time);
        return time;
    }

    public static String getDayOfWeek() {
        LocalDate ld = LocalDate.now();
        String day = ld.getDayOfWeek().toString();
        return day;
    }
    public static int getDayOfMonth() {
        LocalDate ld = LocalDate.now();
        int day = ld.getDayOfMonth();
        return day;
    }
    public static int getDayOfYear() {
        LocalDate ld = LocalDate.now();
        int day = ld.getDayOfYear();
        return day;
    }
    public static String getDateTimeChinese() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 EE HH:mm:ss");
        String dateTime = dtf.format(ldt);
        System.out.println(dateTime);
        return dateTime;
    }

    public static String getDateChinese() {
        LocalDate ld = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String date = dtf.format(ld);
        System.out.println(date);
        return date;
    }


    public static LocalDateTime getLocalTimeFromString(String formattedStr) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(formattedStr, dtf);
    }



}
