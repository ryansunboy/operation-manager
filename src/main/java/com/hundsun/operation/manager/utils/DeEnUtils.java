package com.hundsun.operation.manager.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * 加密解密方式
 * @author Ryan
 * @date 2018-12-29.
 */
public class DeEnUtils {

    private static int encryptMode =1;


    /**
     * DES 加密
     * @param srcString
     * @return
     */
    public static String doDEScrypt( String srcString,String salt)
    {
        try
        {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(salt.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(encryptMode, securekey, random);
            if (encryptMode == 1)
            {
                byte[] byteResult = cipher.doFinal(srcString.getBytes());
                return Base64.encodeBase64String(byteResult);
            }
            byte[] tmpString = Base64.decodeBase64(srcString.getBytes());
            byte[] byteResult = cipher.doFinal(tmpString);
            return new String(byteResult);
        }
        catch (Throwable execption)
        {
            if (encryptMode == 1) {
                throw new RuntimeException("DES加密失败,content=" + srcString, execption);
            }
            throw new RuntimeException("DES解密失败,content=" + srcString, execption);
        }
    }
    public static String decryptor(String data,String key) throws Exception {  //对string进行BASE64Encoder转换
        sun.misc.BASE64Decoder base64en = new sun.misc.BASE64Decoder();
        byte[] bt = decrypt(base64en.decodeBuffer(data), key);
        String strs = new String(bt);
        return strs;
    }
    /**
     * 解密
     * @param src byte[]
     * @param key String
     * @return byte[]
     * @throws Exception
     */
    private static byte[] decrypt(byte[] src, String key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }

}
