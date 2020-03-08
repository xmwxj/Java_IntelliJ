package com.jdk8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Java8时间格式化 {
	private static final ConcurrentMap<String, DateTimeFormatter> FORMATTER_CACHE = new ConcurrentHashMap<>();
	private static final int PATTERN_CACHE_SIZE = 100;

	/**
	 * Date转换为格式化时间
	 * @param date date
	 * @param pattern 格式
	 * @return
	 */
	public static String format(Date date, String pattern){
		return format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()), pattern);
	}


	/**
	 * localDateTime转换为格式化时间
	 * @param localDateTime localDateTime
	 * @param pattern 格式
	 * @return
	 */
	public static String format(LocalDateTime localDateTime, String pattern){
		DateTimeFormatter formatter = createCacheFormatter(pattern);
		return localDateTime.format(formatter);
	}

	/**
	 * 格式化字符串转为Date
	 * @param time 格式化时间
	 * @param pattern 格式
	 * @return
	 */
	public static Date parseDate(String time, String pattern){
		return converLocalDateTimeToDate(parseLocalDateTime(time, pattern));

	}

	/**
	 * 格式化字符串转为LocalDateTime
	 * @param time 格式化时间
	 * @param pattern 格式
	 * @return
	 */
	public static LocalDateTime parseLocalDateTime(String time, String pattern){
		DateTimeFormatter formatter = createCacheFormatter(pattern);
		return LocalDateTime.parse(time, formatter);
	}

	/**
	 * Data类型转化为LocalDateTime类型
	 * @param date
	 * @return
	 */
	public static LocalDateTime convertDateToLocalDateTime(Date date) {
		Instant instant =  date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		return instant.atZone(zoneId).toLocalDateTime();
	}

	/**
	 *
	 * @param pattern
	 * @return
	 */
	public static Date converLocalDateTimeToDate(LocalDateTime localDateTime) {
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = localDateTime.atZone(zoneId);
		return Date.from(zdt.toInstant());
	}


	private static DateTimeFormatter createCacheFormatter(String pattern){
		if (pattern == null || pattern.length() == 0) {
			throw new IllegalArgumentException("Invalid pattern specification");
		}
		DateTimeFormatter formatter = FORMATTER_CACHE.get(pattern);
		if(formatter == null){
			if(FORMATTER_CACHE.size() < PATTERN_CACHE_SIZE){
				formatter = DateTimeFormatter.ofPattern(pattern);
				DateTimeFormatter oldFormatter = FORMATTER_CACHE.putIfAbsent(pattern, formatter);
				if(oldFormatter != null){
					formatter = oldFormatter;
				}
			}
		}

		return formatter;
	}
}
