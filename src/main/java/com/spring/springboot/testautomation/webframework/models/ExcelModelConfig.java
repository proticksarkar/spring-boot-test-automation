package com.spring.springboot.testautomation.webframework.models;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import com.spring.springboot.testautomation.webframework.utils.ExcelUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

@LazyConfiguration
public class ExcelModelConfig {

    @LazyAutowired
    private ExcelUtil excelUtil;

    @Bean
    public <T> List<T> getExcelModels(Class<T> tClass, String filePath) throws IOException {
        File file = new ClassPathResource(filePath).getFile();
        return excelUtil.retrieveExcelData(tClass, file.toString());
    }

}
