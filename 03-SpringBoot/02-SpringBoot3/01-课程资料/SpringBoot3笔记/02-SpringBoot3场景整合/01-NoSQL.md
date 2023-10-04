# 01-NoSQL

## 环境准备

### 云服务器

- [阿里云](https://promotion.aliyun.com/ntms/act/ambassador/sharetouser.html?userCode=50sid5bu&utm_source=50sid5bu)、[腾讯云](https://curl.qcloud.com/iyFTRSJb)、[华为云](https://activity.huaweicloud.com/discount_area_v5/index.html?fromacct=d1a6f32e-d6d0-4702-9213-eafe022a0708&utm_source=bGVpZmVuZ3lhbmc==&utm_medium=cps&utm_campaign=201905) 服务器开通； **按量付费，省钱省心**
- 安装以下组件

- - docker
  - redis
  - kafka
  - prometheus
  - grafana

- <https://github.com/kingToolbox/WindTerm/releases/download/2.5.0/WindTerm_2.5.0_Windows_Portable_x86_64.zip>  下载windterm

**重要：开通云服务器以后，请一定在安全组设置规则，放行端口**

**重要：开通云服务器以后，请一定在安全组设置规则，放行端口**

**重要：开通云服务器以后，请一定在安全组设置规则，放行端口**

### Docker安装

> 还不会docker的同学，参考【云原生实战（10~25集）】快速入门
>
> https://www.bilibili.com/video/BV13Q4y1C7hS?p=10

~~~bash
sudo yum install -y yum-utils

sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo

sudo yum install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

sudo systemctl enable docker --now

#测试工作
docker ps
#  批量安装所有软件
docker compose  
~~~

创建 /prod 文件夹，准备以下文件

### prometheus.yml

~~~yml
global:
  scrape_interval: 15s
  evaluation_interval: 15s

scrape_configs:
  - job_name: 'prometheus'
    static_configs:
      - targets: ['localhost:9090']

  - job_name: 'redis'
    static_configs:
      - targets: ['redis:6379']

  - job_name: 'kafka'
    static_configs:
      - targets: ['kafka:9092']
~~~

### docker-compose.yml

~~~yml
version: '3.9'

services:
  redis:
    image: redis:latest
    container_name: redis
    restart: always
    ports:
      - "6379:6379"
    networks:
      - backend

  zookeeper:
    image: bitnami/zookeeper:latest
    container_name: zookeeper
    restart: always
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
      ALLOW_ANONYMOUS_LOGIN: yes
    networks:
      - backend

  kafka:
    image: bitnami/kafka:3.4.0
    container_name: kafka
    restart: always
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      ALLOW_PLAINTEXT_LISTENER: yes
      KAFKA_CFG_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
    networks:
      - backend
  
  kafka-ui:
    image: provectuslabs/kafka-ui:latest
    container_name:  kafka-ui
    restart: always
    depends_on:
      - kafka
    ports:
      - "8080:8080"
    environment:
      KAFKA_CLUSTERS_0_NAME: dev
      KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS: kafka:9092
    networks:
      - backend

  prometheus:
    image: prom/prometheus:latest
    container_name: prometheus
    restart: always
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
    ports:
      - "9090:9090"
    networks:
      - backend

  grafana:
    image: grafana/grafana:latest
    container_name: grafana
    restart: always
    depends_on:
      - prometheus
    ports:
      - "3000:3000"
    networks:
      - backend

networks:
  backend:
    name: backend
~~~

### 启动环境

~~~yml
docker compose -f docker-compose.yml up -d
~~~

### 验证

* Redis：你的ip:6379
  * 填写表单，下载官方可视化工具：
  * https://redis.com/redis-enterprise/redis-insight/#insight-form
* Kafka：你的ip:9092
  * idea安装大数据插件
* Prometheus：你的ip:9090
  * 直接浏览器访问
* Grafana：你的ip:3000
  * 直接浏览器访问

## Redis整合

Redis不会的同学：参照 阳哥-《Redis7》 <https://www.bilibili.com/video/BV13R4y1v7sP?p=1>

HashMap： key：value

### 场景整合

依赖导入

~~~xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
~~~

配置

~~~xml
spring.data.redis.host=192.168.200.100
spring.data.redis.password=Lfy123!@!
~~~

测试

~~~java
@Autowired
StringRedisTemplate redisTemplate;

@Test
void redisTest(){
    redisTemplate.opsForValue().set("a","1234");
    Assertions.assertEquals("1234",redisTemplate.opsForValue().get("a"));
}
~~~

###  自动配置原理

1. META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports中导入了`RedisAutoConfiguration`、RedisReactiveAutoConfiguration和RedisRepositoriesAutoConfiguration。所有属性绑定在`RedisProperties`中
2. RedisReactiveAutoConfiguration属于响应式编程，不用管。RedisRepositoriesAutoConfiguration属于 JPA 操作，也不用管
3. RedisAutoConfiguration 配置了以下组件

1. 1. LettuceConnectionConfiguration： 给容器中注入了连接工厂LettuceConnectionFactory，和操作 redis 的客户端DefaultClientResources。
   2. `RedisTemplate<Object, Object>`： 可给 redis 中存储任意对象，会使用 jdk 默认序列化方式。
   3. `StringRedisTemplate`： 给 redis 中存储字符串，如果要存对象，需要开发人员自己进行序列化。key-value都是字符串进行操作··

### 定制化

#### 序列化机制

~~~java
@Configuration
public class AppRedisConfiguration {


    /**
     * 允许Object类型的key-value，都可以被转为json进行存储。
     * @param redisConnectionFactory 自动配置好了连接工厂
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //把对象转为json字符串的序列化工具
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
~~~

#### redis客户端

RedisTemplate、StringRedisTemplate： 操作redis的工具类

- 要从redis的连接工厂获取链接才能操作redis
- **Redis客户端**

- - Lettuce： 默认
  - Jedis：可以使用以下切换

~~~xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>io.lettuce</groupId>
                    <artifactId>lettuce-core</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

<!--        切换 jedis 作为操作redis的底层客户端-->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
        </dependency>
~~~

####  配置参考

~~~java
spring.data.redis.host=8.130.74.183
spring.data.redis.port=6379
#spring.data.redis.client-type=lettuce

#设置lettuce的底层参数
#spring.data.redis.lettuce.pool.enabled=true
#spring.data.redis.lettuce.pool.max-active=8

spring.data.redis.client-type=jedis
spring.data.redis.jedis.pool.enabled=true
spring.data.redis.jedis.pool.max-active=8
~~~

