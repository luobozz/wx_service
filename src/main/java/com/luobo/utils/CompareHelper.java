package com.luobo.utils;

import java.math.BigDecimal;
import java.util.List;

/**
 * CompareHandle class
 *
 * @author chenlingyu
 * @date 2020/5/7 15:10
 */
public class CompareHelper {

    public static boolean isEmptyList(List list){
        if(list==null){
            return true;
        }
        if(list.size()==0){
            return true;
        }
        return false;
    }

    public static int longCompare(Long aLong, Long bLong) {
        int ret=-99;
        if(aLong!=null&&bLong!=null){
            ret=Long.compare(aLong, bLong);
        }
        return ret;
    }

    public static int longCompare(Long aLong, int b) {
        int ret=-99;
        if(aLong!=null){
            Long bLong = new Long(b);
            ret=Long.compare(aLong, bLong);
        }
        return ret;
    }

    public static int longCompare(Long aLong, String b) {
        int ret=-99;
        if(aLong!=null){
            Long bLong = new Long(b);
            ret=Long.compare(aLong, bLong);
        }
        return ret;
    }

    public static int bigDecimalCompare(BigDecimal aBigDecimal, BigDecimal bBigDecimal) {
        int ret=-99;
        if(aBigDecimal!=null&&bBigDecimal!=null){
            ret=aBigDecimal.compareTo(bBigDecimal);
        }
        return ret;
    }

    public static int bigDecimalCompare(BigDecimal aBigDecimal, double b) {
        int ret=-99;
        if(aBigDecimal!=null){
            BigDecimal bBigDecimal = new BigDecimal(b);
            ret=aBigDecimal.compareTo(bBigDecimal);
        }
        return ret;
    }

    public static int bigDecimalCompare(BigDecimal aBigDecimal, int b) {
        int ret=-99;
        if(aBigDecimal!=null){
            BigDecimal bBigDecimal = new BigDecimal(b);
            ret=aBigDecimal.compareTo(bBigDecimal);
        }
        return ret;
    }

    public static int bigDecimalCompare(BigDecimal aBigDecimal, String b) {
        int ret=-99;
        if(aBigDecimal!=null){
            BigDecimal bBigDecimal = new BigDecimal(b);
            ret=aBigDecimal.compareTo(bBigDecimal);
        }
        return ret;
    }


    public static int integerCompare(Integer aInteger, Integer bInteger) {
        int ret=-99;
        if(aInteger!=null&&bInteger!=null){
            ret=Integer.compare(aInteger, bInteger);
        }
        return ret;
    }

    public static int integerCompare(Integer aInteger, int b) {
        int ret=-99;
        if(aInteger!=null){
            Integer bInteger = new Integer(b);
            ret=Integer.compare(aInteger, bInteger);
        }
        return ret;
    }

    public static int integerCompare(Integer aInteger, String b) {
        int ret=-99;
        if(aInteger!=null){
            Integer bInteger = new Integer(b);
            ret=Integer.compare(aInteger, bInteger);
        }
        return ret;
    }

}
