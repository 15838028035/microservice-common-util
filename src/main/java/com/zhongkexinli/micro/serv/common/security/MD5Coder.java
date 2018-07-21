package com.zhongkexinli.micro.serv.common.security;

import org.springframework.util.DigestUtils;

/**
 * MD5安全编码组件
 *
 * @version 1.0
 */
public class MD5Coder {

  public static byte[] encodeMd5(String data) throws Exception {
    byte[] bytes = data.getBytes();
    return DigestUtils.md5Digest(bytes);
  }

  public static byte[] md5DigestAsHex(String data) throws Exception {
    byte[] bytes = data.getBytes();
    return DigestUtils.md5DigestAsHex(bytes).getBytes();
  }
}
