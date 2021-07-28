package cn.caitc.entity;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_calendar
 */
public class Tcalendar implements Serializable {
    /**
     *   自然日日期
     */
    private String cDate;

    /**
     *   是否为工作日 0-工作日 1-假日 2-节日
     */
    private String cType;

    /**
     *   日期描述
     */
    private String cTypename;

    /**
     *   年份
     */
    private String cYearname;

    /**
     *   农历
     */
    private String cNonglicn;

    /**
     *   农历月份
     */
    private String cNongli;

    /**
     *   生肖年
     */
    private String cAnimalsYear;

    /**
     *   节气
     */
    private String cThrottle;

    /**
     *   周-中文
     */
    private String cWeekcn;

    /**
     *   周期英文缩写
     */
    private String cWeek1;

    /**
     *   周期数字
     */
    private String cWeek2;

    /**
     *   周期英文
     */
    private String cWeek3;

    /**
     *   天数
     */
    private String cDaynum;

    /**
     *   周数
     */
    private String cWeeknum;

    /**
     *   宜
     */
    private String cSuit;

    /**
     *   忌
     */
    private String cAvoid;

    /**
     *   假日描述
     */
    private String cDesc;

    /**
     * This field corresponds to the database table t_calendar
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_type
     *
     * @return the value of t_calendar.c_type
     *
     * @mbg.generated
     */
    public String getcType() {
        return cType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_type
     *
     * @param cType the value for t_calendar.c_type
     *
     * @mbg.generated
     */
    public void setcType(String cType) {
        this.cType = cType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_typename
     *
     * @return the value of t_calendar.c_typename
     *
     * @mbg.generated
     */
    public String getcTypename() {
        return cTypename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_typename
     *
     * @param cTypename the value for t_calendar.c_typename
     *
     * @mbg.generated
     */
    public void setcTypename(String cTypename) {
        this.cTypename = cTypename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_yearname
     *
     * @return the value of t_calendar.c_yearname
     *
     * @mbg.generated
     */
    public String getcYearname() {
        return cYearname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_yearname
     *
     * @param cYearname the value for t_calendar.c_yearname
     *
     * @mbg.generated
     */
    public void setcYearname(String cYearname) {
        this.cYearname = cYearname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_nonglicn
     *
     * @return the value of t_calendar.c_nonglicn
     *
     * @mbg.generated
     */
    public String getcNonglicn() {
        return cNonglicn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_nonglicn
     *
     * @param cNonglicn the value for t_calendar.c_nonglicn
     *
     * @mbg.generated
     */
    public void setcNonglicn(String cNonglicn) {
        this.cNonglicn = cNonglicn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_nongli
     *
     * @return the value of t_calendar.c_nongli
     *
     * @mbg.generated
     */
    public String getcNongli() {
        return cNongli;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_nongli
     *
     * @param cNongli the value for t_calendar.c_nongli
     *
     * @mbg.generated
     */
    public void setcNongli(String cNongli) {
        this.cNongli = cNongli;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_animals_year
     *
     * @return the value of t_calendar.c_animals_year
     *
     * @mbg.generated
     */
    public String getcAnimalsYear() {
        return cAnimalsYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_animals_year
     *
     * @param cAnimalsYear the value for t_calendar.c_animals_year
     *
     * @mbg.generated
     */
    public void setcAnimalsYear(String cAnimalsYear) {
        this.cAnimalsYear = cAnimalsYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_throttle
     *
     * @return the value of t_calendar.c_throttle
     *
     * @mbg.generated
     */
    public String getcThrottle() {
        return cThrottle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_throttle
     *
     * @param cThrottle the value for t_calendar.c_throttle
     *
     * @mbg.generated
     */
    public void setcThrottle(String cThrottle) {
        this.cThrottle = cThrottle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_weekcn
     *
     * @return the value of t_calendar.c_weekcn
     *
     * @mbg.generated
     */
    public String getcWeekcn() {
        return cWeekcn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_weekcn
     *
     * @param cWeekcn the value for t_calendar.c_weekcn
     *
     * @mbg.generated
     */
    public void setcWeekcn(String cWeekcn) {
        this.cWeekcn = cWeekcn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_week1
     *
     * @return the value of t_calendar.c_week1
     *
     * @mbg.generated
     */
    public String getcWeek1() {
        return cWeek1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_week1
     *
     * @param cWeek1 the value for t_calendar.c_week1
     *
     * @mbg.generated
     */
    public void setcWeek1(String cWeek1) {
        this.cWeek1 = cWeek1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_week2
     *
     * @return the value of t_calendar.c_week2
     *
     * @mbg.generated
     */
    public String getcWeek2() {
        return cWeek2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_week2
     *
     * @param cWeek2 the value for t_calendar.c_week2
     *
     * @mbg.generated
     */
    public void setcWeek2(String cWeek2) {
        this.cWeek2 = cWeek2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_week3
     *
     * @return the value of t_calendar.c_week3
     *
     * @mbg.generated
     */
    public String getcWeek3() {
        return cWeek3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_week3
     *
     * @param cWeek3 the value for t_calendar.c_week3
     *
     * @mbg.generated
     */
    public void setcWeek3(String cWeek3) {
        this.cWeek3 = cWeek3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_daynum
     *
     * @return the value of t_calendar.c_daynum
     *
     * @mbg.generated
     */
    public String getcDaynum() {
        return cDaynum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_daynum
     *
     * @param cDaynum the value for t_calendar.c_daynum
     *
     * @mbg.generated
     */
    public void setcDaynum(String cDaynum) {
        this.cDaynum = cDaynum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_weeknum
     *
     * @return the value of t_calendar.c_weeknum
     *
     * @mbg.generated
     */
    public String getcWeeknum() {
        return cWeeknum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_weeknum
     *
     * @param cWeeknum the value for t_calendar.c_weeknum
     *
     * @mbg.generated
     */
    public void setcWeeknum(String cWeeknum) {
        this.cWeeknum = cWeeknum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_suit
     *
     * @return the value of t_calendar.c_suit
     *
     * @mbg.generated
     */
    public String getcSuit() {
        return cSuit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_suit
     *
     * @param cSuit the value for t_calendar.c_suit
     *
     * @mbg.generated
     */
    public void setcSuit(String cSuit) {
        this.cSuit = cSuit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_avoid
     *
     * @return the value of t_calendar.c_avoid
     *
     * @mbg.generated
     */
    public String getcAvoid() {
        return cAvoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_avoid
     *
     * @param cAvoid the value for t_calendar.c_avoid
     *
     * @mbg.generated
     */
    public void setcAvoid(String cAvoid) {
        this.cAvoid = cAvoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_calendar.c_desc
     *
     * @return the value of t_calendar.c_desc
     *
     * @mbg.generated
     */
    public String getcDesc() {
        return cDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_calendar.c_desc
     *
     * @param cDesc the value for t_calendar.c_desc
     *
     * @mbg.generated
     */
    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }
}