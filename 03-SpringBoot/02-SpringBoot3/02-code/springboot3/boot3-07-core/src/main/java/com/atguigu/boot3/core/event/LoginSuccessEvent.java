package com.atguigu.boot3.core.event;

import com.atguigu.boot3.core.entity.UserEntity;
import org.springframework.context.ApplicationEvent;

/**
 * @Author liming
 * @Date 2023/10/3 9:43
 * @Description 登录成功事件。所有事件都推荐继承ApplicationEvent
 **/
public class LoginSuccessEvent extends ApplicationEvent {
    /**
     *
     * @param source 代表是谁登录成功了
     */
    public LoginSuccessEvent(UserEntity source) {
        super(source);
    }
}
