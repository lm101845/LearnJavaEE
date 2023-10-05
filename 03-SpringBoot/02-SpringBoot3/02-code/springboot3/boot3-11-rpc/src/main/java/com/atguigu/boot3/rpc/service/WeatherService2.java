package com.atguigu.boot3.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liming
 * @Date 2023/10/5 16:33
 **/

@Service
public class WeatherService2 {

    //@Autowired
    //WeatherInterface weatherInterface;

    public Mono<String> weather(String city){
        //远程调用阿里云API
//        Mono<String> mono = getByWebClient(city);

        //1.创建客户端
        WebClient client = WebClient.builder()
                .baseUrl("https://ali-weather.showapi.com/")
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer
                            .defaultCodecs()
                            .maxInMemorySize(256*1024*1024);
                            //响应数据量太大有可能会超出BufferSize,所以这里设置的大一点
                })
                .build();

        //2.创建工厂
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client)).build();

        //3.获取代理对象
        WeatherInterface weatherAPI = factory.createClient(WeatherInterface.class);

        Mono<String> weather = weatherAPI.getWeather(city,"APPCODE 30e807ef56f9487c92d7f75491551adc");

        return weather;
    }

    private static Mono<String> getByWebClient(String city) {
        //1、创建WebClient
        WebClient client = WebClient.create();

        //2、准备数据
        Map<String,String> params = new HashMap<>();
        params.put("area", city);
        //3、定义发请求行为  CompletableFuture
        Mono<String> mono = client.get()
                .uri("https://ali-weather.showapi.com/area-to-weather-date?area={area}",params)
                .accept(MediaType.APPLICATION_JSON) //定义响应的内容类型
                .header("Authorization", "APPCODE 30e807ef56f9487c92d7f75491551adc") //定义请求头
                .retrieve()
                .bodyToMono(String.class);
        return mono;
    }
}