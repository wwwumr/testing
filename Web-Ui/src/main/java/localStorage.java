import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.junit.Test;
import static org.junit.Assert.*;

public class localStorage {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.casecloud.com.cn/project-signin";
        // Open browser
        driver.get(url);

        // Input project Id
        WebElement projectId = driver.findElement(By.name("projectId"));
        projectId.sendKeys("2031000005");

        // Input phone number
        WebElement phoneNumber = driver.findElement(By.name("phone"));
        phoneNumber.sendKeys("18701958936");

        // Input password
        WebElement password = driver.findElement(By.id("standard-adornment-password"));
        password.sendKeys("Mytest123");

        // Click "登录" button
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/button/span[1]"));
        button.click();

        // Get local storage
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();

        String key = (String)localStorage.keySet().toArray()[0];
        String ls = localStorage.getItem(key);
        System.out.println(ls);

//        // Test user Id
//        String userId = localStorage.getItem("userId");
//        assertEquals("26", userId);
//
        // Test user name
//        String name = localStorage.getItem("realName");
//        assertEquals("王笑然", name);
//
//        // Test residentId
//        String residentId = localStorage.getItem("residentId");
//        assertEquals("130631199907020219", residentId);
//
//        // Test phoneNumber
//        String phone = localStorage.getItem("phoneNumber");
//        assertEquals("18701958936", phone);
//
//        // Test address
//        String address = localStorage.getItem("address");
//        assertEquals("123", address);
//
//        // String profession
//        String profession = localStorage.getItem("profession");
//        assertEquals("0", profession);
    }
}
