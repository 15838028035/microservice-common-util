package com.zhongkexinli.micro.serv.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DateUtil {


  private static Log logger = LogFactory.getLog(DateUtil.class);
  
  public static final String DATE_FOMRAT_HH_mm_ss = "HH:mm:ss";
  public static final String DATE_FOMRAT_hh_mm_ss = "hh:mm:ss";

  public static final String DATE_FOMRAT_yyyy_MM_dd = "yyyy-MM-dd";
  public static final String DATE_FOMRAT_yyyyMMdd = "yyyyMMdd";

  public static final String DATE_FOMRAT_yyyy_MM_dd_HH_MMss = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_FOMRAT_yyyyMMdd_hh_MMss = "yyyyMMdd hh:mm:ss";

  public static final String getNowDateYYYYMMddHHMMSS() {
    return getNowDate(DATE_FOMRAT_yyyy_MM_dd_HH_MMss);
  }

  /**
   * 得到当前时间
   * 
   * @param format
   *          时间格式
   * @return 得到当前时间
   */
  public static String getNowDate(String format) {
    SimpleDateFormat sd = new SimpleDateFormat(format);
    String date = sd.format(new Date(System.currentTimeMillis()));
    return date;
  }

  /**
   * 格式化字符串为Date对象
   * 
   * @param date  字符串
   * @param format 格式
   * @return 格式化字符串为Date对象
   */
  public static Date formatDate(String date, String format) {
    Date d = null;
    if(date == null) {
    	return null;
    }
    try {
      SimpleDateFormat sd = new SimpleDateFormat(format);
      d = sd.parse(date);
    } catch (ParseException e) {
      logger.error(e);
    }

    return d;
  }

  /**
   * 格式化Date对象为string
   * 
   * @param date
   * @param format
   * @return
   */
  public static String formatDate(Date date, String format) {
    try {
      SimpleDateFormat sDateFormat = new SimpleDateFormat(format);
      return sDateFormat.format(date);
    } catch (Exception e) {

    }
    return null;
  }

  public static int getIntervalDays(Date fDate, Date oDate) {

    if (null == fDate || null == oDate ) {
      return -1;
    }

    long intervalMilli = oDate.getTime() - fDate.getTime();
    return (int) (intervalMilli / (24 * 60 * 60 * 1000));
  }

  public static int getIntervalDays(String fDateStr, String oDateStr) {
    if (null == fDateStr || null == oDateStr) {
      return -1;
    }

    Date fDate = formatDate(fDateStr, DATE_FOMRAT_yyyy_MM_dd_HH_MMss);
    Date oDate = formatDate(oDateStr, DATE_FOMRAT_yyyy_MM_dd_HH_MMss);
    
    if (null == fDate || null == oDate ) {
        return -1;
      }

    long intervalMilli = fDate.getTime() - oDate.getTime();
    return (int) (intervalMilli / (24 * 60 * 60 * 1000));
  }

  public static String toTimeStr(String time) {
    if (time == null)
      return null;
    String timeStr = time.substring(0, time.indexOf("+"));
    return timeStr;
  }

  public static String toDateStr(String date) {
    if (date == null)
      return null;
    String month;
    String day;
    String year;

    int dateSlash1 = date.indexOf("-");
    int dateSlash2 = date.lastIndexOf("-");

    year = date.substring(0, dateSlash1);
    month = date.substring(dateSlash1 + 1, dateSlash2);
    day = date.substring(dateSlash2 + 1);

    // MM/DD/YYYY
    return month + "/" + day + "/" + year;
  }

  public static Date handleTimeStrToDate(String timeStr, String style) throws ParseException {
    if (timeStr == null || timeStr.trim().equals(""))
      return null;

    SimpleDateFormat dateFormat = new SimpleDateFormat(style);
    Date date = dateFormat.parse(timeStr);
    return date;
  }

  public static Timestamp handleTimeStrToTimestamp(String timeStr, String style) throws ParseException {
    if (timeStr == null || timeStr.trim().equals(""))
      return null;

    SimpleDateFormat dateFormat = new SimpleDateFormat(style);
    Date date = dateFormat.parse(timeStr);
    Timestamp timestamp = new Timestamp(date.getTime());
    return timestamp;
  }

  public static String handleTimestampToTimeStr(Timestamp timestamp, String style) {
    if (timestamp == null)
      return null;

    SimpleDateFormat dateFormat = new SimpleDateFormat(style);
    String timestampStr = dateFormat.format(new Date(timestamp.getTime()));
    return timestampStr;
  }

  public static String handleDateTimeStyle(String timeStr, String oldStyle, String newStyle) {
    Date date = null;
    try {
      date = handleTimeStrToTimestamp(timeStr, oldStyle);
    } catch (ParseException e) {
      logger.error(e);
    }
    return new SimpleDateFormat(newStyle).format(date);
  }

  public static final String[] months = { // // to be translated over
      // CommonMonthName, see example in
      // accounting
      "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
      "December" };

  public static final String[] days = { // to be translated over CommonDayName,
      // see example in accounting
      "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

  public static final String[][] timevals = { { "1000", "millisecond" }, { "60", "second" }, { "60", "minute" },
      { "24", "hour" }, { "7", "day" }, { "168", "week" } };

  public static final DecimalFormat df = new DecimalFormat("0.00;-0.00");
  /**
   * JDBC escape format for java.sql.Date conversions.
   */
  public static final String DATE_FORMAT = "yyyy-MM-dd";
  /**
   * JDBC escape format for Timestamp conversions.
   */

  /**
   * JDBC escape format for java.sql.Time conversions.
   */
  public static final String TIME_FORMAT = "HH:mm:ss";

  public static double getInterval(Date from, Date thru) {
    return thru != null ? thru.getTime() - from.getTime() : 0;
  }

  public static double getInterval(Timestamp from, Timestamp thru) {
    return thru != null ? thru.getTime() - from.getTime() : 0;
  }

  /**
   * Return a Timestamp for right now
   * 
   * @return Timestamp for right now
   */
  public static Timestamp nowTimestamp() {
    return getTimestamp(System.currentTimeMillis());
  }

  /**
   * Convert a millisecond value to a Timestamp.
   * 
   * @param time
   *          millsecond value
   * @return Timestamp
   */
  public static Timestamp getTimestamp(long time) {
    return new Timestamp(time);
  }

  /**
   * Convert a millisecond value to a Timestamp.
   * 
   * @param milliSecs
   *          millsecond value
   * @return Timestamp
   */
  public static Timestamp getTimestamp(String milliSecs) throws NumberFormatException {
    return new Timestamp(Long.parseLong(milliSecs));
  }

  /**
   * Returns currentTimeMillis as String
   * 
   * @return String(currentTimeMillis)
   */
  public static String nowAsString() {
    return Long.toString(System.currentTimeMillis());
  }

  /**
   * Return a string formatted as yyyyMMddHHmmss
   * 
   * @return String formatted for right now
   */
  public static String nowDateString() {
    return nowDateString("yyyyMMddHHmmss");
  }

  /**
   * Return a string formatted as format
   * 
   * @return String formatted for right now
   */
  public static String nowDateString(String format) {
    SimpleDateFormat df = new SimpleDateFormat(format);
    return df.format(new Date());
  }

  /**
   * Return a Date for right now
   * 
   * @return Date for right now
   */
  public static Date nowDate() {
    return new Date();
  }

  /**
   * Return the date for the first day of the year
   * 
   * @param stamp
   * @return Timestamp
   */
  public static Timestamp getYearStart(Timestamp stamp) {
    return getYearStart(stamp, 0, 0, 0);
  }

  public static Timestamp getYearStart(Timestamp stamp, int daysLater) {
    return getYearStart(stamp, daysLater, 0, 0);
  }

  public static Timestamp getYearStart(Timestamp stamp, int daysLater, int yearsLater) {
    return getYearStart(stamp, daysLater, 0, yearsLater);
  }

  public static Timestamp getYearStart(Timestamp stamp, Number daysLater, Number monthsLater, Number yearsLater) {
    return getYearStart(stamp, (daysLater == null ? 0 : daysLater.intValue()),
        (monthsLater == null ? 0 : monthsLater.intValue()), (yearsLater == null ? 0 : yearsLater.intValue()));
  }

  public static Calendar toCalendar(Timestamp stamp) {
    Calendar cal = Calendar.getInstance();
    if (stamp != null) {
      cal.setTimeInMillis(stamp.getTime());
    }
    return cal;
  }

  /**
   * Converts a date String into a java.sql.Date
   * 
   * @param date
   *          The date String: MM/DD/YYYY
   * @return A java.sql.Date made from the date String
   */
  public static java.sql.Date toSqlDate(String date) {
    Date newDate = toDate(date, "00:00:00");

    if (newDate != null) {
      return new java.sql.Date(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Makes a java.sql.Date from separate Strings for month, day, year
   * 
   * @param monthStr
   *          The month String
   * @param dayStr
   *          The day String
   * @param yearStr
   *          The year String
   * @return A java.sql.Date made from separate Strings for month, day, year
   */
  public static java.sql.Date toSqlDate(String monthStr, String dayStr, String yearStr) {
    Date newDate = toDate(monthStr, dayStr, yearStr, "0", "0", "0");

    if (newDate != null) {
      return new java.sql.Date(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Makes a java.sql.Date from separate ints for month, day, year
   * 
   * @param month
   *          The month int
   * @param day
   *          The day int
   * @param year
   *          The year int
   * @return A java.sql.Date made from separate ints for month, day, year
   */
  public static java.sql.Date toSqlDate(int month, int day, int year) {
    Date newDate = toDate(month, day, year, 0, 0, 0);

    if (newDate != null) {
      return new java.sql.Date(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Converts a time String into a java.sql.Time
   * 
   * @param time
   *          The time String: either HH:MM or HH:MM:SS
   * @return A java.sql.Time made from the time String
   */
  public static java.sql.Time toSqlTime(String time) {
    Date newDate = toDate("1/1/1970", time);

    if (newDate != null) {
      return new java.sql.Time(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Makes a java.sql.Time from separate Strings for hour, minute, and second.
   * 
   * @param hourStr
   *          The hour String
   * @param minuteStr
   *          The minute String
   * @param secondStr
   *          The second String
   * @return A java.sql.Time made from separate Strings for hour, minute, and second.
   */
  public static java.sql.Time toSqlTime(String hourStr, String minuteStr, String secondStr) {
    Date newDate = toDate("0", "0", "0", hourStr, minuteStr, secondStr);

    if (newDate != null) {
      return new java.sql.Time(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Makes a java.sql.Time from separate ints for hour, minute, and second.
   * 
   * @param hour
   *          The hour int
   * @param minute
   *          The minute int
   * @param second
   *          The second int
   * @return A java.sql.Time made from separate ints for hour, minute, and second.
   */
  public static java.sql.Time toSqlTime(int hour, int minute, int second) {
    Date newDate = toDate(0, 0, 0, hour, minute, second);

    if (newDate != null) {
      return new java.sql.Time(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Converts a date and time String into a Timestamp
   * 
   * @param dateTime
   *          A combined data and time string in the format "MM/DD/YYYY HH:MM:SS", the seconds are optional
   * @return The corresponding Timestamp
   */
  public static Timestamp toTimestamp(String dateTime) {
    Date newDate = toDate(dateTime);

    if (newDate != null) {
      return new Timestamp(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Converts a date String and a time String into a Timestamp
   * 
   * @param date
   *          The date String: MM/DD/YYYY
   * @param time
   *          The time String: either HH:MM or HH:MM:SS
   * @return A Timestamp made from the date and time Strings
   */
  public static Timestamp toTimestamp(String date, String time) {
    Date newDate = toDate(date, time);

    if (newDate != null) {
      return new Timestamp(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Makes a Timestamp from separate Strings for month, day, year, hour, minute, and second.
   * 
   * @param monthStr
   *          The month String
   * @param dayStr
   *          The day String
   * @param yearStr
   *          The year String
   * @param hourStr
   *          The hour String
   * @param minuteStr
   *          The minute String
   * @param secondStr
   *          The second String
   * @return A Timestamp made from separate Strings for month, day, year, hour, minute, and second.
   */
  public static Timestamp toTimestamp(String monthStr, String dayStr, String yearStr, String hourStr, String minuteStr,
      String secondStr) {
    Date newDate = toDate(monthStr, dayStr, yearStr, hourStr, minuteStr, secondStr);

    if (newDate != null) {
      return new Timestamp(newDate.getTime());
    } else {
      return null;
    }
  }

  /**
   * Makes a Timestamp from separate ints for month, day, year, hour, minute, and second.
   * 
   * @param month
   *          The month int
   * @param day
   *          The day int
   * @param year
   *          The year int
   * @param hour
   *          The hour int
   * @param minute
   *          The minute int
   * @param second
   *          The second int
   * @return A Timestamp made from separate ints for month, day, year, hour, minute, and second.
   */
  public static Timestamp toTimestamp(int month, int day, int year, int hour, int minute, int second) {
    Date newDate = toDate(month, day, year, hour, minute, second);

    if (newDate != null) {
      return new Timestamp(newDate.getTime());
    } else {
      return null;
    }
  }

  public static Timestamp toTimestamp(Date date) {
    if (date == null)
      return null;
    return new Timestamp(date.getTime());
  }

  /**
   * Converts a date and time String into a Date
   * 
   * @param dateTime
   *          A combined data and time string in the format "MM/DD/YYYY HH:MM:SS", the seconds are optional
   * @return The corresponding Date
   */
  public static Date toDate(String dateTime) {
    if (dateTime == null) {
      return null;
    }
    // dateTime must have one space between the date and time...
    String date = dateTime.substring(0, dateTime.indexOf(" "));
    String time = dateTime.substring(dateTime.indexOf(" ") + 1);

    return toDate(date, time);
  }

  /**
   * Converts a date String and a time String into a Date
   * 
   * @param date
   *          The date String: MM/DD/YYYY
   * @param time
   *          The time String: either HH:MM or HH:MM:SS
   * @return A Date made from the date and time Strings
   */
  public static Date toDate(String date, String time) {
    if (date == null || time == null)
      return null;
    String month;
    String day;
    String year;
    String hour;
    String minute;
    String second;

    int dateSlash1 = date.indexOf("/");
    int dateSlash2 = date.lastIndexOf("/");

    if (dateSlash1 <= 0 || dateSlash1 == dateSlash2)
      return null;
    int timeColon1 = time.indexOf(":");
    int timeColon2 = time.lastIndexOf(":");

    if (timeColon1 <= 0)
      return null;
    month = date.substring(0, dateSlash1);
    day = date.substring(dateSlash1 + 1, dateSlash2);
    year = date.substring(dateSlash2 + 1);
    hour = time.substring(0, timeColon1);

    if (timeColon1 == timeColon2) {
      minute = time.substring(timeColon1 + 1);
      second = "0";
    } else {
      minute = time.substring(timeColon1 + 1, timeColon2);
      second = time.substring(timeColon2 + 1);
    }

    return toDate(month, day, year, hour, minute, second);
  }

  /**
   * Makes a Date from separate Strings for month, day, year, hour, minute, and second.
   * 
   * @param monthStr
   *          The month String
   * @param dayStr
   *          The day String
   * @param yearStr
   *          The year String
   * @param hourStr
   *          The hour String
   * @param minuteStr
   *          The minute String
   * @param secondStr
   *          The second String
   * @return A Date made from separate Strings for month, day, year, hour, minute, and second.
   */
  public static Date toDate(String monthStr, String dayStr, String yearStr, String hourStr, String minuteStr,
      String secondStr) {
    int month, day, year, hour, minute, second;

    try {
      month = Integer.parseInt(monthStr);
      day = Integer.parseInt(dayStr);
      year = Integer.parseInt(yearStr);
      hour = Integer.parseInt(hourStr);
      minute = Integer.parseInt(minuteStr);
      second = Integer.parseInt(secondStr);
    } catch (Exception e) {
      return null;
    }
    return toDate(month, day, year, hour, minute, second);
  }

  /**
   * Makes a Date from separate ints for month, day, year, hour, minute, and second.
   * 
   * @param month
   *          The month int
   * @param day
   *          The day int
   * @param year
   *          The year int
   * @param hour
   *          The hour int
   * @param minute
   *          The minute int
   * @param second
   *          The second int
   * @return A Date made from separate ints for month, day, year, hour, minute, and second.
   */
  public static Date toDate(int month, int day, int year, int hour, int minute, int second) {
    Calendar calendar = Calendar.getInstance();

    try {
      calendar.set(year, month - 1, day, hour, minute, second);
      calendar.set(Calendar.MILLISECOND, 0);
    } catch (Exception e) {
      return null;
    }
    return new Date(calendar.getTime().getTime());
  }

  /**
   * Makes a date String in the given from a Date
   * 
   * @param date
   *          The Date
   * @return A date String in the given format
   */
  public static String toDateString(Date date, String format) {
    if (date == null)
      return "";
    SimpleDateFormat dateFormat = null;
    if (format != null) {
      dateFormat = new SimpleDateFormat(format);
    } else {
      dateFormat = new SimpleDateFormat();
    }

    Calendar calendar = Calendar.getInstance();

    calendar.setTime(date);
    return dateFormat.format(date);
  }

  /**
   * Makes a date String in the format MM/DD/YYYY from a Date
   * 
   * @param date
   *          The Date
   * @return A date String in the format MM/DD/YYYY
   */
  public static String toDateString(Date date) {
    return toDateString(date, "MM/dd/yyyy");
  }

  public static String toGmtTimestampString(Timestamp timestamp) {
    DateFormat df = DateFormat.getDateTimeInstance();
    df.setTimeZone(TimeZone.getTimeZone("GMT"));
    return df.format(timestamp);
  }

  /**
   * Makes a Timestamp for the beginning of the month
   * 
   * @return A Timestamp of the beginning of the month
   */
  public static Timestamp monthBegin() {
    Calendar mth = Calendar.getInstance();

    mth.set(Calendar.DAY_OF_MONTH, 1);
    mth.set(Calendar.HOUR_OF_DAY, 0);
    mth.set(Calendar.MINUTE, 0);
    mth.set(Calendar.SECOND, 0);
    mth.set(Calendar.MILLISECOND, 0);
    mth.set(Calendar.AM_PM, Calendar.AM);
    return new Timestamp(mth.getTime().getTime());
  }

  public static int weekNumber(Timestamp input, int startOfWeek) {
    Calendar calendar = Calendar.getInstance();
    calendar.setFirstDayOfWeek(startOfWeek);

    if (startOfWeek == Calendar.MONDAY) {
      calendar.setMinimalDaysInFirstWeek(4);
    } else if (startOfWeek == Calendar.SUNDAY) {
      calendar.setMinimalDaysInFirstWeek(3);
    }

    calendar.setTime(new Date(input.getTime()));
    return calendar.get(Calendar.WEEK_OF_YEAR);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds a number of years to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the Timestamp is null
   */
  public static Timestamp addYears(Timestamp stamp, int amount) {
    return add(stamp, Calendar.YEAR, amount);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds a number of months to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the Timestamp is null
   */
  public static Timestamp addMonths(Timestamp stamp, int amount) {
    return add(stamp, Calendar.MONTH, amount);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds a number of weeks to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the Timestamp is null
   */
  public static Timestamp addWeeks(Timestamp stamp, int amount) {
    return add(stamp, Calendar.WEEK_OF_YEAR, amount);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds a number of days to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the Timestamp is null
   */
  public static Timestamp addDays(Timestamp stamp, int amount) {
    return add(stamp, Calendar.DAY_OF_MONTH, amount);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds a number of hours to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the Timestamp is null
   */
  public static Timestamp addHours(Timestamp stamp, int amount) {
    return add(stamp, Calendar.HOUR_OF_DAY, amount);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds a number of minutes to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the stamp is null
   */
  public static Timestamp addMinutes(Timestamp stamp, int amount) {
    return add(stamp, Calendar.MINUTE, amount);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds a number of seconds to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the stamp is null
   */
  public static Timestamp addSeconds(Timestamp stamp, int amount) {
    return add(stamp, Calendar.SECOND, amount);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds a number of milliseconds to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the stamp is null
   */
  public static Timestamp addMilliseconds(Timestamp stamp, int amount) {
    return add(stamp, Calendar.MILLISECOND, amount);
  }

  // -----------------------------------------------------------------------
  /**
   * Adds to a Timestamp returning a new object. The original Timestamp object is unchanged.
   * 
   * @param stamp
   *          the Timestamp, not null
   * @param calendarField
   *          the calendar field to add to
   * @param amount
   *          the amount to add, may be negative
   * @return the new Timestamp object with the amount added
   * @throws IllegalArgumentException
   *           if the stamp is null
   */
  public static Timestamp add(Timestamp stamp, int calendarField, int amount) {
    if (stamp == null) {
      throw new IllegalArgumentException("The Timestamp must not be null");
    }
    Calendar c = Calendar.getInstance();
    c.setTimeInMillis(stamp.getTime());
    c.add(calendarField, amount);
    Timestamp retStamp = new Timestamp(c.getTime().getTime());
    return retStamp;
  }

  // ----- New methods that take a timezone and locale -- //

  /**
   * Returns a Calendar object initialized to the specified date/time, time zone, and locale.
   * 
   * @param stamp
   *          date/time to use
   * @param timeZone
   * @param locale
   * @return Calendar object
   * @see java.util.Calendar
   */
  public static Calendar toCalendar(Timestamp stamp, TimeZone timeZone, Locale locale) {
    Calendar cal = Calendar.getInstance(timeZone, locale);
    if (stamp != null) {
      cal.setTimeInMillis(stamp.getTime());
    }
    return cal;
  }

  /**
   * Perform date/time arithmetic on a Timestamp. This is the only accurate way to perform date/time arithmetic across
   * locales and time zones.
   * 
   * @param stamp
   *          date/time to perform arithmetic on
   * @param adjType
   *          the adjustment type to perform. Use one of the java.util.Calendar fields.
   * @param adjQuantity
   *          the adjustment quantity.
   * @param timeZone
   * @param locale
   * @return adjusted Timestamp
   * @see java.util.Calendar
   */
  public static Timestamp adjustTimestamp(Timestamp stamp, int adjType, int adjQuantity, TimeZone timeZone,
      Locale locale) {
    Calendar tempCal = toCalendar(stamp, timeZone, locale);
    tempCal.add(adjType, adjQuantity);
    return new Timestamp(tempCal.getTimeInMillis());
  }

  public static Timestamp adjustTimestamp(Timestamp stamp, Integer adjType, Integer adjQuantity) {
    Calendar tempCal = toCalendar(stamp);
    tempCal.add(adjType, adjQuantity);
    return new Timestamp(tempCal.getTimeInMillis());
  }

  public static Timestamp getDayStart(Timestamp stamp, TimeZone timeZone, Locale locale) {
    return getDayStart(stamp, 0, timeZone, locale);
  }

  public static Timestamp getDayStart(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
    Calendar tempCal = toCalendar(stamp, timeZone, locale);
    tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
    Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
    retStamp.setNanos(0);
    return retStamp;
  }

  public static Timestamp getDayEnd(Timestamp stamp, TimeZone timeZone, Locale locale) {
    return getDayEnd(stamp, 0, timeZone, locale);
  }

  public static Timestamp getDayEnd(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
    Calendar tempCal = toCalendar(stamp, timeZone, locale);
    tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 23, 59,
        59);
    tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
    Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
    retStamp.setNanos(999999999);
    return retStamp;
  }

  public static Timestamp getWeekStart(Timestamp stamp, TimeZone timeZone, Locale locale) {
    return getWeekStart(stamp, 0, 0, timeZone, locale);
  }

  public static Timestamp getWeekStart(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
    return getWeekStart(stamp, daysLater, 0, timeZone, locale);
  }

  public static Timestamp getWeekStart(Timestamp stamp, int daysLater, int weeksLater, TimeZone timeZone,
      Locale locale) {
    Calendar tempCal = toCalendar(stamp, timeZone, locale);
    tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
    tempCal.set(Calendar.DAY_OF_WEEK, tempCal.getFirstDayOfWeek());
    tempCal.add(Calendar.WEEK_OF_MONTH, weeksLater);
    Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
    retStamp.setNanos(0);
    return retStamp;
  }

  public static Timestamp getWeekEnd(Timestamp stamp, TimeZone timeZone, Locale locale) {
    Calendar tempCal = toCalendar(stamp, timeZone, locale);
    tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    tempCal.add(Calendar.WEEK_OF_MONTH, 1);
    tempCal.set(Calendar.DAY_OF_WEEK, tempCal.getFirstDayOfWeek());
    tempCal.add(Calendar.SECOND, -1);
    Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
    retStamp.setNanos(999999999);
    return retStamp;
  }

  public static Timestamp getMonthStart(Timestamp stamp, TimeZone timeZone, Locale locale) {
    return getMonthStart(stamp, 0, 0, timeZone, locale);
  }

  public static Timestamp getMonthStart(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
    return getMonthStart(stamp, daysLater, 0, timeZone, locale);
  }

  public static Timestamp getMonthStart(Timestamp stamp, int daysLater, int monthsLater, TimeZone timeZone,
      Locale locale) {
    Calendar tempCal = toCalendar(stamp, timeZone, locale);
    tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), 1, 0, 0, 0);
    tempCal.add(Calendar.MONTH, monthsLater);
    tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
    Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
    retStamp.setNanos(0);
    return retStamp;
  }

  public static Timestamp getYearStart(Timestamp stamp, TimeZone timeZone, Locale locale) {
    return getYearStart(stamp, 0, 0, 0, timeZone, locale);
  }

  public static Timestamp getYearStart(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
    return getYearStart(stamp, daysLater, 0, 0, timeZone, locale);
  }

  public static Timestamp getYearStart(Timestamp stamp, int daysLater, int yearsLater, TimeZone timeZone,
      Locale locale) {
    return getYearStart(stamp, daysLater, 0, yearsLater, timeZone, locale);
  }

  public static Timestamp getYearStart(Timestamp stamp, Number daysLater, Number monthsLater, Number yearsLater,
      TimeZone timeZone, Locale locale) {
    return getYearStart(stamp, (daysLater == null ? 0 : daysLater.intValue()),
        (monthsLater == null ? 0 : monthsLater.intValue()), (yearsLater == null ? 0 : yearsLater.intValue()), timeZone,
        locale);
  }

  public static Timestamp getYearStart(Timestamp stamp, int daysLater, int monthsLater, int yearsLater,
      TimeZone timeZone, Locale locale) {
    Calendar tempCal = toCalendar(stamp, timeZone, locale);
    tempCal.set(tempCal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
    tempCal.add(Calendar.YEAR, yearsLater);
    tempCal.add(Calendar.MONTH, monthsLater);
    tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
    Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
    retStamp.setNanos(0);
    return retStamp;
  }

  public static int weekNumber(Timestamp stamp, TimeZone timeZone, Locale locale) {
    Calendar tempCal = toCalendar(stamp, timeZone, locale);
    return tempCal.get(Calendar.WEEK_OF_YEAR);
  }

  /**
   * Returns a List of day name Strings - suitable for calendar headings.
   * 
   * @param locale
   * @return List of day name Strings
   */
  public static List<String> getDayNames(Locale locale) {
    Calendar tempCal = Calendar.getInstance(locale);
    tempCal.set(Calendar.DAY_OF_WEEK, tempCal.getFirstDayOfWeek());
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", locale);
    List<String> resultList = new ArrayList<String>();
    for (int i = 0; i < 7; i++) {
      resultList.add(dateFormat.format(tempCal.getTime()));
      tempCal.roll(Calendar.DAY_OF_WEEK, 1);
    }
    return resultList;
  }

  /**
   * Returns a List of month name Strings - suitable for calendar headings.
   * 
   * @param locale
   * @return List of month name Strings
   */
  public static List<String> getMonthNames(Locale locale) {
    Calendar tempCal = Calendar.getInstance(locale);
    tempCal.set(Calendar.MONTH, Calendar.JANUARY);
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM", locale);
    List<String> resultList = new ArrayList<String>();
    for (int i = Calendar.JANUARY; i <= tempCal.getActualMaximum(Calendar.MONTH); i++) {
      resultList.add(dateFormat.format(tempCal.getTime()));
      tempCal.roll(Calendar.MONTH, 1);
    }
    return resultList;
  }

  /**
   * Returns an initialized DateFormat object.
   * 
   * @param dateFormat
   *          optional format string
   * @param tz
   * @param locale
   *          can be null if dateFormat is not null
   * @return DateFormat object
   */
  public static DateFormat toDateFormat(String dateFormat, TimeZone tz, Locale locale) {
    DateFormat df = null;
    if (dateFormat == null) {
      df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    } else {
      df = new SimpleDateFormat(dateFormat);
    }
    df.setTimeZone(tz);
    return df;
  }

  /**
   * Returns an initialized DateFormat object.
   * 
   * @param dateTimeFormat
   *          optional format string
   * @param tz
   * @param locale
   *          can be null if dateTimeFormat is not null
   * @return DateFormat object
   */
  public static DateFormat toDateTimeFormat(String dateTimeFormat, TimeZone tz, Locale locale) {
    DateFormat df = null;
    if (dateTimeFormat == null) {
      df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, locale);
    } else {
      df = new SimpleDateFormat(dateTimeFormat);
    }
    df.setTimeZone(tz);
    return df;
  }

  /**
   * Returns an initialized DateFormat object.
   * 
   * @param timeFormat
   *          optional format string
   * @param tz
   * @param locale
   *          can be null if timeFormat is not null
   * @return DateFormat object
   */
  public static DateFormat toTimeFormat(String timeFormat, TimeZone tz, Locale locale) {
    DateFormat df = null;
    if (timeFormat == null) {
      df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
    } else {
      df = new SimpleDateFormat(timeFormat);
    }
    df.setTimeZone(tz);
    return df;
  }

  /**
   * Localized String to Timestamp conversion. To be used in tandem with timeStampToString().
   */
  public static Timestamp stringToTimeStamp(String dateTimeString, TimeZone tz, Locale locale) throws ParseException {
    return stringToTimeStamp(dateTimeString, null, tz, locale);
  }

  /**
   * Localized String to Timestamp conversion. To be used in tandem with timeStampToString().
   */
  public static Timestamp stringToTimeStamp(String dateTimeString, String dateTimeFormat, TimeZone tz, Locale locale)
      throws ParseException {
    DateFormat dateFormat = toDateTimeFormat(dateTimeFormat, tz, locale);
    Date parsedDate = dateFormat.parse(dateTimeString);
    return new Timestamp(parsedDate.getTime());
  }

  /**
   * Localized Timestamp to String conversion. To be used in tandem with stringToTimeStamp().
   */
  public static String timeStampToString(Timestamp stamp, TimeZone tz, Locale locale) {
    return timeStampToString(stamp, null, tz, locale);
  }

  /**
   * Localized Timestamp to String conversion. To be used in tandem with stringToTimeStamp().
   */
  public static String timeStampToString(Timestamp stamp, String dateTimeFormat, TimeZone tz, Locale locale) {
    DateFormat dateFormat = toDateTimeFormat(dateTimeFormat, tz, locale);
    dateFormat.setTimeZone(tz);
    return dateFormat.format(stamp);
  }

  /**
   * Returns a TimeZone object based upon an hour offset from GMT.
   * 
   * @see java.util.TimeZone
   */
  public static TimeZone toTimeZone(int gmtOffset) {
    if (gmtOffset > 12 || gmtOffset < -14) {
      throw new IllegalArgumentException("Invalid GMT offset");
    }
    String tzId = gmtOffset > 0 ? "Etc/GMT+" : "Etc/GMT";
    return TimeZone.getTimeZone(tzId + gmtOffset);
  }

  public static String addDateYear(String date, int scale) {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Calendar calendar = Calendar.getInstance();
    try {
      calendar.setTime(sf.parse(date));
    } catch (ParseException e) {
      logger.error(e);
    }
    calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + scale);// 让日期加1

    return sf.format(new Date(calendar.getTimeInMillis()));
  }

  public static int compareTwoDate(String date1, String date2) {
    Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();
    DateFormat df = new SimpleDateFormat(DATE_FOMRAT_yyyy_MM_dd_HH_MMss);

    try {
      calendar1.setTime(df.parse(date1));
      calendar2.setTime(df.parse(date2));
    } catch (ParseException e) {
      logger.error(e);
    }
    return calendar1.compareTo(calendar2);
  }

  public static int compareTwoDateInSysDate(String date1, String date2) {
    Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();
    Calendar calendar3 = Calendar.getInstance();
    DateFormat df = new SimpleDateFormat(DATE_FOMRAT_yyyy_MM_dd_HH_MMss);
    try {
      calendar1.setTime(df.parse(date1));
      calendar2.setTime(df.parse(date2));
      calendar3.getTime();
    } catch (ParseException e) {
      logger.error(e);
    }
    if (calendar3.compareTo(calendar1) < 0) {
      return 0;// 未生效
    } else if (calendar3.compareTo(calendar2) > 0) {
      return 1;// 已失效
    } else if (calendar3.compareTo(calendar1) >= 0 && calendar3.compareTo(calendar2) <= 0) {
      return 2;// 生效中
    }
    return 2;
  }

  public static int compareTwoDateInSysDate(Date date1, Date date2) {
    Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();
    Calendar calendar3 = Calendar.getInstance();
    try {
      calendar1.setTime(date1);
      calendar2.setTime(date2);
      calendar3.getTime();
    } catch (Exception e) {
      logger.error(e);
    }
    if (calendar3.compareTo(calendar1) < 0) {
      return 0;// 未生效
    } else if (calendar3.compareTo(calendar2) > 0) {
      return 1;// 已失效
    } else if (calendar3.compareTo(calendar1) >= 0 && calendar3.compareTo(calendar2) <= 0) {
      return 2;// 生效中
    }
    return 2;
  }

  /**
   * 对时限数据进行处理 1、运行时设置的date型数据直接返回 2、模型设置的需要特殊转换成date类型 3、运行时设置的转换为date型
   * 
   * @param args
   *          运行时参数
   * @param parameter
   *          模型参数
   * @return Date类型
   */
  public static Date processTime(Map<String, Object> args, String parameter) {
    if (StringUtil.isBlank(parameter))
      return null;
    Object data = args.get(parameter);
    if (data == null)
      data = parameter;

    Date result = null;
    if (data instanceof Date) {
      return (Date) data;
    } else if (data instanceof Long) {
      return new Date((Long) data);
    } else if (data instanceof String) {
      // TODO 1.4-dev ignore
    }
    return result;
  }
  

  public static Date rollDay(Date d, int day) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(d);
      cal.add(Calendar.DAY_OF_MONTH, day);
      return cal.getTime();
  }
  
  public static Date getTimeByHour(int hour) {
      Calendar calendar = Calendar.getInstance();
      calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
      return calendar.getTime();
  }

  public static String dateStryyyyMMdd(Date date) {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      String str = format.format(date);
      return str;
  }

  public static String dateStr2(Date date) {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String str = format.format(date);
      return str;
  }

  public static String dateStr3(Date date) {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String str = format.format(date);
      return str;
  }
  
  public static Date getDateYYYYMMddHHMMSS(String str) {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date = null;
      try {
          date = format.parse(str);
      } catch (ParseException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }

      return date;
  }

//获取本周的开始时间
  public static Date getBeginDayOfWeek() {
      Date date = new Date();
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
      if (dayofweek == 1) {
          dayofweek += 7;
      }
      cal.add(Calendar.DATE, 2 - dayofweek);
      return getDayStartTime(cal.getTime());
  }
  
  public static Date getBeginDayOfMonth() {
	            Calendar calendar = Calendar.getInstance();
	            calendar.set(getNowYear(), getNowMonth() - 1, 1);
	            return getDayStartTime(calendar.getTime());
	        }
  
  public static Integer getNowYear() {
	              Date date = new Date();
	             GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
	             gc.setTime(date);
	             return Integer.valueOf(gc.get(1));
}
//获取本月是哪一月
public static int getNowMonth() {
      Date date = new Date();
     GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
     gc.setTime(date);
     return gc.get(2) + 1;
 }

//获取某个日期的开始时间
public static Timestamp getDayStartTime(Date d) {
    Calendar calendar = Calendar.getInstance();
    if(null != d) calendar.setTime(d);
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return new Timestamp(calendar.getTimeInMillis());
}
}
