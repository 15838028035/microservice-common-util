package com.zhongkexinli.micro.serv.common.security;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.zhongkexinli.micro.serv.common.exception.EcnodeDecodeException;

/***
 * 
 * 加密工具类
 *
 */
public class DesUtil {

  private DesUtil() {
    
  }
  
  public static  final  String DES = "DES";
  public static final String DES_KEY = "wang!@#$%";

  /**
   * Description 根据键值进行加密
   * 
   * @param data 值
   * @return 根据键值进行加密
   * @throws Exception 异常
   */
  public static String encrypt(String data) throws EcnodeDecodeException {
    return encrypt(data, DES_KEY);
  }

  /**
   * Description 根据键值进行加密
   * 
   * @param data 值
   * @param key  加密键byte数组
   * @throws Exception 异常
   */
  public static String encrypt(String data, String key) throws EcnodeDecodeException {
    byte[] bt = encrypt(data.getBytes(), key.getBytes());
    Encoder encoder = Base64.getEncoder();
    String strs =  new String(encoder.encode(bt));
    return strs;
  }
  
  /**
   * Description 根据键值进行加密
   * 
   * @param data 值
   * @param key
   *          加密键byte数组
   * @return 据键值进行加密
   * @throws Exception 异常
   */
  public static byte[] encrypt(byte[] data, byte[] key) throws EcnodeDecodeException {
    try {
      // 生成一个可信任的随机数源
      SecureRandom sr = new SecureRandom();
  
      // 从原始密钥数据创建DESKeySpec对象
      DESKeySpec dks = new DESKeySpec(key);
  
      // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
      SecretKey securekey = keyFactory.generateSecret(dks);
  
      // Cipher对象实际完成加密操作
      Cipher cipher = Cipher.getInstance(DES);
  
      // 用密钥初始化Cipher对象
      cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
  
      return cipher.doFinal(data);
    } catch (Exception e) {
      throw new EcnodeDecodeException(e);
    }
  }

  /**
   * Description 根据键值进行解密
   * 
   * @param data  值
   * @return 根据键值进行解密
   * @throws IOException 异常
   * @throws Exception 异常
   */
  public static String decrypt(String data) throws  EcnodeDecodeException {
    return decrypt(data, DES_KEY);
  }
   
  /**
   * Description 根据键值进行解密
   * 
   * @param data 值
   * @param key
   *          加密键byte数组
   * @return 根据键值进行解密
   * @throws IOException 异常
   * @throws Exception 异常
   */
  public static String decrypt(String data, String key) throws EcnodeDecodeException {
    if (data == null) {
      return null;
    }
    try {
      // 获取解密对象
      Decoder decoder = Base64.getDecoder();
      // 解密
      byte[] buf = decoder.decode(data);
      
      byte[] bt = decrypt(buf, key.getBytes());
      return new String(bt);
    } catch (Exception e) {
      throw new EcnodeDecodeException(e);
    }
  }
  
  /**
   * Description 根据键值进行解密
   * 
   * @param data 值
   * @param key  加密键byte数组
   * @return 根据键值进行解密
   * @throws Exception 异常
   */
  public static byte[] decrypt(byte []data, byte[] key) throws EcnodeDecodeException {
    try {
      // 生成一个可信任的随机数源
      SecureRandom sr = new SecureRandom();
  
      // 从原始密钥数据创建DESKeySpec对象
      DESKeySpec dks = new DESKeySpec(key);
  
      // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
      SecretKey securekey = keyFactory.generateSecret(dks);
  
      // Cipher对象实际完成解密操作
      Cipher cipher = Cipher.getInstance(DES);
  
      // 用密钥初始化Cipher对象
      cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
  
      return cipher.doFinal(data);
    } catch (Exception e) {
      throw new EcnodeDecodeException(e);
    }
  }
}