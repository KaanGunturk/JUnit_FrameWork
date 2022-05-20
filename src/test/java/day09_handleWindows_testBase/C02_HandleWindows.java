package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test01(){
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowsHandleDegeri=driver.getWindowHandle();
        // 2- url'in  amazon icerdigini test edelim
        String actualUrl=driver.getCurrentUrl();
        String arananKelime="amazon";
        Assert.assertTrue(actualUrl.contains(arananKelime));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowsHandleDegeri=driver.getWindowHandle();

        // 4- title'in Best Buy icerdigini test edelim
        String actualTitle=driver.getTitle();
        String arananTitle="Best Buy";
        Assert.assertTrue(actualTitle.contains(arananTitle));

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaWindowsHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisistr = sonucYaziElementi.getText();
        String arananSonucYazisi="Java";
        Assert.assertTrue(sonucYazisistr.contains(arananSonucYazisi));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowsHandleDegeri);

        // 8- logonun gorundugunu test edelim
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
