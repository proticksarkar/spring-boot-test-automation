package com.spring.springboot.testautomation.steps.applications.excel;

import com.spring.springboot.testautomation.models.ExcelScenarioModel;
import com.spring.springboot.testautomation.webframework.utils.DataUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Slf4j
public class HandlingExcelSteps {

    @Autowired
    private List<ExcelScenarioModel> excelScenarioModelList;
    @Autowired
    private DataUtil dataUtil;
    private String currentScenario;
    private ExcelScenarioModel excelScenarioModel;

    @Given("User loads excel data and maps it to POJO")
    public void userLoadsExcelDataAndMapsItToPOJO() {
        System.out.println("Number of data rows present in Excel: " + excelScenarioModelList.size());
        log.info("Number of data rows present in Excel: " + excelScenarioModelList.size());
    }

    @When("User selects scenario {string} and gets corresponding data")
    public void userSelectsScenarioAndGetsCorrespondingData(String scenarioName) {
        this.currentScenario = scenarioName;
        System.out.println("Scenario name: " + scenarioName);
        log.info("Data for Scenario: " + scenarioName);
        excelScenarioModel = dataUtil.getScenarioData(excelScenarioModelList, scenarioName, ExcelScenarioModel.class);
        System.out.println("Excel row data: " + excelScenarioModel.toString());
        log.info("Excel row data: " + excelScenarioModel.toString());
    }

    @Then("User verifies the fetched data")
    public void userVerifiesTheFetchedData() {
        System.out.println("Scenario name from Excel: " + excelScenarioModel.getScenario());
        System.out.println("Int data from Excel: " + excelScenarioModel.getIntData());
        System.out.println("Float data from Excel: " + excelScenarioModel.getFloatData());
        log.info("Scenario name from Excel: " + excelScenarioModel.getScenario());
        log.info("Int data from Excel: " + excelScenarioModel.getIntData());
        log.info("Float data from Excel: " + excelScenarioModel.getFloatData());
        assertEquals(excelScenarioModel.getScenario(), "TC1-BasicDataType");
        assertEquals(excelScenarioModel.getIntData(), 9);
        assertEquals(excelScenarioModel.getFloatData(), 9.9f);
    }

}
