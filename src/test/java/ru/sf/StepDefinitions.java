package ru.sf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    static final WebDriver webDriver;
    public static final HomePage homePage;
    public static final ResultsPage resultsPage;

    static {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webDriver.manage().window().maximize();
        homePage = new HomePage(webDriver);
        resultsPage = new ResultsPage(webDriver);
    }

    @Given("url of Russian Railways: {string}")
    public void url_of_russian_railways(String url)  {
        homePage.go(url);
    }

    @When("the site is open enter city name {string} into the field From")
    public void the_site_is_open_enter_city_name_into_the_field_from(String cityFrom) {
        homePage.enterCityFrom(cityFrom);
    }

    @Then("enter city name {string} into the field To")
    public void enter_city_name_into_the_field_to(String cityTo) {
        homePage.enterCityTo(cityTo);
    }

    @Then("enter date {string} into the field Depart")
    public void enter_date_into_the_field_depart(String depart) {
        homePage.enterDate(depart);
    }

    @And("click the button Search")
    public void click_the_button_search() {
        homePage.search();
    }

    @Then("assert that there is a list of results")
    public void assert_that_there_is_a_list_of_results() {
        resultsPage.assertThatThereIsAListOfResults();
    }


    @When("the site is open click the button Search")
    public void the_site_is_open_click_the_button_search() {
        homePage.search();
    }

    @Then("assert that user got the message {string}")
    public void assert_that_user_got_the_message(String errorMessage) {
        homePage.assertThatUserGotTheMessage(errorMessage);
    }
}
