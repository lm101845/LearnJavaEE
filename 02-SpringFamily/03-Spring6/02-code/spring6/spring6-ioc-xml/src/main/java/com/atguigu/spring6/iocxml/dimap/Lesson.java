package com.atguigu.spring6.iocxml.dimap;

/**
 * @Author liming
 * @Date 2023/9/17 17:28
 **/
public class Lesson {
    private String lessonName;

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                '}';
    }
}
