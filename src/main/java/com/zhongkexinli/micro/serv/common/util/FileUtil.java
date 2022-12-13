package com.zhongkexinli.micro.serv.common.util;

import java.io.BufferedInputStream;
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
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * 文件工具类
 *
 */
public class FileUtil {

    private FileUtil() {

    }

    public static final int DEFAULT_CHUNK_SIZE = 1024;
    public static final int BUFFERSIZE = 4096;

    private static Log logger = LogFactory.getLog(FileUtil.class);
    
    public static String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
      
    /**
       * Returns the name of the file or directory denoted by this abstract
       * pathname.  This is just the last name in the pathname's name
       * sequence.  If the pathname's name sequence is empty, then the empty
       * string is returned.
       *
       * @return  The name of the file or directory denoted by this abstract
       *          pathname, or the empty string if this pathname's name sequence
       *          is empty
       */
  public static  String getName(String path) {
      int index = path.lastIndexOf(".");
      int start = path.lastIndexOf("/");
      return path.substring(start+1,index + 1);
  }

    /**
     * 创建文件
     * 
     * @param in
     *            输入流
     * @param filePath
     *            文件路径
     */
    public static void createFile(InputStream in, String filePath) {
        if (in == null) {
            throw new RuntimeException("create file error: inputstream is null");
        }

        int potPos = filePath.lastIndexOf('/') + 1;
        String folderPath = filePath.substring(0, potPos);
        createFolder(folderPath);
        try (FileOutputStream outputStream = new FileOutputStream(filePath);) {
            byte[] by = new byte[1024];
            int c;
            while ((c = in.read(by)) != -1) {
                outputStream.write(by, 0, c);
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }

    /**
     * 是否是允许上传文件 允许上传文件格式是GIF,JPG,BMP,SWF,JPEG,PNG
     * 
     * @param fileName
     *            文件名称
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
     * @param filePath
     *            文件路径
     * @param fileContent
     *            文件内容
     */
    public static void write(String filePath, String fileContent) {
        try (FileOutputStream fo = new FileOutputStream(filePath);
                OutputStreamWriter out = new OutputStreamWriter(fo, StandardCharsets.UTF_8);) {
            out.write(fileContent);
        } catch (Exception ex) {
            logger.error("write exception", ex);
        }
    }

    /**
     * 读取文件内容 默认是UTF-8编码
     * 
     * @param filePath
     *            文件路径
     * @return 文件内容
     */
    @Deprecated
    public static String read(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        File file = new File(filePath);

        try (InputStreamReader read = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(read);) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line + "\n");
            }
        } catch (Exception ex) {
            fileContent = new StringBuilder("");
            logger.error(ex);
        }
        return fileContent.toString();
    }
    
    public static String readFileUseBuffedInputream(String filePath) {
    
        byte[] buff = new byte[4096];
        StringBuffer sb = new StringBuffer();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath));) {
            
            int len;
            while ((len = in.read(buff)) != -1) {  
                 sb.append(new String(buff, 0, len));
            }
          
        } catch (Exception ex) {
            logger.error("读取文件出现异常",ex);
        }
        
        return sb.toString();
    
    }

    /**
     * 删除文件或文件夹
     * 
     * @param filePath
     *            文件路径
     */
    public static boolean delete(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                return file.delete();
            }
        } catch (Exception ex) {
            logger.error(ex);
        }
        return true;
    }

    /**
     * 判断文件是否存在
     * 
     * @param filepath
     *            文件路径
     * @return 是否
     */
    public static boolean exist(String filepath) {
        File file = new File(filepath);
        return file.exists();
    }

    /**
     * 创建文件夹
     * 
     * @param filePath
     *            文件路径
     */
    public static void createFolder(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception ex) {
            logger.error("createFolder  Error:" + ex.getMessage(), ex);
        }
    }

    /**
     * 读取文件
     * 
     * @param resource
     *            文件名称
     * @return 文件内容
     */
    public static String readFile(String resource) {
        InputStream stream = getResourceAsStream(resource);
        return readStreamToString(stream);
    }

    /**
     * 读取文件
     * 
     * @param resource
     *            文件名称
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
     * 
     * @param stream
     *            输入流
     * @return 将输入流转换成字符
     */
    public static String readStreamToString(InputStream stream) {
        StringBuilder fileContent = new StringBuilder();

        try (InputStreamReader read = new InputStreamReader(stream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(read);) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line + "\n");
            }
        } catch (Exception ex) {
            fileContent = new StringBuilder();
        }
        return fileContent.toString();
    }

    public static byte[] readStreamToByte(InputStream stream)  {
        String fileContent = readStreamToString(stream);
        return fileContent.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 字符串转换成输入流
     * 
     * @param text
     *            字符串
     * @return 字符串转换成输入流
     */
    public static InputStream getStreamFromString(String text) {
        try {
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            return new ByteArrayInputStream(bytes);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    /**
     * 输入流转化成字节
     * 
     * @param in
     *            输入流
     * @return 字节
     * @throws IOException
     *             IO异常
     */
    public static byte[] readBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        transfer(in, out);
        return out.toByteArray();
    }

    /**
     * 输入流输出流转化
     * 
     * @param in
     *            输入流
     * @param out
     *            输出流
     * @return 转换数量
     * @throws IOException
     *             IO异常
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
    
    public static void deleteDirectory(File directory) throws IOException {
        if (!directory.exists()) {
          return;
        }

        cleanDirectory(directory);
        if (!directory.delete()) {
          String message = "Unable to delete directory " + directory + ".";
          throw new IOException(message);
        }
      }

      public static boolean deleteQuietly(File file) {
        if (file == null)
          return false;
        try {
          if (file.isDirectory())
            cleanDirectory(file);
        } catch (Exception e) {
            return false;
        }
        try {
          return file.delete();
        } catch (Exception e) {
            return false;
        }
       
      }

      public static void cleanDirectory(File directory) throws IOException {
        if (!directory.exists()) {
          String message = directory + " does not exist";
          throw new IllegalArgumentException(message);
        }

        if (!directory.isDirectory()) {
          String message = directory + " is not a directory";
          throw new IllegalArgumentException(message);
        }

        File[] files = directory.listFiles();
        if (files == null) {
          throw new IOException("Failed to list contents of " + directory);
        }

        IOException exception = null;
        for (int i = 0; i < files.length; i++) {
          File file = files[i];
          try {
            forceDelete(file);
          } catch (IOException ioe) {
            exception = ioe;
          }
        }

        if (null != exception)
          throw exception;
      }

      public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
          deleteDirectory(file);
        } else {
          boolean filePresent = file.exists();
          if (!file.delete()) {
            if (!filePresent) {
              throw new FileNotFoundException("File does not exist: " + file);
            }
            String message = "Unable to delete file: " + file;

            throw new IOException(message);
          }
        }
      }

      public static void copyFileUsingFileStreams(File source, File dest)
              throws IOException {
          try (InputStream input = new FileInputStream(source);
                  OutputStream    output = new FileOutputStream(dest); )  {
              
              byte[] buf = new byte[1024];
              int bytesRead;
              while ((bytesRead = input.read(buf)) > 0) {
                  output.write(buf, 0, bytesRead);
              }
          }catch (Exception e ) {
              logger.error("文件流方式复制文件出现错误"+source.getAbsolutePath()  +" --> " + dest.getAbsolutePath() );
          }
      }
   
      public static void copyFileUsingFileChannels(File source, File dest)
              throws IOException {
          try (FileChannel inputChannel = new FileInputStream(source).getChannel();
                  FileChannel outputChannel = new FileOutputStream(dest).getChannel();
                  ) {
              outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
          }catch (Exception e ) {
              logger.error("复制文件出现错误"+source.getAbsolutePath()  +" --> " + dest.getAbsolutePath() );
          }
      }
   
      public static void copyFileUsingJava7Files(File source, File dest)
              throws IOException {
          Files.copy(source.toPath(), dest.toPath());
      }
      
      /**
       * NIO —— MappedByteBuffer 分割拷贝大文件
       * @throws FileNotFoundException 
       * @throws IOException
       * 
       * 
       * 测试：拷贝4.96GB 电影：720p高清阿凡达178分钟加长收藏版.mkv 用时：4分钟0.1秒
       * 机器配置：联想Z460 i5CPU 2.53GHz 4GB内存 500GB硬盘 1GB显存
       * 
       */
      public static void nioCopyFile(File sourcePathFile , File targetPathFile) throws  IOException {
          long before = System.currentTimeMillis();
          
          File files = sourcePathFile;    //源文件
          File filet = targetPathFile;    //目标文件
          
          long size = files.length();         // 文件总大小
          long copycount = size * 2 / Integer.MAX_VALUE; //获取读、写之和所占用虚拟内存 倍数
          int copynum = copycount >= 1 ? (int) copycount + 2 : (int) copycount + 1; // 根据倍数确认分割份数
   
          long countSize = Integer.MAX_VALUE  / copynum;  //每块分割大小<每次读写的大小>                                                           
          long lontemp = countSize;       //初始读、写大小
          try (
              FileChannel channels = new RandomAccessFile(files, "r").getChannel();       //得到映射读文件的通道
              FileChannel channelt = new RandomAccessFile(filet, "rw").getChannel();      //得到映射写文件的通道
                  ) {
       
              long j = 0; // 每次循环累加字节的起始点
              MappedByteBuffer mbbs = null; // 声明读源文件对象
              MappedByteBuffer mbbt = null; // 声明写目标文件对象
              while (j < size) {
                  mbbs = channels.map(FileChannel.MapMode.READ_ONLY, j, lontemp);     //每次读源文件都重新构造对象
                  mbbt = channelt.map(FileChannel.MapMode.READ_WRITE, j, lontemp);    //每次写目标文件都重新构造对象
                  for (int i = 0; i < lontemp; i++) {
                      byte b = mbbs.get(i);           //从源文件读取字节
                      mbbt.put(i, b);                 //把字节写到目标文件中
                  }
                  System.gc();                //手动调用 GC       <必须的，否则出现异常>
                  System.runFinalization();   //运行处于挂起终止状态的所有对象的终止方法。<必须的，否则出现异常>
                  j += lontemp;               //累加每次读写的字节
                  lontemp = size - j;         //获取剩余字节
                  lontemp = lontemp > countSize ? countSize : lontemp;    //如果剩余字节 大于 每次分割字节 则 读取 每次分割字节 ，否则 读取剩余字节
              }
          
          }catch (Exception e ) {
              logger.error("Nio复制文件出现错误"+files.getAbsolutePath()  +" --> " + filet.getAbsolutePath() );
          }
          
          logger.info("MillTime : "
                  + (double) (System.currentTimeMillis() - before) / 1000 + "s");
      }
      
      public static File mkdir(String dir, String file) {
    	    if (dir == null)
    	      throw new IllegalArgumentException("dir must be not null");
    	    File result = new File(dir, file);
    	    parentMkdir(result);
    	    return result;
     }

    	  public static File parentMkdir(String file) {
    	    if (file == null)
    	      throw new IllegalArgumentException("file must be not null");
    	    File result = new File(file);
    	    parentMkdir(result);
    	    return result;
    	  }

    	  public static void parentMkdir(File outputFile) {
    	    File parentFile = outputFile.getParentFile();
    	    if (parentFile != null && !parentFile.equals(outputFile)) {
    	      parentFile.mkdirs();
    	    }
    	  }
    	  
}
