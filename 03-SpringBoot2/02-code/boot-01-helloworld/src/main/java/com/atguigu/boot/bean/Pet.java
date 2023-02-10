package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liming
 * @Date 2023/2/8 22:17
 **/
@AllArgsConstructor
//写这个就可以不写有参构造器了
@NoArgsConstructor
//写这个就可以不写无参构造器了
@Data
public class Pet {
    private String name;

    //public String getName() {
    //    return name;
    //}
    //
    //public void setName(String name) {
    //    this.name = name;
    //}

    //@Override
    //public String toString() {
    //    return "Pet{" +
    //            "name='" + name + '\'' +
    //            '}';
    //}
    //
    //public Pet() {
    //}
    //
    //public Pet(String name) {
    //    this.name = name;
    //}
}
