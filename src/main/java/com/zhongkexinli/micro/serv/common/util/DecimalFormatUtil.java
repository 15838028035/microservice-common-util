package com.zhongkexinli.micro.serv.common.util;

import java.text.DecimalFormat;

public class DecimalFormatUtil {

    /**
     * 格式化
     * @param div1
     * @param div2
     * @return
     */
    public static String format( long div1, long div2) {
        if(div2 ==0) {
            return "0.00%";
        }
        Double d   = BigDecimalUtil.div(div1, div2)*100;
        DecimalFormat df = new DecimalFormat("###0.00");
        return  df.format(d) +"%";
    }
    
    /**
     * 格式化
     * @param div1
     * @param div2
     * @return
     */
    public static String format( int div1, int div2) {
        if(div2 ==0) {
            return "0.00%";
        }
        Double d   = BigDecimalUtil.div(div1, div2)*100;
        DecimalFormat df = new DecimalFormat("###0.00");
        return  df.format(d) +"%";
    }
    
    /**
     * 格式化
     * @param div1
     * @param div2
     * @return
     */
    public static String format( double div1, double div2) {
        if(div2 ==0) {
            return "0.00%";
        }
        Double d   = BigDecimalUtil.div(div1, div2)*100;
        DecimalFormat df = new DecimalFormat("###0.00");
        return  df.format(d) +"%";
    }
}
