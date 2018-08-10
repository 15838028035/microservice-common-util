package com.zhongkexinli.micro.serv.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
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

public  class DateUtil {

  private DateUtil () {
    // null 
  }
  
  private static Log logger = LogFactory.getLog(DateUtil.class);
  public static final String DATE_FORMAT_STYLE1 = "HH:mm:ss";
  public static final String DATE_FORMAT_STYLE2 = "hh:mm:ss";
  public static final String DATE_FORMAT_STYLE3 = "yyyy-MM-dd";
  public static final String DATE_FORMAT_STYLE4 = "yyyyMMdd";
  public static final String DATE_FORMAT_STYLE5 = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_FORMAT_STYLE6 = "yyyyMMdd hh:mm:ss";
  

  public static final String getNowDateYYYYMMddHHMMSS() {
    return getNowDate(DATE_FORMAT_STYLE5);
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
    return sd.format(new Date(System.currentTimeMillis()));
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
      logger.error(e);

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

    Date fDate = formatDate(fDateStr, DATE_FORMAT_STYLE5);
    Date oDate = formatDate(oDateStr, DATE_FORMAT_STYLE5);
    
    if (null == fDate || null == oDate ) {
        return -1;
      }

    long intervalMilli = fDate.getTime() - oDate.getTime();
    return (int) (intervalMilli / (24 * 60 * 60 * 1000));
  }

  public static String toTimeStr(String time) {
    if (time == null)
      return null;
    return  time.substring(0, time.indexOf('+'));
  }

  public static String toDateStr(String date) {
    if (date == null)
      return null;
    String month;
    String day;
    String year;

    int dateSlash1 = date.indexOf('-');
    int dateSlash2 = date.lastIndexOf('-');

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
    return  dateFormat.parse(timeStr);
  }

  public static Timestamp handleTimeStrToTimestamp(String timeStr, String style) throws ParseException {
    if (timeStr == null || timeStr.trim().equals(""))
      return null;

    SimpleDateFormat dateFormat = new SimpleDateFormat(style);
    Date date = dateFormat.parse(timeStr);
    return  new Timestamp(date.getTime());
  }

  public static String handleTimestampToTimeStr(Timestamp timestamp, String style) {
    if (timestamp == null)
      return null;

    SimpleDateFormat dateFormat = new SimpleDateFormat(style);
   return  dateFormat.format(new Date(timestamp.getTime()));
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
  
  /**
   * JDBC escape format for Timestamp conversions.
   */

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
   * Makes a date String in the given from a Date
   * 
   * @param date
   *          The Date
   * @return A date String in the given format
   */
  public static String toDateString(Date date, String format) {
    if (date == null) {
      return "";
    }
    DateFormat dateFormat = new SimpleDateFormat();
    if (format != null) {
      dateFormat = new SimpleDateFormat(format);
    }
    
    Calendar calendar = Calendar.getInstance();

    calendar.setTime(date);
    return dateFormat.format(date);
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
    List<String> resultList = new ArrayList<>();
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
    List<String> resultList = new ArrayList<>();
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
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    if (dateFormat != null) {
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
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, locale);
    if (dateTimeFormat != null) {
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
    DateFormat df =  new SimpleDateFormat(timeFormat);
    if (timeFormat == null) {
      df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
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

  public static String addDateYear(String date, int scale) {
    SimpleDateFormat sf = new SimpleDateFormat(DATE_FORMAT_STYLE5);

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
    DateFormat df = new SimpleDateFormat(DATE_FORMAT_STYLE5);

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
    DateFormat df = new SimpleDateFormat(DATE_FORMAT_STYLE5);
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
      SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STYLE3);
      String str = format.format(date);
      return str;
  }

  public static String dateStr2(Date date) {
      SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STYLE5);
      String str = format.format(date);
      return str;
  }

  public static String dateStr3(Date date) {
      SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STYLE5);
      String str = format.format(date);
      return str;
  }
  
  public static Date getDateYYYYMMddHHMMSS(String str) {
      SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STYLE5);
      Date date = null;
      try {
          date = format.parse(str);
      } catch (ParseException e) {
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
    if(null != d) {
      calendar.setTime(d);
    }
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return new Timestamp(calendar.getTimeInMillis());
}

}
