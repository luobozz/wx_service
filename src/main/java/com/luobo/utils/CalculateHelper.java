package com.luobo.utils;

import java.math.BigDecimal;

/**
 * CalculateHelper class
 *
 * @author chenlingyu
 * @date 2020/6/8 14:28
 */
public class CalculateHelper {

    /**
     * 提供精确的加法运算。
     * @param v1         被加数
     * @param v2          加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     * @param v1         被减数
     * @param v2          减数
     * @return 两个参数的相减结果
     */

    public static double subtract(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }



    /**
     * 提供精确的减法运算。
     * @param v1    被减数
     * @param v2    减数
     * @return 两个参数的差
     */

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @return 两个参数的积
     */

    public static double ride(double v1, double v2) {

        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        BigDecimal result = b1.multiply(b2);// 相乘结果

        return result.doubleValue();
    }
}
