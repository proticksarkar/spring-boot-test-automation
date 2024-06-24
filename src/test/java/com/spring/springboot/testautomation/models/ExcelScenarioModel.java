package com.spring.springboot.testautomation.models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import com.spring.springboot.testautomation.webframework.interfaces.IScenarioModel;
import lombok.Data;

@Data
@ExcelSheet("ExcelScenarios")
public class ExcelScenarioModel implements IScenarioModel {

    @ExcelCellName("Scenario")
    private String scenario;

    @ExcelCellName("Integer Data")
    private int intData;

    @ExcelCellName("Float Data")
    private float floatData;

}
