package com.bm.oms.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
  private final static String[] hexDigits = {
      "0", "1", "2", "3", "4", "5", "6", "7",
      "8", "9", "a", "b", "c", "d", "e", "f"};

  public static String byteArrayToHexString(byte[] b)
  {
    StringBuffer resultSb = new StringBuffer();
    for (int i = 0; i < b.length; i++) {
      resultSb.append(byteToHexString(b[i]));
    }
    return resultSb.toString();
  }

  private static String byteToHexString(byte b)
  {
    int n = b;
    if (n < 0)
      n = 256 + n;
    int d1 = n / 16;
    int d2 = n % 16;
    return hexDigits[d1] + hexDigits[d2];
  }

  public static String MD5Encode(String origin)
  {
//    String resultString = null;
//    try {
//      resultString = new String(origin);
//      MessageDigest md = MessageDigest.getInstance("MD5");
//      resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
//    }
//    catch (Exception ex) {}
    return MD5Encode(origin,"UTF-8");
  }


    public static String MD5Encode(String origin,String code)
    {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes(code)));
        }
        catch (Exception ex) {}
        return resultString;
    }

    public static String md5(String sourceStr){
        String signStr = "";
        try {
            byte[] bytes = sourceStr.getBytes("utf-8");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(bytes);
            byte[] md5Byte = md5.digest();
            if (md5Byte != null) {
            	signStr = HexBinUtil.encode(md5Byte); 
            }
        } catch (NoSuchAlgorithmException e) { e.printStackTrace();
        } catch (UnsupportedEncodingException e) { e.printStackTrace();
        }
        return signStr;
    }


}
