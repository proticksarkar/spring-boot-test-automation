package com.spring.springboot.testautomation.webframework.actions;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

import static com.spring.springboot.testautomation.webframework.constants.MessageConstants.ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE;

@Slf4j
@LazyComponent
public class ElementActions {

    @LazyAutowired
    private WebDriver webDriver;
    @LazyAutowired
    private JavascriptActions javascriptActions;
    @LazyAutowired
    private AlertActions alertActions;
    @LazyAutowired
    private WaitActions waitActions;

    // Get current page url
    public String getPageUrl() {
        waitActions.waitForPageToBeLoaded();
        String pageUrl = webDriver.getCurrentUrl();
        log.debug("Page URL: {}", pageUrl);
        return pageUrl;
    }

    // Get current page title
    public String getPageTitle() {
        waitActions.waitForPageToBeLoaded();
        String pageTitle = webDriver.getTitle();
        log.debug("Page Title: {}", pageTitle);
        return pageTitle;
    }

    // Verify element is displayed on a webpage
    public <T> boolean verifyElementIsDisplayed(T elementAttr) {
        waitActions.waitForElementToBeClickable(elementAttr);
        try {
            boolean isDisplayed = getWebElement(elementAttr).isDisplayed();
            log.debug("Element is displayed: {}", elementAttr);
            return isDisplayed;
        } catch (TimeoutException exception) {
            highlightElement(elementAttr, exception);
            log.error("TimeoutException while verifying element: {} is displayed\nException:{}",
                    elementAttr, exception.getMessage(),exception);
            throw exception;
        }
    }

    // Click an element
    public <T> ElementActions click(T elementAttr) {
        waitActions.waitForElementToBeClickable(elementAttr);
        try {
            getWebElement(elementAttr).click();
            log.debug("Clicked element: {}", elementAttr);
        } catch (TimeoutException exception) {
            highlightElement(elementAttr, exception);
            log.error("TimeoutException while trying to click element: {}\nException: {}",
                    elementAttr, exception.getMessage(), exception);
            throw exception;
        }
        return this;
    }

    // Verify text of an element
    public <T> boolean verifyElementText(T elementAttr, String searchText) {
        // Wait until the element is clickable
        waitActions.waitForElementToBeClickable(elementAttr);
        return getText(elementAttr)
                .trim()
                .equalsIgnoreCase(searchText);
    }

    // Filter out an element by text from a list of elements
    public <T> WebElement filterElementByText(T elementAttr, String searchText) {
        // Wait until the element is clickable
        waitActions.waitForElementToBeClickable(elementAttr);
        return getWebElements(elementAttr)
                .stream()
                .filter(element -> verifyElementText(element, searchText))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format(ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE, elementAttr, searchText)));
