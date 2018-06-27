package com.zhongkexinli.micro.serv.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
/**
 * 文件类型判断类
 */
public final class FileTypeJudge {
     
    /**
     * 将文件头转换成16进制字符串
     * 
     * @param 原生byte
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] b){
         
        StringBuilder stringBuilder = new StringBuilder();   
        if (b == null || b.length <= 0) {   
            return null;   
        }   
        for (int i = 0; i < b.length; i++) {   
            int v = b[i] & 0xFF;   
            String str = Integer.toHexString(v);   
            if (str.length() < 2) {   
                stringBuilder.append(0);   
            }   
            stringBuilder.append(str);   
        }   
        return stringBuilder.toString();   
    }
    
    /**
     * 得到文件头
     * 
     * @param filePath 文件路径
     * @return 文件头
     * @throws IOException
     */
    private static String getFileContent(String filePath) throws IOException {
         
        byte[] b = new byte[28];
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            inputStream.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }
    
    /**
     * 得到文件头
     * 
     * @param filePath 文件路径
     * @return 文件头
     * @throws IOException
     */
    private static String getFileContent(InputStream inputStream) throws IOException {
        byte[] b = new byte[28];
        try {
            inputStream.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }
    
    /**
     * 得到文件头
     * 
     * @param filePath 文件路径
     * @return 文件头
     * @throws IOException
     */
    private static String getFileContent2(InputStream inputStream) throws IOException {
        byte[] b = new byte[28];
        try {
            inputStream.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } 
        return bytesToHexString(b);
    }
     
    /**
     * 判断文件类型
     * 
     * @param filePath 文件路径
     * @return 文件类型
     */
    public static FileType getType(String filePath) throws IOException {
         
        String fileHead = getFileContent(filePath);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
         
        fileHead = fileHead.toUpperCase();
         
        FileType[] fileTypes = FileType.values();
        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }
    
    /**
     * 判断文件类型
     * 
     * @param filePath 文件路径
     * @return 文件类型
     */
    public static FileType getType(InputStream inputStream) throws IOException {
         
        String fileHead = getFileContent(inputStream);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
         
        fileHead = fileHead.toUpperCase();
         
        FileType[] fileTypes = FileType.values();
        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }
    
    /**
     * 判断文件类型
     * 
     * @param filePath 文件路径
     * @return 文件类型
     */
    public static FileType getType2(InputStream inputStream) throws IOException {
         
        String fileHead = getFileContent2(inputStream);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
         
        fileHead = fileHead.toUpperCase();
         
        FileType[] fileTypes = FileType.values();
        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }
    
}