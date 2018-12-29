package com.wd.tech.util;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by xyj on 2018/9/1.
 */
public class RsaCoder {

    //非对称密钥算法
    public static final String KEY_ALGORITHM="RSA";

    //私钥
    private static PrivateKey privateKey;

    //公钥
    private static PublicKey publicKey;

    //初始化
    static {
        privateKey = getPrivateKey(KEY_ALGORITHM);
        publicKey = getPublicKey(KEY_ALGORITHM);
    }

    /**
     *  获取私钥
     * @param algorithm
     * @return
     */
    private static PrivateKey getPrivateKey(String algorithm) {
        try {
            String key = PropertiesUtil.getRsaFileContent("properties/message.key", "utf-8");
            byte [] decoded = Base64.decode(key);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
            KeyFactory kf = KeyFactory.getInstance(algorithm);
            return kf.generatePrivate(spec);
        }catch (Exception e) {
            return null;
        }
    }

    /**
     *  获取公钥
     * @param algorithm
     * @return
     */
    private static PublicKey getPublicKey(String algorithm) {
        try {
            String key = PropertiesUtil.getRsaFileContent("properties/message_client.cer", "utf-8");
            byte [] decoded = Base64.decode(key);
            KeyFactory keyFactory=KeyFactory.getInstance(algorithm);
            X509EncodedKeySpec x509KeySpec=new X509EncodedKeySpec(decoded);
            return keyFactory.generatePublic(x509KeySpec);
        }catch (Exception e) {
            return null;
        }
    }

    /**
     *  私钥加密数据
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptByPrivateKey(String data){
        try {

            if(null == data || "".equals(data))
            {
                return null;
            }

            byte[] key = privateKey.getEncoded();
            byte[] datas = data.getBytes();
            //取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec=new PKCS8EncodedKeySpec(key);
            KeyFactory keyFactory= KeyFactory.getInstance(KEY_ALGORITHM);
            //生成私钥
            PrivateKey privateKey=keyFactory.generatePrivate(pkcs8KeySpec);
            //数据加密
            Cipher cipher=Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return Base64.encode(cipher.doFinal(datas));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *  公钥解密
     * @param data
     * @return
     * @throws Exception
     */
    public static String decryptByPublicKey(String data) throws Exception{
        try {

            if(null == data || "".equals(data))
            {
                return null;
            }

            byte[] key = publicKey.getEncoded();
            byte[] datas = Base64.decode(data);
            //实例化密钥工厂
            KeyFactory keyFactory=KeyFactory.getInstance(KEY_ALGORITHM);
            //初始化公钥
            //密钥材料转换
            X509EncodedKeySpec x509KeySpec=new X509EncodedKeySpec(key);
            //产生公钥
            PublicKey pubKey=keyFactory.generatePublic(x509KeySpec);
            //数据解密
            Cipher cipher=Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, pubKey);
            return new String(cipher.doFinal(datas));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     *  公钥加密
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data) throws Exception{
        try {
            if(null == data || "".equals(data))
            {
                return null;
            }

            byte[] key = publicKey.getEncoded();
            byte[] datas = data.getBytes();
            //实例化密钥工厂
            KeyFactory keyFactory=KeyFactory.getInstance(KEY_ALGORITHM);
            //初始化公钥
            //密钥材料转换
            X509EncodedKeySpec x509KeySpec=new X509EncodedKeySpec(key);
            //产生公钥
            PublicKey pubKey=keyFactory.generatePublic(x509KeySpec);

            //数据加密
            Cipher cipher=Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            return Base64.encode(cipher.doFinal(datas));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *  私钥解密
     * @param data
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data){
        try {

            if(null == data || "".equals(data))
            {
                return null;
            }

            byte[] key = privateKey.getEncoded();
            byte[] datas = Base64.decode(data);
            //取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec=new PKCS8EncodedKeySpec(key);
            KeyFactory keyFactory=KeyFactory.getInstance(KEY_ALGORITHM);
            //生成私钥
            PrivateKey privateKey=keyFactory.generatePrivate(pkcs8KeySpec);
            //数据解密
            Cipher cipher=Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(cipher.doFinal(datas));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        //私钥加密数据
        String str1 = encryptByPrivateKey("123456");
        System.out.println(str1);
//        //公钥解密数据
//        System.out.println(decryptByPublicKey(str1));

        //公钥加密
        String str2 = encryptByPublicKey("你好啊");
        System.out.println("第一次"+str2);
//        str2 = encryptByPublicKey("888");
//        System.out.println("第二次"+str2);
        //私钥解密
        System.out.println(decryptByPrivateKey("p5YPvunImFlUQJOHHIpYhHK3X2LHBdtAJyw9G2Q6+8GG2UIOGAscIPzc9En+phV4s7MmTZ29ZPd5CYT4lgaMytWSiSaS3InQRpLiBV3ibPFPnAkEFBIf2kKck1wKjbC04T9jbpx7r5MsYNIR8LyrdQ/uFNJm6xX21Q3qzeUfjlg="));


    }
}
