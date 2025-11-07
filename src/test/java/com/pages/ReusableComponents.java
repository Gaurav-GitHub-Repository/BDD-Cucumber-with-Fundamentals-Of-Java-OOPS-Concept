package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {

	WebDriver driver;

	//Apply WebDriverWait
	public void wait(WebDriver driver, By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}
	//JavascriptExecutor to scroll using pixel
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("windows.scrollBy(0,500);",null);		
	}
	//JavascriptExecutor to scroll using pixel
	public void scroll2()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("windows.scrollBy(0,1000);",null);		
	}
	//JavascriptExecutor to scroll to the element
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	//Click using JavascriptExecutor
	public void jsClick(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", null);
	}
	//Upload file using robot
	public void uploadFile(String Path) throws AWTException
	{
		Robot robot = new Robot();
		StringSelection stringselection = new StringSelection(Path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(3000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	//Capture screenshot
	public void captureScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/screenshot.png");
		FileUtils.copyFile(source, target);
	}	
}
