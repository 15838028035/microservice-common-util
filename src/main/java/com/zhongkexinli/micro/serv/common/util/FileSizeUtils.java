package com.zhongkexinli.micro.serv.common.util;

import java.text.DecimalFormat;

/**
 * 
 * 文件大小工具类
 *
 */
public  class FileSizeUtils {
  
    private FileSizeUtils() {
      //空构造，防止重复创建
    }
    
    public static final long ONE_KB = 1024L;
    public static final long ONE_MB = ONE_KB * 1024;
    public static final long ONE_GB = ONE_MB * 1024;
    public static final long ONE_TB = ONE_GB * (long) 1024;
    public static final long ONE_PB = ONE_TB * (long) 1024;
  
    /**
     * 文件大小
     * 
     * @param fileSize
     *          文件大小
     * @return 文件大小
     */
    public static String getHumanReadableFileSize(Long fileSize) {
        if (fileSize == null) {
            return null;
        }
        return getHumanReadableFileSize(fileSize.longValue());
    }
  
    /**
     * 文件大小
     * 
     * @param fileSize
     *          文件大小
     * @return 文件大小
     */
    public static String getHumanReadableFileSize(long fileSize) {
        if (fileSize < 0) {
            return String.valueOf(fileSize);
        }
        String result = getHumanReadableFileSize(fileSize, ONE_PB, "PB");
        if (result != null) {
            return result;
        }
    
        result = getHumanReadableFileSize(fileSize, ONE_TB, "TB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_GB, "GB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_MB, "MB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_KB, "KB");
        if (result != null) {
            return result;
        }
        return String.valueOf(fileSize) + "B";
  
    }
  
    private static String getHumanReadableFileSize(long fileSize, long unit, String unitName) {
        if (fileSize == 0) {
            return "0";
        }
    
        if (fileSize / unit >= 1) {
            double value = fileSize / (double) unit;
            DecimalFormat df = new DecimalFormat("######.##" + unitName);
            return df.format(value);
        }
        return null;
    }
}
