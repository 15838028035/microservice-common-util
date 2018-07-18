package com.zhongkexinli.micro.serv.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import com.zhongkexinli.micro.serv.common.util.FileUtil;

public class FileUtilTest {

  private static Log logger = LogFactory.getLog(FileUtilTest.class);
  @Test
  public void createFileInputStreamTest() {
    // TODO:test me
  }

  @Test
  public void isAllowUpTest() {
    assertTrue(FileUtil.isAllowUp("1.GIF"));
    assertTrue(FileUtil.isAllowUp("1.JPG"));
    assertTrue(FileUtil.isAllowUp("1.BMP"));
    assertTrue(FileUtil.isAllowUp("1.SWF"));
    assertTrue(FileUtil.isAllowUp("1.JPEG"));
    assertTrue(FileUtil.isAllowUp("1.PNG"));

    assertTrue(FileUtil.isAllowUp("1.gif"));
    assertTrue(FileUtil.isAllowUp("1.jpg"));
    assertTrue(FileUtil.isAllowUp("1.bmp"));
    assertTrue(FileUtil.isAllowUp("1.swf"));
    assertTrue(FileUtil.isAllowUp("1.jpeg"));
    assertTrue(FileUtil.isAllowUp("1.png"));

    assertTrue(FileUtil.isAllowUp("1.Gif"));
    assertTrue(FileUtil.isAllowUp("1.Jpg"));
    assertTrue(FileUtil.isAllowUp("1.Bmp"));
    assertTrue(FileUtil.isAllowUp("1.sWf"));
    assertTrue(FileUtil.isAllowUp("1.JPeg"));
    assertTrue(FileUtil.isAllowUp("1.Png"));

    assertFalse(FileUtil.isAllowUp("1.GifX"));
    assertFalse(FileUtil.isAllowUp("1.JpgX"));
    assertFalse(FileUtil.isAllowUp("1.BmpX"));
    assertFalse(FileUtil.isAllowUp("1.sWfX"));
    assertFalse(FileUtil.isAllowUp("1.JPegX"));
    assertFalse(FileUtil.isAllowUp("1.PngX"));

    assertFalse(FileUtil.isAllowUp(null));
    assertFalse(FileUtil.isAllowUp(""));
    assertFalse(FileUtil.isAllowUp(" "));
    assertFalse(FileUtil.isAllowUp("1.A"));
    assertFalse(FileUtil.isAllowUp("1.a"));
  }

  @Test
  public void writeTest() throws Exception {
    String filePath = "d://fileTest/1.txt";
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:test1.txt");
    } catch (Exception e) {
      logger.error(e);
    }

    if (file == null) {
      return;
    }
    assertTrue(FileUtil.exist(filePath));

    FileUtil.write(filePath, "test1");

    String content = FileUtil.read(filePath, "UTF-8");

    assertTrue(content.contains("test1"));

    assertFalse(FileUtil.exist(filePath));
  }

  @Test
  public void writeExceptionTest() throws Exception {
    String filePath = "filePathNot found";
    FileUtil.write(filePath, "test1");
  }

  @Test
  public void readTest() {

  }

  @Test
  public void readExceptionTest() {
    String filePath = "filePathNotFound1";
    String content = FileUtil.read(filePath, "UTF-8");
    assertEquals("", content);
  }

  @Test
  public void deleteTest() {
    String filepath = "d://fileTest";
    FileUtil.createFolder(filepath);
    assertTrue(FileUtil.exist(filepath));
    FileUtil.delete(filepath);
    assertTrue(FileUtil.exist(filepath));
  }

  @Test
  public void deleteExceptionTest() {
    String filepath = "fileNotFoundException";
    FileUtil.delete(filepath);
    assertFalse(FileUtil.exist(filepath));
  }

  @Test
  public void existTest() {
    String filepath = "d://fileTest";
    FileUtil.createFolder(filepath);
    assertTrue(FileUtil.exist(filepath));
    FileUtil.delete(filepath);
    assertTrue(FileUtil.exist(filepath));
  }

  @Test
  public void createFolderTest() {
    String filepath = "d://fileTest";
    FileUtil.createFolder(filepath);
    assertTrue(FileUtil.exist(filepath));
    FileUtil.delete(filepath);
    assertTrue(FileUtil.exist(filepath));
  }

  @Test
  public void createFolderExceptionTest() {
    String filepath = "badFileFolder";
    FileUtil.createFolder(filepath);
    assertTrue(FileUtil.exist(filepath));
    FileUtil.delete(filepath);
    assertTrue(FileUtil.exist(filepath));
  }

  @Test
  public void createFileTest() {
    // TODO:test me
  }

  public void readFileTest() {
    // TODO:test me
  }

  @Test
  public void getResourceAsStreamTest() {
    // TODO:test me
  }

  @Test
  public void testReadStreamToString() {
    // TODO:test me
  }

  @Test
  public void removeFileTest() {
    // TODO:test me
  }

  @Test
  public void copyFileTest() {
    // TODO:test me
  }

  @Test
  public void copyFolderTest() {
    // TODO:test me
  }

}
