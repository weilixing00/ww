package com.xg.insure.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by admin on 2016/4/6.
 */
public class MathUtil {

    //正则表达式判断 6-16位数 字母,数字,标点符号混合
    public static boolean pswFilter(String str) throws PatternSyntaxException {
//        String regEx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        String regEx = "(?!^[0-9]+$)(?!^[a-z]+$)(?!^[A-Z]+$)(?!^[a-zA-Z]+$)(?!^[^A-z0-9]+$)^.{6,16}$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    //正则表达式判断真实姓名为中文
    public static boolean realNameFilter(String str) throws PatternSyntaxException {
        // 只允许字母和数字
        String regEx = "^[\\u4e00-\\u9fa5]{0,}$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    //正则表达式判断身份证号
    public static boolean identityCardFilter(String str) throws PatternSyntaxException {
        // 只允许字母和数字
        String regEx = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }



    //正则表达式判断手机号
    public static boolean phoneNumFilter(String str) throws PatternSyntaxException {
//        String regEx = "^((13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$";
        String regEx = "^((13\\d{9}$)|(15[0,1,2,3,5,6,7,8,9]\\d{8}$)|(18[0,2,3,4,5,6,7,8,9]\\d{8}$)|(147\\d{8})$)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }



    // 将时间戳转为字符串 带时分秒
    public static String getStrTime(String cc_time) {
        String re_StrTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
// 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time));
        return re_StrTime;
    }

    public static String getStrDate(String cc_time) {
        String re_StrTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
// 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time));
        return re_StrTime;
    }

    //转换为格式为"yyyy/MM/dd"的日期表达
    public static String getStrDateSprit(String cc_time) {
        String re_StrTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
// 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time));
        return re_StrTime;
    }

    //转换为格式为"yyyy-MM-dd"的日期表达
    public static String getStrDateLine(String cc_time) {
        String re_StrTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time));
        return re_StrTime;
    }

    //将分为单位转换成元为单位 带千分位
    public static String convertFen(String fen) {

        double fenL = Double.parseDouble(fen);
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumFractionDigits(2);
        String fenStr = instance.format(fenL / 100);

        return fenStr;
    }

    /**
     *  将分为单位转换成元为单位 带千分位 不带小数点 小数点后四舍五入
     *  fen  出入进来的分为单位的字符串
     *  return  返回的元为单位的字符转
     */


    public static String convertFenNoDecimalPoint(String fen) {
        double fenL = Double.parseDouble(fen);
        //变分为单位为元为单位
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumFractionDigits(0);
        String fenStr = instance.format(fenL / 100);
        //首先 移除千分号
        String s1 = removeDot(fenStr);

        //四舍五入
        String s = new BigDecimal(s1).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        //添加千分号
        DecimalFormat decimalFormat=new DecimalFormat("###,###");//添加千分号
        return   decimalFormat.format(Double.parseDouble(s));
    }

    /** 将分为单位转换为元为单位 带小数点 不带千分位 不存在四舍五入  */
    public static String changeF2Y(String amount) {

        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal("100") ,2 ,BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 保留两位小数 不改变大小 没有千分号
     *
     * @param d 传入数字
     * @return 传入数字保留两位小数之后的数字
     */
    public static double two(double d) {
        BigDecimal b = new BigDecimal(d);
        // BigDecimal.ROUND_HALF_UP  保持普通的四舍五入  从第三位小数开始
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }


    //保留小数位数
    public static String decimalsCount(int count,double number){
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumFractionDigits(count);
        return instance.format(number);
    }

    //移除字符串中出现的千分号","
    public static String removeDot(String numberStr){
        if (numberStr.contains(",")){
            numberStr=  numberStr.replace(",","");
        }
        return numberStr;
    }

    /**
     * 添加千分号 同时保留两位小数
     */
    public static String addThousandSign(String doubleStr){
        DecimalFormat decimalFormat=new DecimalFormat("###,##0.00");
        return   decimalFormat.format(Double.parseDouble(doubleStr));
    }
    /**
     * 添加千分号 同时没有小数
     */
    public static String addThousandSignNoDecimals(String doubleStr){
        DecimalFormat decimalFormat=new DecimalFormat(",###");

        return   decimalFormat.format(Double.parseDouble(doubleStr));
    }

}
