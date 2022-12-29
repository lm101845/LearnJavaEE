package com.atguigu.spring.pojo;

/**
 * @Author liming
 * @Date 2022/12/29 20:29
 **/
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    public User() {
        System.out.println("生命周期：1、创建对象");
    }
    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        System.out.println("生命周期：2-1、依赖注入-id");
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        System.out.println("生命周期：2-2、依赖注入-username");
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void initMethod(){
        System.out.println("生命周期：3、初始化");
    }

    //第4步是使用
    public void destroyMethod(){
        System.out.println("生命周期：5、销毁");
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
