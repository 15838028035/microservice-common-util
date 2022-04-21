package com.zhongkexinli.micro.serv.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipUtil {

    /**
     * 字符串压缩为字节数组
     */
    public static byte[] compressToByte(String str){
        String encode = "utf-8";
        return compressToByte(str,encode);
    }

    /**
     * 字符串压缩为字节数组
     */
    public static byte[] compressToByte(String str,String encoding){
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes(encoding));
            gzip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    /**
     *  字节数组解压缩后返回字符串
     */
    public static String uncompressToString(byte[] b) {
        String encode = "utf-8";
        return uncompressToString(b,encode);
    }

    /**
     * 字节数组解压缩后返回字符串
     */
    public static String uncompressToString(byte[] b, String encoding) {
        if (b == null || b.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(b);
        try {
            GZIPInputStream gunzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
