package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.image.Kernel;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.facebook.com");

        //yeni kayit olustur butonuna bas
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //isim kutusunu locate et
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        //geriye kalanlari tab ile dolas

        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Kagan")
                .sendKeys(Keys.TAB).sendKeys("Gunturk")
                .sendKeys(Keys.TAB).sendKeys("yasirkagang@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("yasirkagang@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("123456789a")
                .sendKeys(Keys.TAB).sendKeys("123456789a").perform();
    }

}
