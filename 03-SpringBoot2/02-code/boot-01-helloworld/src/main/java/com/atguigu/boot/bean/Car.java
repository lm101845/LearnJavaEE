package com.atguigu.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author liming
 * @Date 2023/2/9 13:57
 **/

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@Data
//@Data注解里面就包含了@ToString注解
//@ToString
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;

    //使用了Lombok插件后，get,set,toString方法都不用写了,前面加上@Data,@ToString注解即可
    //public String getBrand() {
    //    return brand;
    //}
    //
    //public void setBrand(String brand) {
    //    this.brand = brand;
    //}
    //
    //public Integer getPrice() {
    //    return price;
    //}
    //
    //public void setPrice(Integer price) {
    //    this.price = price;
    //}
    //
    //@Override
    //public String toString() {
    //    return "Car{" +
    //            "brand='" + brand + '\'' +
    //            ", price=" + price +
    //            '}';
    //}
}
