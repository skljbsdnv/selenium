package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest
{
    private WebDriver driver;

    @BeforeEach
    public void setup()
    {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drmad\\OneDrive\\Documents\\cs_year4\\sem2\\software implementation\\Project\\Dependencies\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin()
    {
        // Navigate to the login page
        driver.get("https://e-learning.msa.edu.eg/");

        // Locate the username and password fields and login button
        WebElement usernameField = driver.findElement(By.id("inputName"));
        WebElement passwordField = driver.findElement(By.id("inputPassword"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        // Input credentials
        usernameField.sendKeys("211217");
        passwordField.sendKeys("Ihf121121111");

        // Click the login button
        loginButton.click();

        // Assert that the login was successful by checking the URL or a specific element
        String expectedUrl = "https://e-learning.msa.edu.eg/";
        assertEquals(expectedUrl, driver.getCurrentUrl(), "Login failed!");
    }

    @AfterEach
    public void tearDown()
    {
        // Close the browser
        if (driver != null)
        {
            driver.quit();
        }
    }

}
