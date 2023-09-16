package com.atguigu.spring6.iocxml.di;

/**
 * @Author liming
 * @Date 2023/9/16 22:46
 **/
public class Book {
    //给属性设置具体值，就叫依赖注入
    private String bname;
    private String author;


    public Book() {
        System.out.println("无参构造执行了");
    }

    public Book(String bname, String author) {
        System.out.println("有参数构造执行了...");
        this.bname = bname;
        this.author = author;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //原生写法：set方法注入
        Book book = new Book();
        book.setBname("恶意");
        book.setAuthor("东野圭吾");

        //原生写法：通过构造器注入
        Book book1 = new Book("C++", "尚硅谷");
    }
}
