package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
    @Test
    public void JSexecutorTest() {

        //Amazona gidip assagidaki sign in butonu gorununceye kadar javascript ile assagi inelim scrool yapalim
        //sign in butonuna JS ile click yapalim

        driver.get("https://www.amazon.com");
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));

        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);

        jse.executeScript("arguments[0].click();",signInButonu);
    }
}
