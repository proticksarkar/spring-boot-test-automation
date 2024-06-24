package com.spring.springboot.testautomation.webframework.utils;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;

import java.io.File;
import java.util.List;

@LazyComponent
public class ExcelUtil {

    // Read data from Excel file and map it to Java objects using the Poiji library.
    public <T> List<T> retrieveExcelData(Class<T> modelClass, String sourceFilePath, PoijiOptions...poijiOptions) {
        PoijiOptions options = getDefaultPoijiOptions();
        if ( poijiOptions.length >= 1 ) {
            options = poijiOptions[0];
        }
        List<T> data = Poiji.fromExcel(new File(sourceFilePath), modelClass, options);
        return data;
    }

    // Returns a default set of Poiji options for reading Excel file.
    private PoijiOptions getDefaultPoijiOptions() {
        return PoijiOptions.PoijiOptionsBuilder
                .settings() // Skip first row after header (header is already skipped by default)
                .preferNullOverDefault(false) // Date, Float, Double, Integer, Long, String will have 'null' value rather than default value.
                .addListDelimiter(";") // Default is comma (,)
                .caseInsensitive(true) // Used by @ExcelCellName to ignore the case-sensitivity
                .ignoreWhitespaces(true) // Used by @ExcelCellName to ignore whitespaces (trim)
                .build();
    }

}
