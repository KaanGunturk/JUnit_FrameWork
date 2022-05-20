package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Poe extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.pathofexile.com/trade/search/Sentinel");
        WebElement aramaKutusu=driver.findElement(By.xpath("(//input[@class='multiselect__input'])[1]"));
        aramaKutusu.sendKeys("The Nurse" + Keys.ENTER+Keys.ENTER);
        driver.findElement(By.xpath("(//small)[1]")).click();
    }
}
