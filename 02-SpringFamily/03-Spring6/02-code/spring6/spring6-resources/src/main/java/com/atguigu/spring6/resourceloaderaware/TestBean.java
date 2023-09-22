package com.atguigu.spring6.resourceloaderaware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * @Author liming
 * @Date 2023/9/22 16:24
 **/
public class TestBean implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}

