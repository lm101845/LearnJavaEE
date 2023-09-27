package com.atguigu.web.controller;

import com.atguigu.web.bean.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/26 14:44
 **/

//多端内容适配
@RestController
public class MultiTerminalContentAdaptation {
    /**
     * 1、默认支持把对象写为json。因为默认web场景导入了jackson处理json的包;jackson-core
     * 2、jackson也支持把数据写为xml。导入xml相关依赖
     * @return
     */
    @GetMapping("/person")
    public Person person(/*@RequestBody Person person*/){
        Person person = new Person();
        person.setId(1L);
        person.setUserName("张三");
        person.setEmail("aaa@qq.com");
        person.setAge(18);
        return person;
    }

    //public static void main(String[] args) throws JsonProcessingException {
    //    Person person = new Person();
    //    person.setId(1L);
    //    person.setUserName("张三");
    //    person.setEmail("aaa@qq.com");
    //    person.setAge(18);
    //    YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
    //    //让文档启动没有yaml上方的三个横线
    //    ObjectMapper mapper = new ObjectMapper(factory);
    //    String s = mapper.writeValueAsString(person);
    //    System.out.println(s);
    //}
}
