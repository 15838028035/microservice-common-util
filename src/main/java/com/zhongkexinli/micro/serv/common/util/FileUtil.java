package com.zhongkexinli.micro.serv.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * 文件工具类
 *
 */
public abstract class FileUtil {
  public static final int DEFAULT_CHUNK_SIZE = 1024;
  public static final int BUFFERSIZE = 4096;
  
  private static Log logger = LogFactory.getLog(FileUtil.class);

  /**
   * 创建文件
   * @param in 输入流
   * @param filePath 文件路径
   */
  public static void createFile(InputStream in, String filePath) {
    if (in == null) {
      throw new RuntimeException("create file error: inputstream is null");
    }
    
    int potPos = filePath.lastIndexOf('/') + 1;
    String folderPath = filePath.substring(0, potPos);
    createFolder(folderPath);
    FileOutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream(filePath);
      byte[] by = new byte[1024];
      int c;
      while ((c = in.read(by)) != -1) {
        outputStream.write(by, 0, c);
      }
    } catch (IOException e) {
      logger.error(e);
    }finally {
      if(outputStream!=null) {
        try {
        	outputStream.flush();
          outputStream.close();
        } catch (IOException e) {
          logger.error(e);
        }
      }
      if(in!=null) {
        try {
          in.close();
        } catch (IOException e) {
          logger.error(e);
        }
      }
    }
  }

  /**
   * 是否是允许上传文件 允许上传文件格式是GIF,JPG,BMP,SWF,JPEG,PNG
   * 
   * @param fileName 文件名称
   * @return 是否
   */
  public static boolean isAllowUp(String fileName) {
    String allowTYpe = "GIF,JPG,BMP,SWF,JPEG,PNG";
    if (StringUtil.isNotBlank(fileName)) {
      String ex = StringUtil.getExtension(fileName).toUpperCase();
      return allowTYpe.indexOf(ex.toUpperCase()) >= 0;
    } else {
      return false;
    }
  }

  /**
   * 把内容写入文件
   * 
   * @param filePath 文件路径
   * @param fileContent 文件内容 
   */
  public static void write(String filePath, String fileContent) {
    FileOutputStream fo = null;
    OutputStreamWriter out = null;
    try {
      fo = new FileOutputStream(filePath);
       out = new OutputStreamWriter(fo,"UTF-8");

      out.write(fileContent);

      out.close();
    } catch (FileNotFoundException ex) {
      logger.equals(ex);
    } catch (IOException ex) {
      logger.equals(ex);
    } catch (Exception ex) {
      logger.equals(ex);
    }finally {
      if(fo!=null) {
        try{
        fo.close();
        }catch(Exception e){
          logger.equals(e);
        }
      }
      
      if(out!=null) {
        try{
          out.close();
        }catch(Exception e){
          logger.equals(e);
        }
      }
    }
  }

  /**
   * 读取文件内容 默认是UTF-8编码
   * 
   * @param filePath 文件路径
   * @return 文件内容
   */
  public static String read(String filePath, String code) {
    if (code == null || code.equals("")) {
      code = "UTF-8";
    }
    StringBuilder fileContent = new StringBuilder();
    File file = new File(filePath);
    InputStreamReader read = null;
    BufferedReader reader = null;
    
    try {
       read = new InputStreamReader(new FileInputStream(file), code);
       reader = new BufferedReader(read);
      String line;
      while ((line = reader.readLine()) != null) {
        fileContent.append(line + "\n");
      }
      read.close();
      read = null;
      reader.close();
      read = null;
    } catch (Exception ex) {
      fileContent = new StringBuilder("");
      logger.error(ex);
    }finally {
      if(read!=null) {
        try{  
          read.close();
        }catch(Exception e) {
          logger.error(e);
        }
      }
      if(reader!=null) {
        try{  
          reader.close();
        }catch(Exception e) {
          logger.error(e);
        }
      }
    }
    return fileContent.toString();
  }

  /**
   * 删除文件或文件夹
   * 
   * @param filePath 文件路径
   */
  public static void delete(String filePath) {
    try {
      File file = new File(filePath);
      if (file.exists()) {
        if (file.isDirectory()) {
        	//不做处理
        } else {
          file.delete();
        }
      }
    } catch (Exception ex) {
      logger.error(ex);
    }
  }

  /**
   * 判断文件是否存在
   * 
   * @param filepath 文件路径
   * @return 是否 
   */
  public static boolean exist(String filepath) {
    File file = new File(filepath);
    return file.exists();
  }

  /**
   * 创建文件夹
   * 
   * @param filePath 文件路径
   */
  public static void createFolder(String filePath) {
    try {
      File file = new File(filePath);
      if (!file.exists()) {
        file.mkdirs();
      }
    } catch (Exception ex) {
      logger.error("createFolder  Error:" + ex.getMessage(),ex);
    }
  }
  
  /**
   * 读取文件
   * @param resource 文件名称
   * @return 文件内容
   */
  public static String readFile(String resource) {
    InputStream stream = getResourceAsStream(resource);
    String content = readStreamToString(stream);
    return content;
  }

  /**
   * 读取文件
   * @param resource 文件名称
   * @return 文件流
   */
  public static InputStream getResourceAsStream(String resource) {
    String stripped = resource.startsWith("/") ? resource.substring(1) : resource;
    InputStream stream = null;
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    if (classLoader != null) {
      stream = classLoader.getResourceAsStream(stripped);

    }
    return stream;
  }

  /**
   * 将输入流转换成字符 
   * @param stream 输入流
   * @return 将输入流转换成字符 
   */
  public static String readStreamToString(InputStream stream) {
    String fileContent = "";

    try {
      InputStreamReader read = new InputStreamReader(stream, "utf-8");
      BufferedReader reader = new BufferedReader(read);
      String line;
      while ((line = reader.readLine()) != null) {
        fileContent = fileContent + line + "\n";
      }
      read.close();
      read = null;
    } catch (Exception ex) {
      fileContent = "";
    }
    return fileContent;
  }

  public static byte[] readStreamToByte(InputStream stream) throws Exception {
    String fileContent = readStreamToString(stream);
    return fileContent.getBytes("UTF-8");
  }

  /**
   * 字符串转换成输入流
   * @param text 字符串
   * @return 字符串转换成输入流
   */
  public static InputStream getStreamFromString(String text) {
    try {
      byte[] bytes = text.getBytes("UTF-8");
      return new ByteArrayInputStream(bytes);
    } catch (Exception e) {
      throw new AssertionError(e);
    }
  }

  /**
   * 输入流转化成字节
   * @param in 输入流
   * @return 字节
   * @throws IOException IO异常
   */
  public static byte[] readBytes(InputStream in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    transfer(in, out);
    return out.toByteArray();
  }

  /**
   * 输入流输出流转化
   * @param in 输入流
   * @param out 输出流
   * @return 转换数量
   * @throws IOException IO异常
   */
  public static long transfer(InputStream in, OutputStream out) throws IOException {
    long total = 0;
    byte[] buffer = new byte[BUFFERSIZE];
    for (int count; (count = in.read(buffer)) != -1;) {
      out.write(buffer, 0, count);
      total += count;
    }
    return total;
  }
}
