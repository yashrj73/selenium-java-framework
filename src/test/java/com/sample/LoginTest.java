package com.selenium.framework.tests;

import com.selenium.framework.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    @Test
    public void testSuccessfulLogin() {
        driver.get("https://www.browserstack.com/users/sign_in");
        
        // Locate and fill in the email field
        driver.findElement(By.id("user_email_login")).sendKeys("your_email@example.com");

        // Locate and fill in the password field
        driver.findElement(By.id("user_password")).sendKeys("your_password");

        // Click the login button
        driver.findElement(By.name("commit")).click();

        // Verify successful login by checking for the Live Dashboard link
        Assert.assertTrue(driver.findElement(By.linkText("Live")).isDisplayed(), "Login was not successful!");
    }

    @Test
    public void testFailedLogin() {
        driver.get("https://www.browserstack.com/users/sign_in");

        // Fill incorrect email and password
        driver.findElement(By.id("user_email_login")).sendKeys("wrong_email@example.com");
        driver.findElement(By.id("user_password")).sendKeys("wrong_password");

        // Click the login button
        driver.findElement(By.name("commit")).click();

        // Verify the error message
        Assert.assertTrue(driver.findElement(By.className("error-msg")).isDisplayed(), "Expected error message not displayed!");
    }
}
