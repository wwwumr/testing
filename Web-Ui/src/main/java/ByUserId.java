import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ByUserId {
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://casecloud.com.cn/platform-signin");

        // id
        WebElement element = driver.findElement(By.id("standard-adornment-password"));
        System.out.println("element Text:"+element.getText());

        // xpath
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div/div/div/h6/b"));
        System.out.println("element1 Text:"+element1.getText());

        // className
        WebElement element2 = driver.findElement(By.className("MuiTabs-root"));
        System.out.println("element2 Text:"+element2.getText());

        // list
        List<WebElement> cheeses = driver.findElements(By.className("MuiTabs-root"));
        for(int i=0;i<cheeses.size();i++){
            System.out.println("element3 Text:"+cheeses.get(i).getText());
        }

        // Css
        WebElement element3 =driver.findElement(By.cssSelector("#root  div.jss1"));
        System.out.println("element3 Text:"+element3.getText());

        // LinkText
        WebElement element4 = driver.findElement(By.linkText("忘记密码"));
        System.out.println("element4 Text:"+element4.getText());

        driver.quit();
    }
}
