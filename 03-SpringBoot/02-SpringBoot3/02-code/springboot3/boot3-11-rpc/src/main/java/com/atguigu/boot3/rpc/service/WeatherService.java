package com.atguigu.boot3.rpc.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liming
 * @Date 2023/10/5 16:33
 **/

//@Service
//public class WeatherService {
//    public Mono<String> weather(String city){
//        //远程调用阿里云API
//
//        //1.创建WebClient，得到一个发请求的客户端
//        WebClient client = WebClient.create();
//        Map<String,String> params = new HashMap<>();
//        params.put("area",city);
//        //2.定义发请求行为
//        Mono<String> mono = client.get()
//                .uri("https://ali-weather.showapi.com/area-to-weather-date?area={area}",params)
//                .accept(MediaType.APPLICATION_JSON)    //定义响应的内容类型
//                .header("Authorization", "APPCODE 30e807ef56f9487c92d7f75491551adc")
//                .retrieve()
//                .bodyToMono(String.class);
//                //.block();   //使用阻塞，等过程结束完把得到的json字符串给我们——发现不行
//        return mono;
//    }
//}


