package cn.itcast.order.service;


import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.itcast.feign.clients.UserClient;
import com.itcast.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;
    //写法1：使用restTemplate
    //@Autowired
    //private RestTemplate restTemplate;
    //
    //public Order queryOrderById(Long orderId) {
    //    // 1.查询订单
    //    Order order = orderMapper.findById(orderId);
    //    //2.利用RestTemplate发起http请求，查询用户
    //    //2.1 url路径
    //    //String url = "http://localhost:8081/user/" + order.getUserId();
    //    String url = "http://userservice/user/" + order.getUserId();
    //    //2.2 发送http请求，实现远程调用
    //    User user = restTemplate.getForObject(url, User.class);
    //    //3.封装user到Order
    //    order.setUser(user);
    //    // 4.返回
    //    return order;
    //}

    //写法2：使用feign
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.用Feign远程调用
        User user = userClient.findById(order.getUserId());
        //3.封装user到order
        order.setUser(user);
        //4.返回
        return order;
    }
}
