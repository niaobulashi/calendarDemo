package cn.caitc.service.impl;

import cn.caitc.entity.Tcalendar;
import cn.caitc.mapper.TcalendarMapper;
import cn.caitc.service.CalendarService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: calendarDemo
 * @description: 工作日历处理逻辑
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-12-26 15:32
 */
@Service
public class CalendarServiceImpl implements CalendarService {

    private Logger logger = LoggerFactory.getLogger(CalendarServiceImpl.class);

    @Autowired
    private TcalendarMapper calendarMapper;

    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    public static final String INFO = "1";

    /**
     * 获取从开始日期到结束日期的日历数据
     * @param startStr  开始日期
     * @param endStr    结束日期
     * @throws Exception
     */
    @Override
    public void saveCalendar(String startStr, String endStr) throws Exception {
        // 先获取两个时间段的日期进行循环
        Calendar compareDay = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date startDate = sdf.parse(startStr);
        Date endDate = sdf.parse(endStr);
        int differentDays = differentDays(startDate, endDate);
        System.out.println(startStr + " ~ " + endStr + " ,间隔天数为" + differentDays);
        for (int i = 0; i < differentDays; i++) {
            compareDay.setTime(startDate);
            compareDay.add(Calendar.DATE, i);
            String day = sdf.format(compareDay.getTime());
            System.out.println("日期：" + day);
            // 获取日期详情
            getRequest(day);
            // 等待5s，避免请求频率太快，被拉进黑名单
            TimeUnit.SECONDS.sleep(5);
        }
    }

    /**
     * date2比date1多的天数:比较是基于年月日做的比较,不计算时分秒
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        // 不同年
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    // 闰年
                    timeDistance += 366;
                } else {
                    // 不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1 + 1);
        } else {
            // 同一年
            // System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2 - day1 + 1;
        }
    }

    //1.获取当天的详细信息
    public void getRequest(String dateStr){
        Tcalendar cal = new Tcalendar();
        String result =null;
        // 请求接口地址
        String url ="http://tool.bitefu.net/jiari/";
        // 请求参数
        Map params = new HashMap();
        // 您申请的appKey
        params.put("info", INFO);
        // 指定日期,格式为YYYYMMDD,如月份和日期小于10,则取个位,如:20120101
        params.put("d", dateStr);
        try {
            // 发送请求
            result = net(url, params, "GET");
            System.out.println("返回报文：" + result);
            // 获取
            JSONObject object = JSONObject.fromObject(result);
            if(object.getString("status").equals("1")){

                // 根据日期和日期类型查询数据库中是否存在
                Tcalendar calendar = calendarMapper.selectByPrimaryKey(dateStr);
                // 若存在
                if (calendar != null) {
                    // 更新日历信息
                    updateCalendar(dateStr, cal, object);
                } else {
                    // 新增日历信息
                    insertCalendar(dateStr, cal, object);
                }
            } else {
                logger.info(object.get("success") + ":" + object.get("msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 更新日历信息
     * @param dateStr 日期
     * @param cal Tcalendar
     * @param object object
     */
    private void updateCalendar(String dateStr, Tcalendar cal, JSONObject object) {
        cal.setcDate(dateStr);
        cal.setcType(object.getString("type"));
        cal.setcTypename(object.getString("typename"));
        cal.setcYearname(object.getString("yearname"));
        cal.setcNonglicn(object.getString("nonglicn"));
        cal.setcNongli(object.getString("nongli"));
        cal.setcAnimalsYear(object.getString("shengxiao"));
        cal.setcThrottle(object.getString("jieqi"));
        cal.setcWeekcn(object.getString("weekcn"));
        cal.setcWeek1(object.getString("week1"));
        cal.setcWeek2(object.getString("week2"));
        cal.setcWeek3(object.getString("week3"));
        cal.setcDaynum(object.getString("daynum"));
        cal.setcWeeknum(object.getString("weeknum"));
        if (object.containsKey("avoid")) {
            cal.setcAvoid(object.getString("avoid"));
        }
        if (object.containsKey("suit")) {
            cal.setcSuit(object.getString("suit"));
        }
        calendarMapper.updateByPrimaryKeySelective(cal);
    }
    
    /**
     * 新增日历信息
     * @param dateStr 日期
     * @param cal Tcalendar
     * @param object object
     */
    private void insertCalendar(String dateStr, Tcalendar cal, JSONObject object) {
        cal.setcDate(dateStr);
        cal.setcType(object.getString("type"));
        cal.setcTypename(object.getString("typename"));
        cal.setcYearname(object.getString("yearname"));
        cal.setcNonglicn(object.getString("nonglicn"));
        cal.setcNongli(object.getString("nongli"));
        cal.setcAnimalsYear(object.getString("shengxiao"));
        cal.setcThrottle(object.getString("jieqi"));
        cal.setcWeekcn(object.getString("weekcn"));
        cal.setcWeek1(object.getString("week1"));
        cal.setcWeek2(object.getString("week2"));
        cal.setcWeek3(object.getString("week3"));
        cal.setcDaynum(object.getString("daynum"));
        cal.setcWeeknum(object.getString("weeknum"));
        if (object.containsKey("avoid")) {
            cal.setcAvoid(object.getString("avoid"));
        }
        if (object.containsKey("suit")) {
            cal.setcSuit(object.getString("suit"));
        }
        calendarMapper.insertSelective(cal);
    }
    
    /**
     * 发送请求
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String a = "1";
        String[] b = a.split("\\|");
        System.out.println(b[0]);
    }
}

