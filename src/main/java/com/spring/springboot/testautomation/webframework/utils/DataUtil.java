package com.spring.springboot.testautomation.webframework.utils;

import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import com.spring.springboot.testautomation.webframework.exceptions.ScenarioMissingException;
import com.spring.springboot.testautomation.webframework.interfaces.ICreateDataModel;
import com.spring.springboot.testautomation.webframework.interfaces.IScenarioModel;

import java.util.List;
import java.util.stream.Collectors;

import static com.spring.springboot.testautomation.webframework.constants.MessageConstants.*;

/**
 * Utility class for handling data operations related to scenario and data creation models.
 * Provides methods to filter and retrieve data based on specified criteria.
 */
@LazyComponent
public class DataUtil {

    /**
     * Filters the list of ScenarioModel objects based on a scenario name and
     * casts it to a specified type and returns it.
     *
     * @param inputData the list of ScenarioModel objects
     * @param scenarioFilter the scenario name to filter by
     * @param typeClass the class type to cast the filtered object to
     * @param <T> the type of the class modeled by this Class object
     * @return an object of type T that matches the scenario filter
     * @throws ScenarioMissingException if no matching scenario is found
     */
    public <T> T getScenarioData(List<? extends IScenarioModel> inputData, String scenarioFilter, Class<T> typeClass) {
        return typeClass
                .cast(inputData
                        .stream()
                        .filter(obj -> obj.getScenario().equalsIgnoreCase(scenarioFilter))
                        .findAny()
                        .orElseThrow(() -> new ScenarioMissingException(String
                                .format(SCENARIO_NOT_FOUND_EXCEPTION_MESSAGE, scenarioFilter))
                        )
                );
    }

    /**
     * Filters the list of CreateDataModel objects to exclude those marked as skipped and
     * returns a list of the specified type.
     *
     * @param inputData the list of CreateDataModel objects
     * @param typeClass the class type to cast the filtered objects to
     * @param <T> the type of the class modeled by this Class object
     * @return a list of objects of type T that are not marked as skipped
     */
    public <T> List<T> getNonSkippedData(List<? extends ICreateDataModel> inputData, Class<T> typeClass) {
        return inputData
                .stream()
                .filter(obj -> !obj.isSkipped())
                .map(typeClass::cast)
                .collect(Collectors.toList());
    }

}
