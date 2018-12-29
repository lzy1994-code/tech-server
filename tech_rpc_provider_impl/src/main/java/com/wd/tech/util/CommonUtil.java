package com.wd.tech.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @program: tech-rpc
 * @description: 公共工具类
 * @author: Lzy
 * @create: 2018-08-28 16:27
 **/
public class CommonUtil {
    /**
     * 获取分页查询下标
     * @param page
     * @param count
     * @return
     */
    public static int getPageIndex(int page,int count){
        return (page-1)*count;
    }


    /**
     *  处理参数有效性
     * @param str
     * @param defaultValue
     * @return
     */
    public static int convert(String str, int defaultValue){
        if(str == null) return defaultValue;
        String s = str.trim();
        if(s.isEmpty()||s.equalsIgnoreCase("undefined")||s.equalsIgnoreCase("null")) return defaultValue;
        try {
            return Integer.parseInt(s);
        } catch (Throwable e) {
            return defaultValue;
        }
    }

    /**
     *  生成随机串
     * @param length
     * @return
     */
    public static String create_nonce_str(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     *  密码转换
     * @param pwd
     * @return
     */
    public static String conversionPwd(String pwd) {
        try {
            pwd = RsaCoder.decryptByPrivateKey(pwd);
            if(pwd == null)
            {
                return null;
            }
            pwd = RsaCoder.encryptByPrivateKey(pwd);
            return pwd;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 标签解析
     * @param source
     * @return
     */
    public static List<String> match(String source, String element, String attr) {
        List<String> result = new ArrayList<String>();
        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        return result;
    }

    /**
     *  生成随机串
     * @param length
     * @return
     */
    public static String createNonceStr(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     *  生成随机不重复的数组
     * @param length
     * @return
     */
    public static int[] generateRandomNumber(int length)
    {
        List<Integer> result = new ArrayList<>();
        int values[] = new int[length];
        int temp1,temp2,temp3;
        Random r = new Random();
        for(int i = 0;i < values.length;i++){
            values[i] = i + 1;
        }

        //随机交换values.length次
        for(int i = 0;i < values.length;i++){
            temp1 = Math.abs(r.nextInt()) % (values.length-1); //随机产生一个位置
            temp2 = Math.abs(r.nextInt()) % (values.length-1); //随机产生另一个位置

            if(temp1 != temp2){
                temp3 = values[temp1];
                values[temp1] = values[temp2];
                values[temp2] = temp3;
            }
        }
        return values;
    }

    // 压缩
    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toString();
    }

    // 解压缩
    public static String uncompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        // toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
        return out.toString();
    }

    public static void main(String []args)throws Exception
    {
        System.out.println(compress("12321"));
    }

}
