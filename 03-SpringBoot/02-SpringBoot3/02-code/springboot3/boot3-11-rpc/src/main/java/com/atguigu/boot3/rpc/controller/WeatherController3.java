package com.atguigu.boot3.rpc.controller;

import com.atguigu.boot3.rpc.service.ExpressApi;
import com.atguigu.boot3.rpc.service.WeatherService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author liming
 * @Date 2023/10/5 17:48
 **/
@RestController
public class WeatherController3 {
    @Autowired
    WeatherService2 weatherService;

    @Autowired
    ExpressApi expressApi;

    @GetMapping("/weather")
    public Mono<String> weather(@RequestParam("city") String city){
        //查询天气
        Mono<String> weather = weatherService.weather(city);


        return weather;
    }

    @GetMapping("/express")
    public Mono<String> express(@RequestParam("number") String number){

        //获取物流
        return expressApi.getExpress(number);
    }
}
