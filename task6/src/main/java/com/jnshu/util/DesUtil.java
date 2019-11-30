package com.jnshu.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.MessageDigest;

public class DesUtil {

    // 生成一个DES密钥，随机生成
    public static String getKey(){
        try {
            // 获取指定算法（DES）的密钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            // 初始化密钥，指定密钥大小，可自定义随机源，但需注意密钥长度必须是8的倍数
            keyGenerator.init(56);
            // 生成一个Key
            SecretKey generateKey = keyGenerator.generateKey();
            // 转变为字节数组
            byte[] encoded = generateKey.getEncoded();
            // 生成密钥字符串
            String encodeHexString = Hex.encodeHexString(encoded);
            return encodeHexString;
        } catch (Exception e) {
            e.printStackTrace();
            return "密钥生成错误.";
        }
    }

    // 加密
    public static String encryptor(String str,String Key){
        String s=null;
        try {
            DESKeySpec desKey = new DESKeySpec(Key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // 指定加密的算法
            Cipher cipher = Cipher.getInstance("DES");
            // 初始化密码器，用密钥 secretKey 进入加密模式，ENCRYPT_MODE
            cipher.init(Cipher.ENCRYPT_MODE,securekey);
            // 获得加密后的字节数组
            byte[] bytes=cipher.doFinal(str.getBytes());
            s= Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "加密错误.";
        }
        return s;
    }

    // 解密，步骤与加密一致，区别在于初始化的模式设置
    public static String decryptor(String buff,String Key){
        String s=null;
        try {
            DESKeySpec desKey = new DESKeySpec(Key.getBytes());
            // 指定解密的算法
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            // 初始化密码器，用密钥 secretKey 进入解密模式，DECRYPT_MODE
            cipher.init(Cipher.DECRYPT_MODE,securekey);
            // 先将密文转为数组，再获得解密后的字节数组
            byte[] responseByte=cipher.doFinal(Base64.decodeBase64(buff));
            s=new String(responseByte);
        } catch (Exception e) {
            e.printStackTrace();
            return "解密错误.";
        }
        return s;
    }

    //盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";
    // MD5 加密，不可逆
    public static String encryptMd5(String dataStr) {
        String result = "";
        try {
            // 加盐
            dataStr = dataStr + slat;
            // 生成MessageDigest对象，指定计算消息摘要所使用的算法
            MessageDigest m = MessageDigest.getInstance("MD5");
            // 传入字符串，需转为数组
            m.update(dataStr.getBytes("UTF8"));
            // 调用digest()方法加密
            byte[] s = m.digest();
            // 将加密结果转为16进制32位字符串
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}