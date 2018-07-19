package com.zhongkexinli.micro.serv.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zhongkexinli.micro.serv.common.constant.CommonConstants;

/**
 * 
 * 内容摘要:处理数字类型共用类.
 */
public abstract class StringUtil {

  private static Log logger = LogFactory.getLog(StringUtil.class);
  
  public static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
  public static final String NUMBER_CHARS = "0123456789";

  public static boolean hasLength(CharSequence str) {
    return (str != null) && (str.length() > 0);
  }

  public static boolean hasLength(String str) {
    return hasLength(str);
  }

  /**
   * 是否包含文本
   * 
   * @param str
   *          字符
   * @return 是否包含文本
   */
  public static boolean hasText(CharSequence str) {
    if (!hasLength(str)) {
      return false;
    }
    int strLen = str.length();
    for (int i = 0; i < strLen; i++) {
      if (!Character.isWhitespace(str.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasText(String str) {
    return hasText(str);
  }

  /**
   * 字符串截取
   * 
   * @param str
   *          截取字符串
   * @param index
   *          截取开始位置
   * @param substring
   *          截取结束位置
   * @return 字符串截取结果
   */
  public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
    for (int j = 0; j < substring.length(); j++) {
      int i = index + j;
      if ((i >= str.length()) || (str.charAt(i) != substring.charAt(j))) {
        return false;
      }
    }
    return true;
  }

  /**
   * 
   * 方法描述：分钟转换为小时
   * 
   * @param minute
   *          分钟
   * @return 分钟转换为小时
   */
  public static String minute2Hour(String minute) {
    BigDecimal min = new BigDecimal(minute);
    return StringUtil.getRound(min, BigDecimal.valueOf(60), 2);
  }

  /**
   * 
   * 方法描述：四舍五入计算，scale为保留小数位数
   * 
   * @param dividend
   *          除数
   * @param divisor
   *          被除数
   * @param scale
   *          保留小数位数
   * @return 四舍五入计算
   */
  public static String getRound(BigDecimal dividend, BigDecimal divisor, int scale) {
    return dividend.divide(divisor, scale, BigDecimal.ROUND_HALF_UP).toString();
  }

  /**
   * 字符串转换成SQL日期
   * 
   * @param sDateStr
   *          转换字符串
   * @param sFormatStr
   *          日期格式
   * @return 字符串转换成SQL日期
   */
  public static java.sql.Date strTosqlDate(String sDateStr, String sFormatStr) {
    if (StringUtil.isBlank(sDateStr)) {
      return null;
    }
    Date rl;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(sFormatStr);
      rl = sdf.parse(sDateStr);
    } catch (ParseException e) {
      return null;
    }
    return new java.sql.Date(rl.getTime());

  }

  /**
   * 字符串补0.
   * 
   * @param sourceStr
   *          补齐的字符串
   * 
   * @param strLen
   *          长度
   * 
   * @return String 字符串补0
   */
  public static String zeroStrEx(String sourceStr, int strLen) {
    String s = sourceStr.trim();
    if (s.length() > strLen) {
      return sourceStr;
    } else {
      int l = strLen - s.length();
      for (int i = 0; i < l; i++) {
        s = "0" + s;
      }
      return s;
    }
  }

  /**
   * 
   * 方法描述：截取字符串前面的0
   * 
   * @param str
   *          截取字符串
   * @return 截取字符串前面的0
   */
  public static String subStringFrontZero(String str) {
    if (str == null || "".equals(str)) {
      return str;
    }
    char[] b = str.trim().toCharArray();
    if (b != null && b.length > 0) {
      for (int i = 0; i < b.length; i++) {
        if (b[i] == '0') {
          str = str.substring(1, str.length());
        } else {
          break;
        }
      }
    }
    return str;
  }

  /**
   * 产生随机数字.
   * 
   * @return String String
   */
  public static String dateRandom() {
    Date dt = new Date();
    long time = dt.getTime();
    String timeStr = String.valueOf(time);
    Random random = new Random();
    random.setSeed(999L);
    String randomStr = String.valueOf(Math.abs(random.nextInt()));
    return timeStr + randomStr;
  }

  /**
   * 根据字符长度，每行大小获去有多少行.
   * 
   * @param length
   *          字符长度
   * @param size
   *          每行大小
   * @return int 行数
   */
  public static int getRow(int length, int size) {
    int shang = 0;
    int yu = 0;
    shang = length / size;
    yu = length % size;
    if (yu > 0) {
      return shang + 1;
    } else {
      return shang;
    }
  }

  /**
   * 去除空格
   * 
   * @param str
   *          字符串
   * @return 去除空格
   */
  public static String trimBlank(String str) {
    return str == null ? "" : str.trim();
  }

  public static String toString(Object o) {
    return o == null ? "" : o.toString();
  }

  /**
   * 判断字符串非空
   */
  public static boolean isBlank(String str) {
    if (str != null && !str.trim().equals("")) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * 判断字符串数组空
   */
  public static boolean isBlank(String[] str) {
    if (str == null || str.length == 0) {
      return true;
    }
    return false;
  }

  /**
   * 判断字符串非空
   */
  public static boolean isNotBlank(String str) {
    if (str != null && !str.trim().equals("")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 判断字符串非空
   */
  public static boolean isNotBlank(String[] str) {
    if (str == null || str.length == 0) {
      return false;
    }
    return true;
  }

  /**
   * 判断对象是否为空
   * 
   * @param value
   *          字符串
   * @return 为空时返回true,否则返回false
   */
  public static boolean isNullObject(Object value) {
    return (value == null);
  }

  /**
   * 判断对象是否为空
   * 
   * @param value
   *          字符串
   * @return 为空时返回true,否则返回false
   */
  public static boolean isNotNullObject(Object value) {
    return (value != null);
  }

  /**
   * 判断字符串是否为空
   * 
   * @param value
   *          字符串
   * @return 为空时返回true,否则返回false
   */
  public static boolean isNull(String value) {
    return (value == null || value.trim().equals(""));
  }

  /**
   * 判断字符串是否非空
   * 
   * @param value
   *          字符串
   * @return 非空返回true,否则返回false
   */
  public static boolean isNotNull(String value) {
    return (value != null && !value.trim().equals(""));
  }

  /**
   * 区分大小写判断两个字符串是否相等
   * 
   * @param value
   *          原字符串
   * @param compareValue
   *          被比较字符串
   * @return 相等返回true,否则返回false
   */
  public static boolean isEqual(String value, String compareValue) {
    return (value != null && value.equals(compareValue));
  }

  /**
   * 不区分大小写判断两个字符串是否相等
   * 
   * @param value
   *          原字符串
   * @param compareValue
   *          被比较字符串
   * @return 相等返回true,否则返回false
   */
  public static boolean isEqualsIgnoreCase(String value, String compareValue) {
    return (value != null && value.equalsIgnoreCase(compareValue));
  }

  /**
   * 判断字符串是否等于Y，不区分大小写
   * 
   * @param value
   *          被比较字符串
   * @return 等于y，返回true,否则false
   */
  public static boolean isEqualsY(String value) {
    return isEqualsIgnoreCase(value, "y");
  }

  /**
   * 判断字符串是否等于true，不区分大小写
   * 
   * @param value
   *          被比较字符串
   * @return 等于true，返回true,否则false
   */
  public static boolean isEqualsTrue(String value) {
    return isEqualsIgnoreCase(value, "true");
  }

  /**
   * 
   * 方法描述：判断是否是int类型
   * 
   * @param str
   *          字符串
   * @return boolean 是否
   */
  public static boolean isInt(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  /**
   * 判断是否是邮箱
   * 
   * @param email
   *          邮箱号码
   * @return boolean 是否
   */
  public static boolean verifyEmail(String email) {
    if (email == null || "".equals(email)) {
      return true;
    }
    boolean tag = true;
    final String pattern1 = "^.+@.+\\..+$";
    final Pattern pattern = Pattern.compile(pattern1);
    final Matcher mat = pattern.matcher(email);
    if (!mat.find()) {
      tag = false;
    }
    return tag;
  }

  /**
   * 判断是否是日期
   * 
   * @param s
   *          日期字符串
   * @param format
   *          日期格式
   * @return boolean 是否
   */
  public static boolean isDate(String s, String format) {
    try {
      SimpleDateFormat fmt = new SimpleDateFormat(format);
      fmt.parse(s);
    } catch (ParseException e) {
      return false;
    }
    return true;
  }

  /**
   * 判断是否是数字
   * 
   * @param s
   *          字符串
   * @return boolean 是否
   */
  public static boolean isNumber(String s) {
    if (s == null || "".equals(s)) {
      return false;
    }
    try {
      Long.valueOf(s);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * 验证身份证号的格式
   * 
   * @param idCardNo
   *          身份证号码
   * @return boolean 是否
   */
  public static boolean verifyIdCardNo(String idCardNo) {
    if (StringUtil.isBlank(idCardNo)) {
      return false;
    } else {
      String idcard = "^\\d{15}(\\d{2}[0-9xX])?$";
      Pattern pattern = Pattern.compile(idcard);
      return pattern.matcher(idCardNo).matches();
    }
  }

  /**
   * 检验手机号格式是否正确
   * 
   * @param mobile
   *          手机号码
   * @return boolean 是否
   */
  public static boolean verifyMobile(String mobile) {
    if (StringUtil.isBlank(mobile) || mobile.length() != 11) {
      return false;
    } else if (!isNumber(mobile)) {
      return false;
    } else {
      boolean tag = true;
      final String pattern1 = "^(((1[3-9][0-9]{1}))+\\d{8})$";
      final Pattern pattern = Pattern.compile(pattern1);
      final Matcher mat = pattern.matcher(mobile);
      if (!mat.find()) {
        tag = false;
      }
      return tag;
    }
  }

  /**
   * 小写转换大写
   * 
   * @param string
   *          字符串
   * @return 小写转换大写
   */
  public static String toUpper(String string) {
    if (isNotBlank(string)) {
      return string.toUpperCase();
    }
    return string;
  }

  /**
   * 获取uuid类型的字符串
   * 
   * @return uuid字符串
   */
  public static String getUuidKey() {
    return java.util.UUID.randomUUID().toString().replace("-", "");
  }

  /**
   * 随机获取UUID字符串(无中划线)
   *
   * @return UUID字符串
   */
  public static String getUuid() {
    String uuid = UUID.randomUUID().toString();
    return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23)
        + uuid.substring(24);
  }

  /**
   * 随机获取字符串
   * 
   * @param length
   *          随机字符串长度
   * 
   * @return 随机字符串
   */
  public static String getRandomString(int length) {
    if (length <= 0) {
      return "";
    }
    char[] randomChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o',
        'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int r = random.nextInt();
      if (r < 0) {
        continue;
      }
      stringBuilder.append(randomChar[Math.abs(r) % randomChar.length]);
    }
    return stringBuilder.toString();
  }

  /**
   * 根据指定长度 分隔字符串
   * 
   * @param str
   *          需要处理的字符串
   * @param length
   *          分隔长度
   * 
   * @return 字符串集合
   */
  public static List<String> splitString(String str, int length) {
    List<String> list = new ArrayList<String>();
    for (int i = 0; i < str.length(); i += length) {
      int endIndex = i + length;
      if (endIndex <= str.length()) {
        list.add(str.substring(i, i + length));
      } else {
        list.add(str.substring(i, str.length() - 1));
      }
    }
    return list;
  }

  /**
   * 将字符串List转化为字符串，以分隔符间隔.
   * 
   * @param list
   *          需要处理的List.
   * 
   * @param separator
   *          分隔符.
   * 
   * @return 转化后的字符串
   */
  public static String toString(List<String> list, String separator) {
    StringBuilder StringBuilder = new StringBuilder();
    for (String str : list) {
      StringBuilder.append(separator + str);
    }
    StringBuilder.deleteCharAt(0);
    return StringBuilder.toString();
  }

  /**
   * 转换成list数组
   * 
   * @param str
   *          字符串
   * @return 转换成list数组
   */
  public static List<String> splitStringToStringList(String str) {
    str = trimBlank(str);
    String[] strArray = str.split(",");

    List<String> strList = new ArrayList<String>();
    for (String strObj : strArray) {
      strList.add(strObj);
    }
    return strList;
  }

  /**
   * 将数组键转为为字符串,以分隔符分割开来,分割后的字符串不加单引号
   * 
   * @param array
   *          数组
   * @param splitStr
   *          分割字符串
   * @return 将数组键转为为字符串,以分隔符分割开来,分割后的字符串不加单引号
   */
  public static String convertArrayToSplitString(Object[] array, String splitStr) {
    String toString = "";
    for (int i = 0; i < array.length; i++) {
      if (i > 0) {
        toString += splitStr;
      }
      toString += array[i].toString();
    }
    return toString;
  }

  /**
   * 将数组键转为为字符串,以分隔符分割开来,分割后的字符串加单引号
   * 
   * @param array
   *          数组
   * @param splitStr
   *          分割字符串
   * @return 将数组键转为为字符串,以分隔符分割开来,分割后的字符串加单引号
   */
  public static String convertArrayToSplitString2(Object[] array, String splitStr) {
    String toString = "";
    for (int i = 0; i < array.length; i++) {
      if (i > 0) {
        toString += splitStr;
      }
      toString += "'" + array[i].toString() + "'";
    }
    return toString;
  }

  /**
   * 将字符串分割为字符串数组
   * 
   * assertEquals("b",StringUtil.stringToArray("a,b,c", ",")[1]); assertEquals("c",StringUtil.stringToArray("a,b,c",
   * ",")[2]);
   * 
   * assertEquals("a",StringUtil.stringToArray(",a,b,c", ",")[0]); assertEquals("b",StringUtil.stringToArray(",a,b,c",
   * ",")[1]); assertEquals("c",StringUtil.stringToArray(",a,b,c", ",")[2]);
   * 
   * @param str
   *          字符串
   * @param separators
   *          分割符
   * @return 将字符串分割为字符串数组
   */
  public static final String[] stringToArray(String str, String separators) {
    StringTokenizer tokenizer;
    String[] array = null;
    int count = 0;
    if (str == null) {
      return array;
    }
    if (separators == null) {
      separators = ",";
    }
    tokenizer = new StringTokenizer(str, separators);
    if ((count = tokenizer.countTokens()) <= 0) {
      return array;
    }
    array = new String[count];
    int ix = 0;
    while (tokenizer.hasMoreTokens()) {
      array[ix] = tokenizer.nextToken();
      ix++;
    }
    return array;
  }

  /**
   * 获得字符串数组的字符形式
   * 
   * @param values
   *          字符串数组
   * @return 获得字符串数组的字符形式
   */
  public static String getStringByArray(String[] values) {
    StringBuilder valueStr = new StringBuilder();
    if (StringUtil.isNotBlank(values)) {
      for (int i = 0; i < values.length; i++) {
        valueStr.append(values[i]);
      }
    }
    return valueStr.toString();
  }

  /**
   * 将字符串转换为 int.
   * 
   * @param input
   *          输入的字串
   * 
   * @param defaultInt
   *          默认值
   * 
   * @return 结果数字
   */
  public static int parseInt(Object input, int defaultInt) {

    try {
      if (StringUtil.isNotNullObject(input)) {
        return Integer.parseInt(input.toString());
      }
    } catch (Exception e) {
      logger.error(e);
    }
    return defaultInt;
  }

  /**
   * 将字符串转换为 float.
   * 
   * @param input
   *          输入的字串
   * 
   * @return 结果数字
   */
  public static float parseFloat(Object input, float defaultFloat) {
    try {
      if (StringUtil.isNotNullObject(input)) {
        return Float.parseFloat(input.toString());
      }
    } catch (Exception ex) {
      logger.error(ex);
    }
    return defaultFloat;
  }

  /**
   * 转换由表单读取的数据的内码(从 ISO8859 转换到 UTF-8).
   * 
   * @param input
   *          输入的字符串
   * @return 转换结果, 如果有错误发生, 则返回原来的值
   * 
   */
  public static String toChi(String input) {
    try {
      byte[] bytes = input.getBytes("ISO8859-1");
      return new String(bytes, CommonConstants.ENCODING_UTF_8);
    } catch (Exception ex) {
      logger.error(ex);
    }
    return input;
  }

  /**
   * 转换由表单读取的数据的内码到 ISO(从 UTF-8 转换到ISO8859-1).
   * 
   * @param input
   *          输入的字符串
   * @return 转换结果, 如果有错误发生, 则返回原来的值
   * 
   */
  public static String toIso(String input) {
    return changeEncoding(input, CommonConstants.ENCODING_UTF_8, "ISO8859-1");
  }

  /**
   * 转换字符串的内码.
   * 
   * @param input
   *          输入的字符串
   * @param sourceEncoding
   *          源字符集名称
   * @param targetEncoding
   *          目标字符集名称
   * 
   * @return 转换结果, 如果有错误发生, 则返回原来的值
   * 
   */
  public static String changeEncoding(String input, String sourceEncoding, String targetEncoding) {
    if (StringUtil.isBlank(input)) {
      return input;
    }

    try {
      byte[] bytes = input.getBytes(sourceEncoding);
      return new String(bytes, targetEncoding);
    } catch (Exception ex) {
      logger.error(ex);
    }
    return input;
  }

  /**
   * 将字符串 source 中的 oldStr 替换为 newStr, 并以大小写敏感方式进行查找
   * 
   * 
   * @param source
   *          需要替换的源字符串
   * @param oldStr
   *          需要被替换的老字符串
   * @param newStr
   *          替换为的新字符串
   */
  public static String replace(String source, String oldStr, String newStr) {
    return replace(source, oldStr, newStr, true);
  }

  /**
   * 将字符串 source 中的 oldStr 替换为 newStr, matchCase 为是否设置大小写敏感查找
   * 
   * @param source
   *          需要替换的源字符串
   * @param oldStr
   *          需要被替换的老字符串
   * @param newStr
   *          替换为的新字符串
   * @param matchCase
   *          是否需要按照大小写敏感方式查找
   */
  public static String replace(String source, String oldStr, String newStr, boolean matchCase) {
    if (source == null) {
      return null;
    }
    // 首先检查旧字符串是否存在, 不存在就不进行替换

    if (source.toLowerCase().indexOf(oldStr.toLowerCase()) == -1) {
      return source;
    }
    int findStartPos = 0;
    int a = 0;
    while (a > -1) {
      int b = 0;
      String str1;
      String str2;
      String str3;
      String str4;
      String strA;
      String strB;
      str1 = source;
      str2 = str1.toLowerCase();
      str3 = oldStr;
      str4 = str3.toLowerCase();
      if (matchCase) {
        strA = str1;
        strB = str3;
      } else {
        strA = str2;
        strB = str4;
      }
      a = strA.indexOf(strB, findStartPos);
      if (a > -1) {
        b = oldStr.length();
        findStartPos = a + b;
        StringBuilder bbuf = new StringBuilder(source);
        source = bbuf.replace(a, a + b, newStr) + "";
        // 新的查找开始点位于替换后的字符串的结尾
        findStartPos = findStartPos + newStr.length() - b;
      }
    }
    return source;
  }

  /**
   * 得到文件的扩展名.
   * 
   * @param fileName
   *          需要处理的文件的名字.
   * @return the extension portion of the file's name.
   */
  public static String getExtension(String fileName) {
    if (fileName != null) {
      int i = fileName.lastIndexOf('.');
      if (i > 0 && i < fileName.length() - 1) {
        return fileName.substring(i + 1).toLowerCase();
      }
    }
    return "";
  }

  /**
   * 得到文件的前缀名.
   * 
   * @param fileName
   *          需要处理的文件的名字.
   * @return the prefix portion of the file's name.
   */
  public static String getPrefix(String fileName) {
    if (fileName != null) {
      fileName = fileName.replace('\\', '/');

      if (fileName.lastIndexOf("/") > 0) {
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
      }

      int i = fileName.lastIndexOf('.');
      if (i > 0 && i < fileName.length() - 1) {
        return fileName.substring(0, i);
      }
    }
    return "";
  }

  /**
   * 得到文件的短路径, 不保护目录.
   * 
   * @param fileName
   *          需要处理的文件的名字.
   * @return the short version of the file's name.
   */
  public static String getShortFileName(String fileName) {
    if (fileName != null) {
      String oldFileName = new String(fileName);

      fileName = fileName.replace('\\', '/');

      // Handle dir
      if (fileName.endsWith("/")) {
        int idx = fileName.indexOf('/');
        if (idx == -1 || idx == fileName.length() - 1) {
          return oldFileName;
        } else {
          return oldFileName.substring(idx + 1, fileName.length() - 1);
        }

      }
      if (fileName.lastIndexOf("/") > 0) {
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
      }

      return fileName;
    }
    return "";
  }

  /**
   * 
   * @功能描述：将list中的字符串组合成以str为分隔符的形式，例如xxx,fsd,erwr
   * @param list
   *          字符串集合
   * 
   * @param str
   *          要分隔的符号
   * @return xxx,fsd,erwr形式的字符串
   */
  public static String getStrSplitWithChar(List<String> list, String str) {
    String result = "";
    if (list == null) {
      return result;
    }
    for (int i = 0; i < list.size(); i++) {
      result += list.get(i) + str;
    }
    if (result.endsWith(str)) {
      int pos = result.lastIndexOf(str);
      if (pos > -1) {
        result = result.substring(0, pos);
      }
    }
    return result;
  }

  /**
   * 将list元素转换成“col1,col2”形式
   * 
   * @return 将list元素转换成“col1,col2”形式
   */
  public static String arrayToString(List<String> s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.size(); i++) {
      if (i != s.size() - 1) {
        sb.append("'" + s.get(i) + "',");
      } else {
        sb.append("'" + s.get(i) + "'");
      }
    }
    return sb.toString();
  }

  /**
   * 将list元素转换成“col1,col2”形式，剔除空串的情况
   * 
   * @return 将list元素转换成“col1,col2”形式，剔除空串的情况
   */
  public static String arrayToString2(List<String> s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.size(); i++) {
      if (s.get(i).equals("")) {
        continue;
      }
      if (i != s.size() - 1) {
        sb.append("'" + s.get(i) + "',");
      } else {
        sb.append("'" + s.get(i) + "'");
      }
    }
    return sb.toString();
  }

  /**
   * 功能描述：清除字符串中所有的空格
   * 
   * @param srcStr 字符串
   * @return 清除字符串中所有的空格
   */
  public static String clearSpace(String srcStr) {
    if (srcStr == null) {
      return "";
    }
    Pattern p = Pattern.compile("\\s*|\t|\r|\n");
    Matcher m = p.matcher(srcStr);
    String after = m.replaceAll("");
    return after;

  }

  /**
   * 功能描述：清楚回车换行
   * 
   * @param srcStr 字符串
   * @return 清楚回车换行
   */
  public static String clearWrap(String srcStr) {
    if (srcStr == null) {
      return "";
    }
    Pattern p = Pattern.compile("\\t|\r|\n");
    Matcher m = p.matcher(srcStr);
    String after = m.replaceAll("");
    return after;
  }

  public static String replaceHtmlEdit(String inputStr) {
    return clearSpace(inputStr.replace("\"", "\\\""));
  }

  /**
   * 判断字符串是否为浮点型
   * 
   * @param  str 要判断的字符串
   * 
   * @return true 浮点型,false 非浮点型
   */
  public static boolean isDecimal(String str) {
    if (str == null || "".equals(str))  {
      return false;
    }
    Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
    return pattern.matcher(str).matches();
  }

  /**
   * 查找字符串数组中是否有匹配值
   * 
   * @param  array 字符串数组
   * @param  str 要匹配的值
   * @return 是否存在匹配值
   * 
   */
  public static boolean findMatchArray(String[] array, String str) {
    boolean isMatch = false;
    for (int i = 0; i < array.length; i++) {
      if (str.equals(array[i])) {
        isMatch = true;
      }
    }
    return isMatch;
  }

  /**
   * 生成随机整数
   * @param n 位数
   * @return 生成随机整数
   */
  public static int randomInt(int n) {
    BigDecimal random = BigDecimal.valueOf(Math.random() * n);
    random = random.setScale(0, BigDecimal.ROUND_HALF_UP);
    return random.intValue();
  }

  /**
   * 根据给定的字符串种子，产生随机n位字符串
   * 
   * @param seed
   *          种子
   * @param n
   *          产生的字符串长度
   * @return 根据给定的字符串种子，产生随机n位字符串
   */
  public static String generateRandomChars(String seed, int n) {
    StringBuilder radomChars = new StringBuilder();
    BigDecimal random = null;
    for (int i = 0; i < n; i++) {
      random = BigDecimal.valueOf(Math.random() * (seed.length() - 1));
      random = random.setScale(0, BigDecimal.ROUND_HALF_UP);
      radomChars.append(seed.charAt(random.intValue()));
    }
    return radomChars.toString();
  }

  /**
   * 对指定字符串随机重新排序
   * 
   * @param oldStr 字符串
   * @return 对指定字符串随机重新排序
   */
  public static String randomOrder(String oldStr) {
    StringBuilder newStr = new StringBuilder();
    String theChar = "";

    StringBuilder sb = new StringBuilder(oldStr);

    for (int j = 0; j < oldStr.length(); j++) {
      theChar = generateRandomChars(sb.toString(), 1);
      sb.deleteCharAt(sb.indexOf(theChar));
      newStr.append(theChar);
    }

    return newStr.toString();
  }

  public static List randomOrder(List list) {
    Object temp = null;
    int idx = 0;
    for (int i = 0; i < list.size(); i++) {
      idx = StringUtil.randomInt(list.size() - 1);
      temp = list.get(idx);
      list.remove(idx);
      list.add(temp);
    }
    return list;
  }

  public static String generateRandomLowercase(int n) {
    return generateRandomChars(LOWERCASE_CHARS, n);
  }

  public static String generateRandomUppercase(int n) {
    return generateRandomChars(UPPERCASE_CHARS, n);
  }

  public static String generateRandomNumber(int n) {
    return generateRandomChars(NUMBER_CHARS, n);
  }

  /**
   * 显示实体类的属性和方法
   * 
   * @param o 对象
   * @return 显示实体类的属性和方法
   */
  public static String props(Object o) {
    String toString = "";
    Class cls = o.getClass();
    String className = "";
    className = cls.getName();
    toString = "**** " + className + " attribute list begin **\r\n";
    while (cls != null) {
      Method[] mth = cls.getDeclaredMethods();
      Field[] fd = cls.getDeclaredFields();
      try {
        for (int i = 0; i < mth.length; i++) {
          String str = mth[i].getName();
          if (str.startsWith("g")) {
            for (int k = 0; k < fd.length; k++) {
              String st = fd[k].getName();
              if (str.toLowerCase().indexOf(st.toLowerCase()) > 0) {
                toString = toString + st + "===" + mth[i].invoke(o, null) + "\r\n";
              }
            }
          }
        }
      } catch (Exception ex) {
        logger.error(ex);
      }
      cls = cls.getSuperclass();
    }
    toString = toString + "** " + className + " attribute list end *****\r\n";
    return toString;
  }

  /**
   * 字节转化成字符串
   * @param b 字节
   * @return  字节转化成字符串
   */
  public static String byteToString(byte []b) {
    if (b == null || b.length == 0) {
      return "";
    }
    try {
      String flowContentStr = new String(b, "UTF-8");
      return flowContentStr;
    } catch (Exception e) {
      logger.error(e);
    }
    return "";
  }

  /**
   * 对象转数组
   * 
   * @param obj 对象
   * @return 对象转数组
   */
  public static byte[] object2Byte(Object obj) {
    byte[] bytes = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
      ObjectOutputStream oos = new ObjectOutputStream(bos);
      oos.writeObject(obj);
      oos.flush();
      bytes = bos.toByteArray();
      oos.close();
      bos.close();
    } catch (IOException ex) {
      logger.error(ex);
    }
    return bytes;
  }

  /**
   * 数组转对象
   * 
   * @param bytes 字节
   * @return  数组转对象
   */
  public static Object byte2Object(byte[] bytes) {
    Object obj = null;
    try {
      ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
      ObjectInputStream ois = new ObjectInputStream(bis);
      obj = ois.readObject();
      ois.close();
      bis.close();
    } catch (IOException ex) {
      logger.error(ex);
    } catch (ClassNotFoundException ex) {
      logger.error(ex);
    }
    return obj;
  }
  
  /**
   * 将字符串 source 中的 oldStr 替换为 newStr, 并以大小写敏感方式进行查找
   * 
   * 
   * @param source
   *          需要替换的源字符串
   * @param oldStr
   *          需要被替换的老字符串
   * @param newStr
   *          替换为的新字符串
   */
  public static String replaceStr(String source, String strArray[], String newStr) {
	  String result = "";
	  
	  	for(String str: strArray){
	  		if(source.indexOf(str)!=-1){
	  			result=result +source.replaceFirst(str, newStr);
	  		}
	  	}
	  
	  return result;
  }
  
  
}
