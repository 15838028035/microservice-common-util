package com.zhongkexinli.micro.serv.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.zhongkexinli.micro.serv.common.base.entity.BaseEntity;

/**
 * 
 * 字符串测试工具类
 *
 */
public class StringUtilTest {

    private static Log logger = LogFactory.getLog(StringUtilTest.class);
    private String testStrABC = "a,b,c";
    private String testStrABC2 = ",a,b,c";

    @Test
    public void minute2HourTest() {
        assertEquals("0.00", StringUtil.minute2Hour("0"));
        assertEquals("0.25", StringUtil.minute2Hour("15"));
        assertEquals("0.50", StringUtil.minute2Hour("30"));
        assertEquals("0.75", StringUtil.minute2Hour("45"));
        assertEquals("1.00", StringUtil.minute2Hour("60"));
        assertEquals("2.00", StringUtil.minute2Hour("120"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void strTosqlDateTest() {
        assertNull(StringUtil.strTosqlDate(null, DateUtil.DATE_FORMAT_STYLE3));
        assertNull(StringUtil.strTosqlDate("", DateUtil.DATE_FORMAT_STYLE3));

        assertNotNull(StringUtil.strTosqlDate("2016-06-11", DateUtil.DATE_FORMAT_STYLE3));
        assertNotNull(StringUtil.strTosqlDate("2016-06-11 10:00:00", DateUtil.DATE_FORMAT_STYLE5));

        assertNull(StringUtil.strTosqlDate("2016-06-12", "bad format date "));
        assertNull(StringUtil.strTosqlDate("bad date style", DateUtil.DATE_FORMAT_STYLE3));
    }

    @Test
    public void zeroStrExTest() {
        assertEquals("00001", StringUtil.zeroStrEx("1", 5));
        assertEquals("00002", StringUtil.zeroStrEx("2", 5));
        assertEquals("00010", StringUtil.zeroStrEx("10", 5));
        assertEquals("00100", StringUtil.zeroStrEx("100", 5));
        assertEquals("01000", StringUtil.zeroStrEx("1000", 5));
        assertEquals("10000", StringUtil.zeroStrEx("10000", 5));
        assertEquals("10000", StringUtil.zeroStrEx("10000", 4));
    }

    @Test
    public void subStringFrontZeroTest() {
        assertNull(StringUtil.subStringFrontZero(null));
        assertEquals("", StringUtil.subStringFrontZero(""));
        assertEquals("12301000", StringUtil.subStringFrontZero("12301000"));
        assertEquals("123456", StringUtil.subStringFrontZero("123456"));
    }

    @Test
    public void getRowTest() {
        assertTrue(StringUtil.getRow(10, 5) == 2);
        assertTrue(StringUtil.getRow(10, 10) == 1);
        assertTrue(StringUtil.getRow(10, 3) == 4);
    }

    @Test
    public void trimBlankTest() {
        assertEquals("", StringUtil.trimBlank(null));
        assertEquals("", StringUtil.trimBlank(""));
        assertEquals("", StringUtil.trimBlank(" "));
        assertEquals("a", StringUtil.trimBlank("a"));
        assertEquals("a", StringUtil.trimBlank(" a"));
        assertEquals("a", StringUtil.trimBlank("a "));
        assertEquals("a", StringUtil.trimBlank(" a "));
    }

    @Test
    public void toStringTest() {
        assertEquals("", StringUtil.toString(null));
        assertEquals(" ", StringUtil.toString(" "));
        assertEquals("abc", StringUtil.toString("abc"));
        assertEquals("abc", StringUtil.toString("abc ").trim());
    }

    @Test
    public void isBlankTest() {
        assertTrue(StringUtil.isBlank(""));
        assertTrue(StringUtil.isBlank(" "));
        assertFalse(StringUtil.isBlank(" a"));
        assertFalse(StringUtil.isBlank("t"));
    }

    @Test
    public void isBlankArrayTest() {
        assertTrue(StringUtil.isBlank(new String[0]));
        assertFalse(StringUtil.isBlank(("a,b,c").split(",")));
    }

    @Test
    public void isNotBlankTest() {
        assertFalse(StringUtil.isNotBlank(""));
        assertFalse(StringUtil.isNotBlank(" "));
        assertTrue(StringUtil.isNotBlank(" a"));
        assertTrue(StringUtil.isNotBlank("t"));
    }

    @Test
    public void isNotBlankArrayTest() {
        assertFalse(StringUtil.isNotBlank(new String[0]));
        assertTrue(StringUtil.isNotBlank(("a,b,c").split(",")));
    }

    @Test
    public void isNullTest() {
        assertTrue(StringUtil.isNull(""));
        assertTrue(StringUtil.isNull(" "));
        assertFalse(StringUtil.isNull(" a"));
        assertFalse(StringUtil.isNull("t"));
    }

    @Test
    public void isNullObjectTest() {
        assertTrue(StringUtil.isNullObject(null));
        assertFalse(StringUtil.isNullObject(""));
        assertFalse(StringUtil.isNullObject(" "));
        assertFalse(StringUtil.isNullObject("a"));
        assertFalse(StringUtil.isNullObject("a "));
        assertFalse(StringUtil.isNullObject("A "));
    }

    @Test
    public void isNotNullObjectTest() {
        assertTrue(StringUtil.isNotNullObject(""));
        assertTrue(StringUtil.isNotNullObject(" "));
        assertTrue(StringUtil.isNotNullObject("a"));
        assertTrue(StringUtil.isNotNullObject("a "));
        assertTrue(StringUtil.isNotNullObject("A "));
        assertFalse(StringUtil.isNotNullObject(null));
    }

    @Test
    public void isNotNullTest() {
        assertFalse(StringUtil.isNotNull(""));
        assertFalse(StringUtil.isNotNull(" "));
        assertTrue(StringUtil.isNotNull(" a"));
        assertTrue(StringUtil.isNotNull("t"));
    }

    @Test
    public void isEqualTest() {
        assertFalse(StringUtil.isEqual(null, ""));
        assertFalse(StringUtil.isEqual("a", "A"));
        assertFalse(StringUtil.isEqual("a", "ab"));
        assertTrue(StringUtil.isEqual("a", "a"));
        assertFalse(StringUtil.isEqual("a", "a "));
        assertFalse(StringUtil.isEqual("a", "a "));
        assertFalse(StringUtil.isEqual("a", " a"));
        assertFalse(StringUtil.isEqual("a", " a "));
    }

    @Test
    public void isEqualsIgnoreCaseTest() {
        assertFalse(StringUtil.isEqualsIgnoreCase(null, ""));
        assertTrue(StringUtil.isEqualsIgnoreCase("a", "A"));
        assertFalse(StringUtil.isEqualsIgnoreCase("a", "ab"));
        assertTrue(StringUtil.isEqualsIgnoreCase("a", "a"));
        assertFalse(StringUtil.isEqualsIgnoreCase("a", "a "));
        assertFalse(StringUtil.isEqualsIgnoreCase("a", "a "));
        assertFalse(StringUtil.isEqualsIgnoreCase("a", " a"));
        assertFalse(StringUtil.isEqualsIgnoreCase("a", " a "));
    }

    @Test
    public void isEqualsYTest() {
        assertFalse(StringUtil.isEqualsY(null));
        assertFalse(StringUtil.isEqualsY("a"));
        assertTrue(StringUtil.isEqualsY("y"));
        assertTrue(StringUtil.isEqualsY("Y"));
        assertFalse(StringUtil.isEqualsY("y "));
        assertFalse(StringUtil.isEqualsY(" y "));
        assertFalse(StringUtil.isEqualsY(" y "));
        assertFalse(StringUtil.isEqualsY("Y "));
        assertFalse(StringUtil.isEqualsY(" Y "));
        assertFalse(StringUtil.isEqualsY(" Y "));
    }

    @Test
    public void isEqualsTrueTest() {
        assertFalse(StringUtil.isEqualsTrue(null));
        assertFalse(StringUtil.isEqualsTrue("a"));
        assertTrue(StringUtil.isEqualsTrue("true"));
        assertTrue(StringUtil.isEqualsTrue("true"));
        assertFalse(StringUtil.isEqualsTrue("true "));
        assertFalse(StringUtil.isEqualsTrue(" TRUE "));
        assertFalse(StringUtil.isEqualsTrue("TRUE "));
    }

    @Test
    public void isIntTest() {
        assertTrue(StringUtil.isInt("1"));
        assertFalse(StringUtil.isInt("1a"));
        assertFalse(StringUtil.isInt(null));
        assertFalse(StringUtil.isInt(""));
        assertFalse(StringUtil.isInt(" "));
        assertFalse(StringUtil.isInt("1 "));
    }

    @Test
    public void verifyEmailTest() {
        assertTrue(StringUtil.verifyEmail("zhangsan@126.com"));
        assertTrue(StringUtil.verifyEmail("zhangsan@163.com"));

        assertTrue(StringUtil.verifyEmail(null));
        assertTrue(StringUtil.verifyEmail(""));
        assertFalse(StringUtil.verifyEmail(" "));
        assertFalse(StringUtil.verifyEmail("bad email "));
    }

    @Test
    public void isDateTest() {
        assertTrue(StringUtil.isDate("2016-06-10", DateUtil.DATE_FORMAT_STYLE3));
        assertTrue(StringUtil.isDate("20160610", DateUtil.DATE_FORMAT_STYLE4));
        assertTrue(StringUtil.isDate("2016-06-10 10:00:00", DateUtil.DATE_FORMAT_STYLE5));
    }

    @Test(expected = NullPointerException.class)
    public void isDateException1Test() {
        assertFalse(StringUtil.isDate(null, DateUtil.DATE_FORMAT_STYLE3));
        assertFalse(StringUtil.isDate("", DateUtil.DATE_FORMAT_STYLE3));
        assertFalse(StringUtil.isDate(" ", DateUtil.DATE_FORMAT_STYLE3));
        assertFalse(StringUtil.isDate("bad date", DateUtil.DATE_FORMAT_STYLE3));

        assertTrue(StringUtil.isDate("2016-06-12", "bad format"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isDateException2Test() {
        assertFalse(StringUtil.isDate("", DateUtil.DATE_FORMAT_STYLE3));
        assertFalse(StringUtil.isDate(" ", DateUtil.DATE_FORMAT_STYLE3));
        assertFalse(StringUtil.isDate("bad date", DateUtil.DATE_FORMAT_STYLE3));

        assertTrue(StringUtil.isDate("2016-06-13", "bad format"));
    }

    @Test
    public void isNumberTest() {
        assertTrue(StringUtil.isNumber("1"));
        assertFalse(StringUtil.isNumber("1.0L"));

        assertFalse(StringUtil.isNumber(null));
        assertFalse(StringUtil.isNumber(""));
        assertFalse(StringUtil.isNumber(" "));
        assertFalse(StringUtil.isNumber("a"));
        assertFalse(StringUtil.isNumber(" a "));
        assertFalse(StringUtil.isNumber("1.0 "));
    }

    @Test
    public void verifyIdCardNoTest() {
        assertFalse(StringUtil.verifyIdCardNo(null));
        assertFalse(StringUtil.verifyIdCardNo(""));
        assertFalse(StringUtil.verifyIdCardNo(" "));
        assertFalse(StringUtil.verifyIdCardNo("abc"));
        assertFalse(StringUtil.verifyIdCardNo("abcdef"));
        assertTrue(StringUtil.verifyIdCardNo("411224198608786717"));
    }

    @Test
    public void verifyMobileTest() {
        assertFalse(StringUtil.verifyMobile(null));
        assertFalse(StringUtil.verifyMobile(""));
        assertFalse(StringUtil.verifyMobile(" "));
        assertFalse(StringUtil.verifyMobile("abc"));
        assertFalse(StringUtil.verifyMobile("abcdef"));
        assertFalse(StringUtil.verifyMobile("1234567891a"));
        assertFalse(StringUtil.verifyMobile("02345678912"));
        assertFalse(StringUtil.verifyMobile("03345678912"));
        assertFalse(StringUtil.verifyMobile("033456789abc"));

        assertTrue(StringUtil.verifyMobile("15838028035"));
        assertTrue(StringUtil.verifyMobile("13466788891"));
        assertTrue(StringUtil.verifyMobile("14233456789"));
        assertTrue(StringUtil.verifyMobile("14233456788"));
        assertTrue(StringUtil.verifyMobile("14233456786"));
    }

    @Test
    public void toUpperTest() {
        assertEquals("A", StringUtil.toUpper("a"));
        assertEquals("A", StringUtil.toUpper("A"));
        assertEquals("", StringUtil.toUpper(""));
        assertEquals(" ", StringUtil.toUpper(" "));
        assertEquals(null, StringUtil.toUpper(null));
    }

    @Test
    public void getUuidTest() {
        assertNotNull(StringUtil.getUuid());
    }

    @Test
    public void splitStringTest() {
        String splitString = "abcdefgh";
        assertFalse(StringUtil.splitString(splitString, 2).isEmpty());
    }

    @Test
    public void splitStringToStringListTest() {
        String testStr = "a,b,c";
        assertTrue(StringUtil.splitStringToStringList(null).size() == 1);
        assertTrue(StringUtil.splitStringToStringList("a").size() == 1);
        assertTrue(StringUtil.splitStringToStringList("a,b").size() == 2);

        assertEquals("a", StringUtil.splitStringToStringList(testStr).get(0));
        assertEquals("b", StringUtil.splitStringToStringList(testStr).get(1));
        assertEquals("c", StringUtil.splitStringToStringList(testStr).get(2));

        assertEquals("", StringUtil.splitStringToStringList(testStrABC2).get(0));
        assertEquals("a", StringUtil.splitStringToStringList(testStrABC2).get(1));
        assertEquals("b", StringUtil.splitStringToStringList(testStrABC2).get(2));
        assertEquals("c", StringUtil.splitStringToStringList(testStrABC2).get(3));
    }

    @Test
    public void convertArrayToSplitStringTest() {
        String testStr = "a,b,c";
        assertEquals("a", StringUtil.stringToArray(testStr, ",")[0]);
        assertEquals("b", StringUtil.stringToArray(testStr, ",")[1]);
        assertEquals("c", StringUtil.stringToArray(testStr, ",")[2]);

        assertEquals("a", StringUtil.stringToArray(",a,b,c", ",")[0]);
        assertEquals("b", StringUtil.stringToArray(",a,b,c", ",")[1]);
        assertEquals("c", StringUtil.stringToArray(",a,b,c", ",")[2]);

        assertEquals("a,b,c", StringUtil.convertArrayToSplitString(StringUtil.stringToArray(testStr, ","), ","));
        assertEquals("a,b,c", StringUtil.convertArrayToSplitString(StringUtil.stringToArray(",a,b,c", ","), ","));
    }

    @Test
    public void convertArrayToSplitString2Test() {
        String testStr = "a,b,c";
        assertEquals("a", StringUtil.stringToArray(testStr, ",")[0]);
        assertEquals("b", StringUtil.stringToArray(testStr, ",")[1]);
        assertEquals("c", StringUtil.stringToArray(testStr, ",")[2]);

        assertEquals("a", StringUtil.stringToArray(",a,b,c", ",")[0]);
        assertEquals("b", StringUtil.stringToArray(",a,b,c", ",")[1]);
        assertEquals("c", StringUtil.stringToArray(",a,b,c", ",")[2]);

        assertEquals("'a','b','c'", StringUtil.convertArrayToSplitString2(StringUtil.stringToArray(testStr, ","), ","));
        assertEquals("'a','b','c'",
                StringUtil.convertArrayToSplitString2(StringUtil.stringToArray(",a,b,c", ","), ","));
    }

    @Test
    public void stringToArrayTest() {
        String testStr = "a,b,c";
        assertEquals("a", StringUtil.stringToArray(testStr, ",")[0]);
        assertEquals("b", StringUtil.stringToArray(testStr, ",")[1]);
        assertEquals("c", StringUtil.stringToArray(testStr, ",")[2]);

        assertEquals("a", StringUtil.stringToArray(",a,b,c", ",")[0]);
        assertEquals("b", StringUtil.stringToArray(",a,b,c", ",")[1]);
        assertEquals("c", StringUtil.stringToArray(",a,b,c", ",")[2]);
    }

    @Test
    public void getStringByArrayTest() {
        assertEquals("abc", StringUtil.getStringByArray(StringUtil.stringToArray("a,b,c", ",")));
        assertEquals("abc", StringUtil.getStringByArray(StringUtil.stringToArray(",a,b,c", ",")));
        assertEquals("abc", StringUtil.getStringByArray(StringUtil.stringToArray("a,b,c,", ",")));
        assertEquals("abc", StringUtil.getStringByArray(StringUtil.stringToArray(testStrABC2, ",")));

        assertEquals("", StringUtil.getStringByArray(null));
        assertEquals(",a,b,c", StringUtil.getStringByArray(StringUtil.stringToArray(testStrABC2, ";")));
    }

    @Test
    public void parseIntTest() {
        assertEquals(1, StringUtil.parseInt("1", 3));
        assertEquals(3, StringUtil.parseInt("1a", 3));
        assertEquals(3, StringUtil.parseInt(" 1 ", 3));

        assertEquals(3, StringUtil.parseInt(null, 3));
        assertEquals(3, StringUtil.parseInt("", 3));
        assertEquals(3, StringUtil.parseInt(" ", 3));
        assertEquals(3, StringUtil.parseInt("a ", 3));
    }

    @Test
    public void parseFloatTest() {
        assertTrue(Float.parseFloat("1") == StringUtil.parseFloat("1", 3.0f));
        assertTrue(Float.parseFloat("3.0") == StringUtil.parseFloat("1a", 3.0f));
        assertTrue(Float.parseFloat("1.0") == StringUtil.parseFloat(" 1 ", 3.0f));

        assertTrue(3.0 == StringUtil.parseFloat(null, 3.0f));
    }

    @Test
    public void toChiTest() {
        assertNotNull(StringUtil.toChi("a"));
        assertNotNull(StringUtil.toChi("你好"));
    }

    @Test
    public void toIsoTest() {
        assertNotNull(StringUtil.toIso("a"));
        assertNotNull(StringUtil.toIso("你好"));
    }

    @Test
    public void changeEncodingTest() {
        assertEquals(null, StringUtil.changeEncoding(null, "UTF-8", "ISO8859-1"));
        assertEquals("", StringUtil.changeEncoding("", "UTF-8", "ISO8859-1"));
        assertEquals(" ", StringUtil.changeEncoding(" ", "UTF-8", "ISO8859-1"));
        assertEquals("  ", StringUtil.changeEncoding("  ", "UTF-8", "ISO8859-1"));

        assertNotNull(StringUtil.changeEncoding("a", "UTF-8", "ISO8859-1"));
        assertNotNull(StringUtil.changeEncoding("你好", "UTF-8", "ISO8859-1"));

        assertNotNull(StringUtil.changeEncoding("你好", "UTF-8", "bad encoding"));
    }

    @Test
    public void replaceTest() {
        String testStr = "abcdefABAd";
        assertEquals("ABcdefABAd", StringUtil.replace(testStr, "ab", "AB"));
        assertEquals("abCDefABAd", StringUtil.replace(testStr, "cd", "CD"));
        assertEquals("abcdEEABAd", StringUtil.replace(testStr, "ef", "EE"));
        assertEquals("abcdefABAd", StringUtil.replace(testStr, "Ab", "fg"));
        assertEquals("abcfgfABAd", StringUtil.replace(testStr, "de", "fg"));

        assertEquals(null, StringUtil.replace(null, "de", "fg"));
    }

    @Test
    public void getExtensionTest() {
        assertEquals("xls", StringUtil.getExtension("1.xls"));
        assertEquals("xlsx", StringUtil.getExtension("1.xlsx"));
        assertEquals("doc", StringUtil.getExtension("1.doc"));
        assertEquals("docx", StringUtil.getExtension("1.docx"));
        assertEquals("pdf", StringUtil.getExtension("1.pdf"));
        assertEquals("jpg", StringUtil.getExtension("1.jpg"));
        assertEquals("gif", StringUtil.getExtension("1.gif"));
        assertEquals("png", StringUtil.getExtension("1.png"));
        assertEquals("text", StringUtil.getExtension("1.text"));
        assertEquals("txt", StringUtil.getExtension("1.txt"));
        assertEquals("sql", StringUtil.getExtension("1.sql"));
        assertEquals("java", StringUtil.getExtension("1.java"));
        assertEquals("js", StringUtil.getExtension("1.js"));
        assertEquals("jsp", StringUtil.getExtension("1.jsp"));

        assertEquals("xls", StringUtil.getExtension("e://test//1.xls"));
        assertEquals("xlsx", StringUtil.getExtension("e://test////1.xlsx"));
        assertEquals("doc", StringUtil.getExtension("1.doc"));
        assertEquals("docx", StringUtil.getExtension("e://test//1.docx"));
        assertEquals("pdf", StringUtil.getExtension("e://test//1.pdf"));
        assertEquals("jpg", StringUtil.getExtension("e://test//1.jpg"));
        assertEquals("gif", StringUtil.getExtension("e://test//1.gif"));
        assertEquals("png", StringUtil.getExtension("e://test//1.png"));
        assertEquals("text", StringUtil.getExtension("e://test//1.text"));
        assertEquals("txt", StringUtil.getExtension("e://test//1.txt"));
        assertEquals("sql", StringUtil.getExtension("e://test//1.sql"));
        assertEquals("java", StringUtil.getExtension("e://test//1.java"));
        assertEquals("js", StringUtil.getExtension("e://test//1.js"));
        assertEquals("jsp", StringUtil.getExtension("e://test//1.jsp"));

        assertEquals("", StringUtil.getExtension(null));
        assertEquals("", StringUtil.getExtension(""));
        assertEquals("", StringUtil.getExtension(" "));
        assertEquals("", StringUtil.getExtension("a"));
        assertEquals("", StringUtil.getExtension("a."));
    }

    @Test
    public void getPrefixTest() {
        assertEquals("1", StringUtil.getPrefix("1.xls"));
        assertEquals("2", StringUtil.getPrefix("2.xlsx"));
        assertEquals("3", StringUtil.getPrefix("3.doc"));
        assertEquals("4", StringUtil.getPrefix("4.docx"));
        assertEquals("5", StringUtil.getPrefix("5.pdf"));
        assertEquals("6", StringUtil.getPrefix("6.jpg"));
        assertEquals("7", StringUtil.getPrefix("7.gif"));
        assertEquals("8", StringUtil.getPrefix("8.png"));
        assertEquals("9", StringUtil.getPrefix("9.text"));
        assertEquals("10", StringUtil.getPrefix("10.txt"));
        assertEquals("11", StringUtil.getPrefix("11.sql"));
        assertEquals("12", StringUtil.getPrefix("12.java"));
        assertEquals("13", StringUtil.getPrefix("13.js"));
        assertEquals("14", StringUtil.getPrefix("14.jsp"));

        assertEquals("1", StringUtil.getPrefix("e://test//1.xls"));
        assertEquals("2", StringUtil.getPrefix("e://test//2.xlsx"));
        assertEquals("3", StringUtil.getPrefix("e://test//3.doc"));
        assertEquals("4", StringUtil.getPrefix("e://test//4.docx"));
        assertEquals("5", StringUtil.getPrefix("e://test//5.pdf"));
        assertEquals("6", StringUtil.getPrefix("e://test//6.jpg"));
        assertEquals("7", StringUtil.getPrefix("e://test//7.gif"));
        assertEquals("8", StringUtil.getPrefix("e://test//8.png"));
        assertEquals("9", StringUtil.getPrefix("e://test//9.text"));
        assertEquals("10", StringUtil.getPrefix("e://test//10.txt"));
        assertEquals("11", StringUtil.getPrefix("e://test//11.sql"));
        assertEquals("12", StringUtil.getPrefix("e://test//12.java"));
        assertEquals("13", StringUtil.getPrefix("e://test//13.js"));
        assertEquals("14", StringUtil.getPrefix("e://test//14.jsp"));

        assertEquals("", StringUtil.getPrefix(null));
        assertEquals("", StringUtil.getPrefix("e://test//test1//"));

    }

    @Test
    public void generateRandomLowercaseTest() {
        assertTrue(StringUtil.generateRandomLowercase(5).length() == 5);
        assertTrue(StringUtil.generateRandomLowercase(6).length() == 6);
        assertTrue(StringUtil.generateRandomLowercase(7).length() == 7);
        assertTrue(StringUtil.generateRandomLowercase(8).length() == 8);
        assertTrue(StringUtil.generateRandomLowercase(9).length() == 9);
        assertTrue(StringUtil.generateRandomLowercase(10).length() == 10);
    }

    @Test
    public void generateRandomUppercaseTest() {
        assertTrue(StringUtil.generateRandomUppercase(5).length() == 5);
        assertTrue(StringUtil.generateRandomUppercase(6).length() == 6);
        assertTrue(StringUtil.generateRandomUppercase(7).length() == 7);
        assertTrue(StringUtil.generateRandomUppercase(8).length() == 8);
        assertTrue(StringUtil.generateRandomUppercase(9).length() == 9);
        assertTrue(StringUtil.generateRandomUppercase(10).length() == 10);
    }

    @Test
    public void generateRandomNumberTest() {
        assertTrue(StringUtil.generateRandomNumber(5).length() == 5);
        assertTrue(StringUtil.generateRandomNumber(6).length() == 6);
        assertTrue(StringUtil.generateRandomNumber(7).length() == 7);
        assertTrue(StringUtil.generateRandomNumber(8).length() == 8);
        assertTrue(StringUtil.generateRandomNumber(9).length() == 9);
        assertTrue(StringUtil.generateRandomNumber(10).length() == 10);
    }

    @Test
    public void randomTest() {
        assertTrue(StringUtil.randomInt(10) >= 0);
        assertTrue(StringUtil.randomInt(20) >= 0);
        assertTrue(StringUtil.randomInt(100) >= 0);
        assertTrue(StringUtil.randomInt(300) >= 0);
    }

    @Test
    public void generateRandomCharsTest() {
        assertTrue(StringUtil.generateRandomChars("abcdefgc", 3).length() == 3);
        assertTrue(StringUtil.generateRandomChars("abcdefgd", 4).length() == 4);
        assertTrue(StringUtil.generateRandomChars("abcdefge", 5).length() == 5);
        assertTrue(StringUtil.generateRandomChars("abcdefgf", 6).length() == 6);
    }

    @Test
    public void randomOrderTest() {
        assertTrue(StringUtil.randomOrder("abcdefa").length() == 7);
        assertTrue(StringUtil.randomOrder("abcdfeb").length() == 7);
        assertTrue(StringUtil.randomOrder("abcefdc").length() == 7);
        assertTrue(StringUtil.randomOrder("abcedfd").length() == 7);
        assertTrue(StringUtil.randomOrder("bacdefe").length() == 7);
        assertTrue(StringUtil.randomOrder("badceff").length() == 7);
    }

    @Test
    public void propsTest() {
        logger.debug(StringUtil.printAllMethodAndAttrInfo(new BaseEntity()));
    }

    @Test
    public void byteToStringTest() throws UnsupportedEncodingException {
        String str = "123";
        byte[] b = str.getBytes("UTF-8");
        String rest = StringUtil.byteToString(b);
        assertEquals(str, rest);
    }
}
