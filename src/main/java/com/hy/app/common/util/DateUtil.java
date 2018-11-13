/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */
package com.hy.app.common.util;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * DateUtil
 *
 * @author yeling
 * @date 2018年10月12日
 * desc：
 */
public class DateUtil {

    public static String MONTH_DAY = "M月dd日";

    public static String NEW_MONTH_DAY = "M.dd";

    public static String MONTH_DAY_SPRIT = "MM/dd";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYY_MM_DD_HH = "yyyy-MM-dd HH";

    public static String YYYYMMDD = "yyyyMMdd";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String HH_MM = "HH:mm";

    public static String CHINA_MM_DD_HH_MM = "M月d日 HH:mm";

    public static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String MM_DD = "MM-dd";

    public static final String MMDD_HHMM = "MM-dd HH:mm";

    /**
     * timestamps转换成 LocalDate
     *
     * @param timestamps 时间戳
     * @return LocalDate 对象
     */
    public static LocalDate timestamps2LocalDate(long timestamps) {
        return date2LocalDate(new Date(timestamps));
    }

    /**
     * timestamps转换成 LocalDateTime
     *
     * @param timestamps 时间戳
     * @return LocalDate 对象
     */
    public static LocalDateTime timestamps2LocalDateTime(long timestamps) {
        return date2LocalDateTime(new Date(timestamps));
    }

    /**
     * 将date转换成 LocalDate 对象
     *
     * @param date 对象
     * @return timestamps 时间戳
     */
    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * date-->LocalDateTime
     *
     * @param date date
     * @return date
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(date.toInstant(), zoneId);
    }


    /**
     * localDate-->Date
     *
     * @param localDate localDate
     * @return date
     */
    public static Date localDate2Date(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(Instant.from(zdt));
    }

    /**
     * 将LocalDate转换成时间戳
     *
     * @param localDate 对象
     * @return timestamps 时间戳
     */
    public static long localDate2Timestamps(LocalDate localDate) {
        Date date = localDate2Date(localDate);
        return date.getTime();
    }

    /**
     * localDateTime-->timestamps
     *
     * @param localDateTime localDateTime
     * @return timestamps
     */
    public static Long localDateTime2Timestamps(LocalDateTime localDateTime) {
        Date date = localDateTime2Date(localDateTime);
        return date.getTime();
    }

    /**
     * localDateTime-->Date
     *
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }


    /**
     * 格式化
     * timestamps --> formatStr
     *
     * @param timeLong  timestamps
     * @param formatStr formatStr
     * @return Str
     */
    public static String timeMillis4FormatStr(long timeLong, String formatStr) {
        try {
            LocalDateTime localDateTime = date2LocalDateTime(new Date(timeLong));
            DateTimeFormatter format = DateTimeFormatter.ofPattern(formatStr);
            return localDateTime.format(format);
        } catch (DateTimeException ex) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 格式化 带有时区
     * timestamps --> formatStr
     *
     * @param timeLong  timestamps
     * @param formatStr formatStr
     * @param timeZone  timeZone
     * @return Str
     */
    public static String timeMillis4FormatStr(long timeLong, String formatStr, String timeZone) {
        try {
            if (StringUtils.isBlank(formatStr)) {
                formatStr = YYYY_MM_DD_HH_MM;
            }

            if (StringUtils.isBlank(timeZone)) {
                timeZone = "GMT+8";
            }
            TimeZone timeZoneVariable = TimeZone.getTimeZone(timeZone);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date(timeLong).toInstant(), timeZoneVariable.toZoneId());
            DateTimeFormatter format = DateTimeFormatter.ofPattern(formatStr);
            return localDateTime.format(format);
        } catch (DateTimeException ex) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * dateStr ""
     *
     * @param dateStr "yyyy-MM-dd HH:mm:ss"
     * @return LocalDate
     */
    public static LocalDate str2LocalDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * dateStr ""
     *
     * @param dateStr "yyyy-MM-dd HH:mm:ss"
     * @return LocalDateTime
     */
    public static LocalDateTime str2LocalDateTime(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        return LocalDateTime.parse(dateStr, formatter);
    }


    /**
     * 传入时间是否是今天
     *
     * @param time
     * @return
     */
    public static boolean isToday(long time) {
        LocalDate today = timestamps2LocalDate(time);
        return today.equals(LocalDate.now());
    }

    /**
     * 时间间隔
     *
     * @param firstDay firstDay
     * @param lastDay  lastDay
     * @return time-ms 时间间隔
     */
    public static long getBetweenDay(LocalDate firstDay, LocalDate lastDay) {
        return (lastDay.toEpochDay() - firstDay.toEpochDay());
    }
}

    