package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
        // Click on sign in link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Welcome Back text not displayed", expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage()
    {
        // Click on sign in link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        // Enter Invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("maniss");
        //Enter Invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("9876543");
        //Click on sign in button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the error message
        String expectedResult ="Invalid email or password.";
        String actualResult = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Error not displayed", expectedResult,actualResult);

    }

    @After
    public void closeDown() {
        closeBrowser();
    }
}
