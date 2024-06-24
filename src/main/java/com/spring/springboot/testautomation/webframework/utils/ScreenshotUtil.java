package com.spring.springboot.testautomation.webframework.utils;

import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@LazyComponent
//@PropertySource("classpath:location.properties")
public class ScreenshotUtil {

    @Autowired
    private ApplicationContext appContext;

    @Value("${screenshots.path}")
    private Path screenshotsPath;

    public void takeScreenshot(String testName) throws IOException {
        File sourceFile = this.appContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        // Create directory if it doesn't exist
        screenshotsPath.toFile().mkdirs();
        FileCopyUtils.copy(sourceFile, screenshotsPath.resolve( testName + ".png").toFile());
    }

    public byte[] getScreenshotAsBytes(){
        return this.appContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

    public String getScreenshotAsBase64() {
        return this.appContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BASE64);
    }

    public String getScreenshotPath() {
        File sourceFile = this.appContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        return sourceFile.getPath();
    }

}
