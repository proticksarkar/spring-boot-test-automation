package com.spring.springboot.testautomation.models;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyConfiguration;
import com.spring.springboot.testautomation.webframework.models.ExcelModelConfig;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;

@LazyConfiguration
public class ExcelTestDataModelConfig {

    @LazyAutowired
    private ExcelModelConfig excelModelConfig;

    @Bean
    public List<ExcelScenarioModel> getExcelModel() throws IOException {
        return excelModelConfig.getExcelModels(ExcelScenarioModel.class,
                "testdata/applications/excel/ExcelTestData.xlsx");
    }

}
