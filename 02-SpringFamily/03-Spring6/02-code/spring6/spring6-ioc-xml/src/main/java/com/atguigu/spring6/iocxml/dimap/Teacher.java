package com.atguigu.spring6.iocxml.dimap;

/**
 * @Author liming
 * @Date 2023/9/17 16:41
 **/
public class Teacher {
    private String tid;
    private String tname;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
