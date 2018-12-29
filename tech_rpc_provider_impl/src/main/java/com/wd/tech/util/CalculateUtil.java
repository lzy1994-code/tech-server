package com.wd.tech.util;

import java.math.BigDecimal;

/**
 * Created by xyj on 2018/8/3.
 */
public class CalculateUtil {

    /**
     * 小数相加,四舍五入进位
     * @param arg1
     * @param arg2
     * @return
     */
    public static double add(double arg1,double arg2,int scale)
    {
        BigDecimal bd1 = new BigDecimal(Double.toString(arg1));
        BigDecimal bd2 = new BigDecimal(Double.toString(arg2));
        return bd1.add(bd2).setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 小数相减,四舍五入进位
     * @param arg1
     * @param arg2
     * @return
     */
    public static double subtract(double arg1,double arg2,int scale)
    {
        BigDecimal bd1 = new BigDecimal(Double.toString(arg1));
        BigDecimal bd2 = new BigDecimal(Double.toString(arg2));
        return bd1.subtract(bd2).setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 小数相乘,四舍五入进位
     * @param arg1
     * @param arg2
     * @return
     */
    public static double multiply(double arg1,double arg2,int scale)
    {
        BigDecimal bd1 = new BigDecimal(Double.toString(arg1));
        BigDecimal bd2 = new BigDecimal(Double.toString(arg2));
        return bd1.multiply(bd2).setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 小数相除,四舍五入进位
     * @param arg1
     * @param arg2
     * @return
     */
    public static double divide(double arg1,double arg2,int scale)
    {
        BigDecimal bd1 = new BigDecimal(Double.toString(arg1));
        BigDecimal bd2 = new BigDecimal(Double.toString(arg2));
        return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
