package useCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Authentification {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login\r\n");
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		//Thread.sleep(5000);
		
		WebElement username;
		WebElement password;
		WebElement bouton;
		
		username = driver.findElement(By.name("username"));
		password = driver.findElement(By.name("password"));
		bouton  = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		bouton.click();
		
		//Thread.sleep(5000);
		
		WebElement profil;
		profil = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span"));
		String message;
		message = profil.getText();
		System.out.println(message);
		Assert.assertEquals("Paul Collings", message);
		driver.close();
		
				
	

		
		

	}

}
