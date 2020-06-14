package com;

import com.alibaba.fastjson.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.util.Set;

import static java.lang.Thread.sleep;

public class CaseCloudTest {
    // 自定义要上传的文件路径
    static String uploadFilePath = "D:\\test.pdf";

    public static void main(String[]args){
        WebDriver chrome_driver = Login.login();

        try {
            // 显示登录后的cookies
            sleep(2000);
            Set<Cookie> cookies = chrome_driver.manage().getCookies();
            System.out.println("cookies after login: " + cookies);

            // 选择第一个项目
            sleep(2000);
            WebElement element3 = chrome_driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/ul/div/div/div/ul/div[2]"));
            element3.click();

            // 显示localstorage
            LocalStorage localStorage = ((WebStorage) chrome_driver).getLocalStorage();
            String key = (String)localStorage.keySet().toArray()[0];
            String ls = localStorage.getItem(key);
            Object object = JSONObject.parse(ls);
            System.out.println(object);

            // 选择信息披露栏
            sleep(1000);
            WebElement element4 = chrome_driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/div/div/div/ul/div[3]/div/div/ul/a[2]/div"));
            element4.click();

            // 新建信息披露
            WebElement create_button =chrome_driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[1]/div[2]/button"));
            create_button.click();

            // 填写信息披露类型
            chrome_driver.findElement(By.xpath("//*[@id=\"mui-component-select-type\"]")).click();
            WebElement type = chrome_driver.findElement(By.xpath("//*[@id=\"menu-type\"]/div[3]/ul/li[3]"));
            type.click();

            // 填写议题名称
            WebElement title = chrome_driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/div/div[2]/div[2]/div/div/input"));
            title.sendKeys("新建议题1");

            // 上传文件
            WebElement fileInput = chrome_driver.findElement(By.xpath("//*[@id=\"upload-file-button-file\"]"));
            fileInput.sendKeys(uploadFilePath);

            // 点击新建信息披露
            sleep(2000);
            WebElement submitButton = chrome_driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
            submitButton.click();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        // 关闭浏览器
        chrome_driver.close();
    }
}
