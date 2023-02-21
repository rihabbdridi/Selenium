package useCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recherche {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
//Open URL		
		driver.navigate().to("https://www.google.com/");
		
//identification des elements
		WebElement champs;
		WebElement bouton;

		champs = driver.findElement(By.name("q"));
		bouton = driver.findElement(By.name("btnK"));
		
//Les actions
		
		champs.sendKeys("car");
		champs.sendKeys(Keys.ENTER);

//Verification

		WebElement result;
		result = driver.findElement(By.id("result-stats"));
		String message;
		message = result.getText();
		Assert.assertTrue(message.contains("resultats"));
		System.out.println("Test OK");

	}

}
