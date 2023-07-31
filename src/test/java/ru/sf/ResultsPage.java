package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {

    private static final String RESULTS_LIST = "searchresults__list";

    private final WebDriver webDriver;
    public ResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void assertThatThereIsAListOfResults() {
        webDriver.findElement(By.className(RESULTS_LIST));
    }
}
