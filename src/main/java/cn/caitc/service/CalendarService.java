package cn.caitc.service;

/**
 * @program: calendar
 * @description: 工作日历获取接口类
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-12-26 15:13
 */
public interface CalendarService {

    /**
     * 获取从开始日期到结束日期的日历数据
     * @param startStr  开始日期
     * @param endStr    结束日期
     * @throws Exception
     */
    void saveCalendar(String startStr, String endStr) throws Exception;
}

