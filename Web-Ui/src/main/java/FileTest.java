import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

import static java.lang.Thread.sleep;
// 弹出框，文件上传，下拉框选择
public class FileTest {
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
        try{sleep(2000);
            chrome_driver.navigate().to("https://www.casecloud.com.cn/information-disclosure");
            WebElement create_button =chrome_driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[1]/div[2]/button"));
            create_button.click();


            //WebElement selector = chrome_driver.findElement(By.xpath("//*[@id=\"menu-type\"]/div[3]"));
            //selector.sendKeys("会议管理");

            WebElement title = chrome_driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/div/div[2]/div[2]/div/div/input"));
            title.sendKeys("新建议题1");

            WebElement fileInput = chrome_driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/div/div[3]/div[2]/div/label/span"));
            String filePath = "D:\\vm\\123.pdf";
            fileInput.click();
            fileInput.sendKeys(filePath);
        }
        catch (Exception e){

        }
    }
}
