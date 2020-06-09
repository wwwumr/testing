import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// 输入框和按钮
public class InputTest {
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver chrome_driver = new ChromeDriver();

        String url = "https://www.casecloud.com.cn/platform-signin";
        // 打开浏览器
        chrome_driver.get(url);

        // 输入手机号
        WebElement element = chrome_driver.findElement(By.name("phone"));
        element.sendKeys("15159004816");

        // 输入密码
        WebElement element1 = chrome_driver.findElement(By.id("standard-adornment-password"));
        element1.sendKeys("123456Ac");
        String values = element.getAttribute("value");

        // 建立点击事件
        WebElement element2 = chrome_driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/button"));
        element2.click();
        // 关闭浏览器
        //chrome_driver.close();
    }
}