//        log.debug("Found Element with Text : {}", searchText);
    }

    // Filter out an element by text from a list of elements and click
    public <T> ElementActions filterElementByTextAndClick(T elementAttr, String searchText) {
        waitActions.waitForElementToBeClickable(elementAttr);
        filterElementByText(elementAttr, searchText).click();
//        log.debug("Found and clicked on Element with Text : {}", searchText);
        return this;
    }

    // Filter out a cell by text in a web table
    public <T> WebElement filterCellByTextInTable(T elementAttr, String searchText) {
        // Wait until the table or element is clickable
        waitActions.waitForElementToBeClickable(elementAttr);
        // Get the first cell of the table containing the search text
        WebElement tableCell = getWebElements(elementAttr)
                .stream()
                .flatMap(row -> row.findElements(By.tagName("td"))
                        .stream())
                .filter(column -> column.getText()
                        .toLowerCase()
                        .contains(searchText.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format(ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE, elementAttr, searchText)));
        return tableCell;
    }

    // Find the input element to the right of the found cell in web table and enter the value to it
    public <T> ElementActions enterCellValueInTable(T elementAttr, String cellName, String cellValue) {
        // Get the first cell of the table containing the search text
        WebElement referenceWebElement = filterCellByTextInTable(elementAttr, cellName);
        // Find the input element to the right of the found cell and send the value to it
        WebElement inputWebElement = findWebElementToRightByTag(referenceWebElement, "input");
        // Input cell value
        inputWebElement
                .sendKeys(cellValue);
        return this;
    }

    // Clear field and enter text
    public <T> ElementActions enterText(T elementAttr, String text) {
        waitActions.waitForElementsToBeVisible(elementAttr);
        getWebElement(elementAttr).clear();
        getWebElement(elementAttr).sendKeys(text);
        return this;
    }

    // Get element text
    public <T> String getText(T elementAttr) {
        waitActions.waitForPageToBeLoaded();
        return getWebElement(elementAttr).getText().trim();
    }

    // Select dropdown element by index
    public <T> ElementActions selectDropdownElementByIndex(T elementAttr, int index) {
        waitActions.waitForElementToBeVisible(elementAttr);
        new Select(getWebElement(elementAttr)).selectByIndex(index);
        return this;
    }

    // Select dropdown element by value
    public <T> ElementActions selectDropdownElementByValue(T elementAttr, String value) {
        waitActions.waitForElementToBeVisible(elementAttr);
        new Select(getWebElement(elementAttr)).selectByValue(value);
        return this;
    }

    // Select dropdown element by visible text
    public <T> ElementActions selectDropdownElementByVisibleText(T elementAttr, String visibleText) {
        waitActions.waitForElementToBeVisible(elementAttr);
        new Select(getWebElement(elementAttr)).selectByValue(visibleText);
        return this;
    }

    // Get attribute value
    public <T> String getAttribute(T elementAttr, String attribute) {
        waitActions.waitForElementToBeVisible(elementAttr);
        return getWebElement(elementAttr).getAttribute(attribute);
    }

    // It uses Selenium's RelativeLocator to find the first web element with a specified tag name
    // that is located to the right of the reference element.
    public <T> WebElement findWebElementToRightByTag(T elementAttr, String tagName) {
        waitActions.waitForElementToBeVisible(elementAttr);
        By tagLocator = By.tagName(tagName);
        WebElement referenceElement = getWebElement(elementAttr);
        return webDriver
                .findElement(RelativeLocator
                        .with(tagLocator)
                        .toRightOf(referenceElement));
    }

    // It uses Selenium's RelativeLocator to find all web elements with a specified tag name
    // above the reference element sorted by the proximity to reference element.
    public <T> List<WebElement> findWebElementsAboveByTag(T elementAttr, String tagName) {
        waitActions.waitForElementToBeVisible(elementAttr);
        By tagLocator = By.tagName(tagName);
        WebElement referenceElement = getWebElement(elementAttr);
        return webDriver
                .findElements(RelativeLocator
                        .with(tagLocator)
                        .above(referenceElement));
    }

    // Get a web element (can take both By and WebElement)
    public <T> WebElement getWebElement(T elementAttr) {
        waitActions.waitForElementToBeVisible(elementAttr);
        if (elementAttr instanceof By) {
            return webDriver
                    .findElement((By) elementAttr);
        } else {
            return ((WebElement) elementAttr);
        }
    }

    // Get a list of web elements (can take both By and WebElement)
    public <T> List<WebElement> getWebElements(T elementAttr) {
        waitActions.waitForElementsToBeVisible(elementAttr);
        if (elementAttr instanceof By) {
            return webDriver
                    .findElements((By) elementAttr);
        } else {
            return ((List<WebElement>) elementAttr);
        }
    }

    // Highlight web element
    public <T> void highlightElement(T elementAttr, Exception exception) {
        waitActions.waitForElementToBeVisible(elementAttr);
        // No point in trying to highlight an element that was not found, as it would lead to another NoSuchElementException.
        if (exception.getCause() instanceof NoSuchElementException) {
            return;
        }
        // If the element has a style attribute and it contains visibility: hidden, it means the element is initially hidden.
        // This will use JavaScript to modify the element's style attribute, setting a blue dashed border to highlight.
        String styleAttributeValue = getAttribute(elementAttr, "style");
        if (Objects.nonNull(styleAttributeValue)) {
            if (styleAttributeValue.contains("visibility: hidden")) {
                javascriptActions.highlightElement(elementAttr, "style", "border", "2px dashed blue");
            }
        }
        // If the element is not hidden and is available, it changes the border of the element to a red dashed outline using JavaScript.
        javascriptActions.highlightElement(elementAttr, "style", "border", "2px dashed red");
    }

}
