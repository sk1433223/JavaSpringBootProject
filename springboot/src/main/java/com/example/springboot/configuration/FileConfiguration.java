package com.example.springboot.configuration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @ClassName: FileConfig
 * @description:
 * @author 阿康
 * @DateTime: 2020/4/2411:26
 */
@Configuration
public class FileConfiguration {

    /**
     * 上传文件大小
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("10241"));
        //单个文件最大 //KB,MB
        factory.setMaxFileSize(DataSize.parse("10240KB"));
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("102400KB"));
        return factory.createMultipartConfig();
    }

}
