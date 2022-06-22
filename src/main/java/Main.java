import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedrivers\\chromedriver5.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        WebElement login_input = driver.findElement(By.xpath("//input[@aria-label='Электронный адрес или номер телефона']"));
        WebElement password_input = driver.findElement(By.xpath("//input[@aria-label='Пароль']"));
        login_input.sendKeys("");
        password_input.sendKeys("");

        WebElement login_button = driver.findElement(By.xpath("//button[@name='login']"));
        Thread.sleep(1000);
        login_button.click();

        String url = driver.getCurrentUrl();
        if (url.equals("https://www.facebook.com/?sk=welcome")){
            url = "https://facebook.com";
        }

//        after two seconds get profile page
        Thread.sleep(2000);
        String newurl = url+"/teresa.galvan.161";
        driver.get(newurl);

//        getting into likes page
        Thread.sleep(1500);
        String ulr_likes = newurl + "/likes";
        driver.get(ulr_likes);

//        we need to scroll down to get all elements
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
            Thread.sleep(500);
        }

//        get all elements
        FileWriter fw = new FileWriter("out.txt");
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh a8c37x1j fe6kdd0r mau55g9w c8b282yb keod5gw0 nxhoafnm aigsh9s9 d3f4x2em iv3no6db jq4qci2q a3bd9o3v lrazzd5p oo9gr5id hzawbc8m']"));
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
            fw.write(elements.get(i).getText() + "\n");
        }
        fw.close();
    }
}
