package com.atguigu.mybatisplus.pojo;

import lombok.*;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/23 13:41
 **/

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
