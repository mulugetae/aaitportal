package com.mulugetaewnu;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver
        System.setProperty("webdriver.chrome.driver", "/Gecko/chromedriver");
        WebDriver driver;
        driver = new ChromeDriver();
        String username = "";
        String password = "";
        //maximize window
        driver.manage().window().maximize();
        //Launch portal
        String url = "http://portal.aait.edu.et";
        driver.get(url);
        driver.findElement(By.id("UserName")).sendKeys(username);
        driver.findElement(By.name("Password")).sendKeys(password, Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='ml2']")).click();
        Thread.sleep(1000);
        String table = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/table")).getText();
        try{
            FileWriter grade = new FileWriter("grade.doc");
            grade.write(table);
            grade.close();
        }
        catch(IOException e){

        }


        driver.close();
    }

}
