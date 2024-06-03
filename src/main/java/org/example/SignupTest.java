package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignupTest
{

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void setup()
    {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drmad\\OneDrive\\Documents\\cs_year4\\sem2\\software implementation\\Project\\Dependencies\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void testSignup()
    {
        // Navigate to the login page
        driver.get("https://www.facebook.com/r.php/");



        // Locate the form fields
        WebElement nameField = driver.findElement(By.name("firstname"));
        WebElement surename = driver.findElement(By.name("lastname"));
        WebElement emailField = driver.findElement(By.name("reg_email__"));
        WebElement re_emailField = driver.findElement(By.name("reg_email_confirmation__"));
        WebElement passwordField = driver.findElement(By.name("reg_passwd__"));

        // Locate the dropdown menus for birthdate
        Select dayDropdown = new Select(driver.findElement(By.name("birthday_day")));
        Select monthDropdown = new Select(driver.findElement(By.name("birthday_month")));
        Select yearDropdown = new Select(driver.findElement(By.name("birthday_year")));

        // Locate gender radio buttons
        WebElement genderMale = driver.findElement(By.xpath("//input[contains(@class, '_8esa') and @value='2']"));
        WebElement genderFemale = driver.findElement(By.xpath("//input[contains(@class, '_8esa') and @value='1']"));

        // Fill out the form
        nameField.sendKeys("mo");
        surename.sendKeys("Doe");
        emailField.sendKeys("gogoe@gmail.com");
        re_emailField.sendKeys("moh024411@gmail.com");
        passwordField.sendKeys("Ihf12112001");

        // Select birthdate
        dayDropdown.selectByValue("15");   // Select day 15
        monthDropdown.selectByValue("6");  // Select June (month 6)
        yearDropdown.selectByValue("1990"); // Select year 1990

        // Select gender
        genderMale.click(); // Or genderFemale.click();

        // Submit the form
        WebElement submitButton = driver.findElement(By.name("websubmit"));
        submitButton.click();
        // Assert that the login was successful by checking the URL or a specific element
        String expectedUrlSubstring = "https://www.facebook.com/recover/code/?em";
        wait.until(ExpectedConditions.urlContains(expectedUrlSubstring));

        // Assert that the current URL contains the expected substring
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(expectedUrlSubstring), "Signup failed or redirected to unexpected URL!");

    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }



}
