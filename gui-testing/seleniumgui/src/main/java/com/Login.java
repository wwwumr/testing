package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.sleep;

import java.util.Set;

public class Login {
  public static WebDriver login() {
    // 自定义chrome driver的位置，应与chrome.exe的位置保持一致
    System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
    WebDriver chrome_driver = new ChromeDriver();

    String url = "https://www.casecloud.com.cn/platform-signin";
    // 打开浏览器
    chrome_driver.get(url);

    try {
      sleep(5000);
      // 显示登录前cookies
      Set<Cookie> cookies = chrome_driver.manage().getCookies();
      System.out.println("cookies before login: " + cookies);
      // 输入手机号
      WebElement element = chrome_driver.findElement(By.name("phone"));
      element.sendKeys("15159004816");

      // 输入密码
      WebElement element1 = chrome_driver.findElement(By.id("standard-adornment-password"));
      element1.sendKeys("123456Ac");
      String values = element.getAttribute("value");

      // 点击登录
      sleep(1000);
      WebElement element2 = chrome_driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/button"));
      element2.click();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return chrome_driver;
  }
}
