package online.xingming;

/**
 * Created by tumingjian on 2017/12/22.
 */
public class Person {
    private String xing;//姓
    private String ming;//名
    private Integer year;//年
    private Integer month;//月
    private Integer day;//天
    private Integer hour;//小时
    private Integer minute; //分
    private String pid; //省份
    private String cid; //城市
    private Integer sex;//男女
    private boolean zty=false;//是否考虑太阳真子实
    private Integer wxxy=0;//是否自动分析喜用神


    public String getXing() {
        return xing;
    }

    public void setXing(String xing) {
        this.xing = xing;
    }

    public String getMing() {
        return ming;
    }

    public void setMing(String ming) {
        this.ming = ming;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public boolean isZty() {
        return zty;
    }

    public void setZty(boolean zty) {
        this.zty = zty;
    }

    public Integer getWxxy() {
        return wxxy;
    }

    public void setWxxy(Integer wxxy) {
        this.wxxy = wxxy;
    }
}
