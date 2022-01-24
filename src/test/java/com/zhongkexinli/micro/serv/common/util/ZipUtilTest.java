package com.zhongkexinli.micro.serv.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;

public class ZipUtilTest {

    @Test
    public void toZip() {
        
        String srcDir = "D:\\install";
        try {
            OutputStream   out = new  BufferedOutputStream (new FileOutputStream(new File("d:\\test\\temp.zip")));
             ZipUtil.toZip(srcDir, out, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
     
    }

}
