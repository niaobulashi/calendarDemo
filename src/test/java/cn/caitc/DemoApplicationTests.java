package cn.caitc;

import cn.caitc.service.CalendarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(value = false)
class DemoApplicationTests {

    @Autowired
    private CalendarService calendarService;

    @Test
    void contextLoads() {
    }

    @Test
    public void getCalendarInfo() throws Exception {

        /**
         * 获取从开始日期到结束日期的日历数据
         * @param startStr  开始日期
         * @param endStr    结束日期
         * 获取的数据为20191130-20191201两天数据
         */
        calendarService.saveCalendar("20210911", "20211231");
    }

}
