package com.boot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author liming
 * @Date 2023/10/3 15:54
 **/

@Data
@TableName("t_user")
public class User implements UserDetails {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("enabled")
    private Boolean enabled;

    //这个不是在表中的
    @TableField(exist = false)
    private List<GrantedAuthority> authorityList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //不过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //不锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //密码没过期
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
