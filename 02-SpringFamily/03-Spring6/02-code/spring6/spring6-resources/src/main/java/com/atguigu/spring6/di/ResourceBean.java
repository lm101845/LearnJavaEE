package com.atguigu.spring6.di;

import org.springframework.core.io.Resource;

/**
 * @Author liming
 * @Date 2023/9/22 16:41
 **/
public class ResourceBean {
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    private Resource resource;

    public void parse(){
        System.out.println(resource);
        System.out.println(resource.getFilename());
    }
}
