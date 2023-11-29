-- Create table
create table T_CALENDAR
(
    c_date         NVARCHAR2(8) not null,
    c_type         NVARCHAR2(1),
    c_typename     NVARCHAR2(10),
    c_yearname     NVARCHAR2(4),
    c_nonglicn     NVARCHAR2(10),
    c_nongli       NVARCHAR2(10),
    c_animals_year NVARCHAR2(2),
    c_throttle     NVARCHAR2(10),
    c_weekcn       NVARCHAR2(2),
    c_week1        NVARCHAR2(6),
    c_week2        NVARCHAR2(1),
    c_week3        NVARCHAR2(10),
    c_daynum       NVARCHAR2(4),
    c_weeknum      NVARCHAR2(4),
    c_suit         NVARCHAR2(200),
    c_avoid        NVARCHAR2(200),
    c_desc         NVARCHAR2(200)
)
    tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table T_CALENDAR
  is '工作日历信息表';
-- Add comments to the columns
comment on column T_CALENDAR.c_date
  is '日期';
comment on column T_CALENDAR.c_type
  is '日期类型 0-工作日 1-假日 2-节日';
comment on column T_CALENDAR.c_typename
  is '日期描述';
comment on column T_CALENDAR.c_yearname
  is '年份';
comment on column T_CALENDAR.c_nonglicn
  is '农历';
comment on column T_CALENDAR.c_nongli
  is '农历月份';
comment on column T_CALENDAR.c_animals_year
  is '生肖年';
comment on column T_CALENDAR.c_throttle
  is '节气';
comment on column T_CALENDAR.c_weekcn
  is '周-中文';
comment on column T_CALENDAR.c_week1
  is '周期英文缩写';
comment on column T_CALENDAR.c_week2
  is '周期数字';
comment on column T_CALENDAR.c_week3
  is '周期英文';
comment on column T_CALENDAR.c_daynum
  is '天数';
comment on column T_CALENDAR.c_weeknum
  is '周数';
comment on column T_CALENDAR.c_suit
  is '宜';
comment on column T_CALENDAR.c_avoid
  is '忌';
comment on column T_CALENDAR.c_desc
  is '假日描述';
