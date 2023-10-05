package com.atguigu.boot3.rpc.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

/**
 * @Author liming
 * @Date 2023/10/5 17:12
 **/

public interface WeatherInterface2 {
    @GetExchange(url = "https://ali-weather.showapi.com/area-to-weather-date",accept = "application/json")
    Mono<String> getWeather(@RequestParam("area") String city);
}
