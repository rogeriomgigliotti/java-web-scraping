package com.example.demo.webscrapings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.DisposableBean;

public abstract class BaseWebScraping implements DisposableBean {
    protected WebDriver webDriver = null;

    public BaseWebScraping() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
    }

    protected String getDomAttributeByTagName(WebElement element, String tagName, String attributeName) {
        return element.findElement(By.tagName(tagName)).getDomAttribute(attributeName);
    }

    protected Double getDoubleByClassName(WebElement element, String className) {
        return Double.parseDouble(this.getTextByClassName(element, className).replace("R$", "").trim().replace(",", "."));
    }

    protected String getTextByClassName(WebElement element, String className) {
        return element.findElement(By.className(className)).getText();
    }

    public void quit() {
        this.webDriver.quit();
        this.webDriver = null;
    }

    @Override
    public void destroy() throws Exception {
        if (this.webDriver != null)
            this.quit();
    }
}
