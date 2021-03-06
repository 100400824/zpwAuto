package source.utls;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {

    public static final String dateFormat1 = "yyyy-MM-dd HH:mm:ss";
    public static final String dateFormat2 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String dateFormat3 = "yyyy-MM-dd-HH-mm-ss";

    public static void main(String[] args) {
//        getNowTime(GetTime.dateFormat2);
        getTimeDifference("2020-09-19 22:48:55.260", "2020-09-19 22:48:56.259");
    }

    public static String getNowTime(String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);//设置日期格式
        return df.format(new Date());
    }

    public static String getTimeDifference(String startTime, String endTime) {

        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long between = 0;
        try {
            java.util.Date begin = dfs.parse(startTime);
            java.util.Date end = dfs.parse(endTime);
            between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                - min * 60 * 1000 - s * 1000);
        if (s == 0 && min == 0) {
            return ms + "毫秒";
        } else if (min == 0) {
            return s + "秒" + ms + "毫秒";
        } else {
            return day + "天" + hour + "小时" + min + "分" + s + "秒" + ms + "毫秒";
        }

    }


}
