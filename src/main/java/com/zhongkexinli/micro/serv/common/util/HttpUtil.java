package com.zhongkexinli.micro.serv.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 */
public class HttpUtil {
    
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    
    public static final String CHARSET_DEFAULT = "UTF-8";
    
    public static String post(String url, Map<String, String> postParams) throws Exception {
        return post(url, postParams, CHARSET_DEFAULT);
    }

    public static String post(String url, Map<String, String> postParams, String charset) throws Exception {
        String postParam = encodeParameters(postParams, charset);
        return post(url, postParam, CHARSET_DEFAULT);
    }

    public static String post(String url, String postParams) throws Exception {
        return post(url, postParams, CHARSET_DEFAULT);
    }

    public static String post(String url, String postParams, String charset) throws Exception {
        OutputStream osw = null;
        InputStream ins = null;

        String var7;
        try {
            HttpURLConnection con = (HttpURLConnection)(new URL(url)).openConnection();
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setConnectTimeout(10000);
            con.setReadTimeout(30000);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            String traceId = MDC.get("traceId");
            
            if(traceId!=null) {
                 con.setRequestProperty("traceId", traceId);
                 logger.info("设置http请求的traceId:{}",traceId);
            }else {
                 traceId = UUID.randomUUID().toString();
                 con.setRequestProperty("traceId", traceId);
                 logger.info("设置http请求的traceId:{}",traceId);
            }
            
            if(null != postParams) {
                con.setDoOutput(true);
                byte[] resCode = postParams.getBytes(CHARSET_DEFAULT);
                con.setRequestProperty("Content-Length", Integer.toString(resCode.length));
                osw = con.getOutputStream();
                osw.write(resCode);
                osw.flush();
            }

            int resCode1 = con.getResponseCode();
            if(resCode1 < 400) {
                ins = con.getInputStream();
            } else {
                ins = con.getErrorStream();
            }

            var7 = readContent(ins, charset);
        } finally {
            if(osw != null) {
                osw.close();
            }

            if(ins != null) {
                ins.close();
            }

        }

        return var7;
    }
    
    private static String encodeParameters(Map<String, String> postParams, String charset) throws UnsupportedEncodingException {
        StringBuilder buf = new StringBuilder();
        if(postParams != null && postParams.size() > 0) {
            Iterator i$ = postParams.entrySet().iterator();

            while(i$.hasNext()) {
                Map.Entry tmp = (Map.Entry)i$.next();
                buf.append(URLEncoder.encode((String)tmp.getKey(), charset)).append("=").append(URLEncoder.encode((String)tmp.getValue(), charset)).append("&");
            }

            buf.deleteCharAt(buf.length() - 1);
        }

        return buf.toString();
    }
    
    /**
     * 发送请求
     */
    private static String send(String url, String postParam, String contentType, String charset) throws Exception {
        OutputStream osw = null;
        InputStream ins = null;
        String var7;
        try {
            HttpURLConnection con = (HttpURLConnection) (new URL(url)).openConnection();
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setConnectTimeout(10000);
            con.setReadTimeout(30000);
            con.setRequestProperty("Content-Type", contentType);
            
            String traceId = MDC.get("traceId");
            
            if(traceId!=null) {
                 con.setRequestProperty("traceId", traceId);
                 logger.info("设置http请求的traceId:{}",traceId);
            }else {
                 traceId = UUID.randomUUID().toString();
                 con.setRequestProperty("traceId", traceId);
                 logger.info("设置http请求的traceId:{}",traceId);
            }
            
            if (null != postParam) {
                con.setDoOutput(true);
                byte[] resCode = postParam.getBytes("UTF-8");
                con.setRequestProperty("Content-Length", Integer.toString(resCode.length));
                osw = con.getOutputStream();
                osw.write(resCode);
                osw.flush();
            }

            int resCode1 = con.getResponseCode();
            if (resCode1 < 400) {
                ins = con.getInputStream();
            } else {
                ins = con.getErrorStream();
            }

            var7 = readContent(ins, charset);
        } finally {
            if (osw != null) {
                osw.close();
            }

            if (ins != null) {
                ins.close();
            }

        }
        return var7;
    }

    /**
     * 读取输入流信息并转换成字符串
     */
    private static String readContent(InputStream ins, String charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(ins, charset));

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }

    /**
     * 发送Post请求
     * 数据格式为 json
     */
    public static String sendJsonHttpPost(String url, String json) throws Exception {
        String charset = "UTF-8";
        String var7 = send(url, json, "application/json", charset);
        return var7;
    }
    
    /**
     * 添加get方法
     *
     * @param url
     * @param charset
     * @return
     * @throws IOException
     */
    public static String get(String url, String charset) throws IOException {
        InputStream ins = null;
        String var5;
        try {
            HttpURLConnection con = (HttpURLConnection) (new URL(url)).openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(10000);
            con.setReadTimeout(600000);
            int resCode = con.getResponseCode();
            if (resCode < 400) {
                ins = con.getInputStream();
            } else {
                ins = con.getErrorStream();
            }

            var5 = readContent(ins, charset);
        } finally {
            if (ins != null) {
                ins.close();
            }

        }

        return var5;
    }
    
    public static boolean httpDownload(String httpUrl, String saveFile) {

        // 下载网络文件
        URL url = null;
        try {
            url = new URL(httpUrl);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            return false;
        }
        HttpURLConnection conn = null;
        InputStream inStream = null;
        FileOutputStream fs = null;
        try {
            File file = new File(saveFile);
            File pFile = file.getParentFile();
            if (!pFile.exists()) {
                pFile.mkdirs();
            }

            file.createNewFile();

            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(10 * 1000);
            conn.setReadTimeout(20 * 1000);

            if (conn.getResponseCode() == 200) {
                try {
                    inStream = conn.getInputStream();
                } catch (IOException e) {
                    logger.info("输入流错误");
                    return false;
                }
                try {
                    fs = new FileOutputStream(saveFile);
                } catch (FileNotFoundException e) {
                    logger.info("输出流错误");
                    return false;
                }

                byte[] buffer = new byte[2048];
                int len;
                try {
                    while ((len = inStream.read(buffer, 0, 2048)) != -1) {
                        fs.write(buffer, 0, len);
                    }
                } catch (IOException e) {
                    logger.info("读写错误");
                    return false;
                }
                return true;
            }
        } catch (FileNotFoundException e) {
            logger.info("下载视频创建文件异常");
            return false;
        } catch (IOException e) {
            logger.info("下载视频异常");
            return false;
        } finally {
            try {
                if (fs != null) {
                    fs.flush();
                    fs.close();
                    logger.info("关闭输入流");
                }
                if (inStream != null) {
                    inStream.close();
                    logger.info("关闭输出流");
                }
            } catch (IOException e) {
                logger.info("下载线程关闭流异常");
                return false;
            }
        }
        return false;
    }
}
