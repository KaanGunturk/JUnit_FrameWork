package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01(){
        // amazon ana sayfaya gidin
        // nutella icin arama yaptirin
        driver.get("https://www.amazon.com");
        String ilkSyafaninDegeri=driver.getWindowHandle();
        /*
        CDwindow-EBF365A232F66AF0F887A3C3144FDE16
        bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir.

        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan şu anda
        bulunduğumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-EBF365A232F66AF0F887A3C3144FDE16");
        bu sayfanın windows handle degerini girerek bu sayfaya gecisi saglayabiliriz.
         */


        //ilk urunun resmini tiklayarak farkli bir sekmede acin
        //yeni tabda acilan urunun fiyatini yazdirin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizda otomatik olarak olusturulan new Tab'a gecer.
        Yeni tab'da gorevi gerceklestirmek icin adimlari bastan almamiz gerekir.

         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        WebElement urunTitleElemeti= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElemeti.getText());
        System.out.println(driver.getCurrentUrl());

        //ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSyafaninDegeri);
        System.out.println(driver.getCurrentUrl());
    }

}
