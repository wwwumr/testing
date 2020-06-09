import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrower {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver chrome_driver = new ChromeDriver();

        String url = "http://www.51.com";
        // 打开浏览器
        chrome_driver.get(url);
        // 关闭浏览器

        // 得到title
        String title = chrome_driver.getTitle();
        // 得到当前页面url
        String currentUrl = chrome_driver.getCurrentUrl();

        System.out.println(title+"\n"+currentUrl);
        chrome_driver.close();
    }
}
