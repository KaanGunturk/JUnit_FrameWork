package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;

    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDonw(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //-Cookies’i kabul edin
        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        //-“radio buttons” elementlerini locate edin
        WebElement femaleButton=driver.findElement(By.xpath("//*[text()='Kadın']"));
        WebElement maleButton=driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement customButton= driver.findElement(By.xpath("//*[text()='Özel']"));

        //*[text()='Kadın']
        //-Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if (!maleButton.isSelected()){
            maleButton.click();
        }
        /*
        Thread.sleep(3000);
        femaleButton.click();
        Thread.sleep(3000);
        customButton.click();

         */

    }




}
