package com.atguigu.boot3.core.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 9:41
 **/

@Service
public class EventPublish implements ApplicationEventPublisherAware {
    /**
     * 底层发送事件用的组件，SpringBoot会通过ApplicationEventPublisherAware【接口】自动注入给我们
     * (不用写Autowired)
     * 事件是广播出去的,所有监听这个事件的监听器都可以收到
     */
    ApplicationEventPublisher applicationEventPublisher;
    /**
     * 使用ApplicationEvent，所有事件都可以发
     * @param event
     */
    public void sendEvent(ApplicationEvent event) {
        //我们调用底层API，真正实现发送事件
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * 会被自动调用，把真正发事件的底层组件给我们注入过来
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
