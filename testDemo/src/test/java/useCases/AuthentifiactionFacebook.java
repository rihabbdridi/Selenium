package useCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AuthentifiactionFacebook {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","src/test/ressources/chromedriver.exe");
		WebDriver driver = new ChromeDriver() ;
		//delete all cookies
		driver.manage().deleteAllCookies();
		//maximiser la fenetre
		driver.manage().window().maximize();
		
		//Implicity wait
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		//Ouvrir l'URL
		driver.navigate().to("https://www.facebook.com");
		
		WebElement email;
		WebElement password;
		WebElement connect;
		
		email = driver.findElement(By.id("email"));
		password = driver.findElement(By.id("pass"));
		connect  = driver.findElement(By.name("login"));
		
		email.sendKeys("@gmail.com");
		password.sendKeys("");
		connect.click();
		
		//Thread.sleep(5000);
		
		// WebElement profil;
		// profil = driver.findElement(By.xpath("//*[@id=\"mount_0_0_UM\"]/div/div[1]/div/div[3]/div[3]/div/div[1]/div/div[1]/div/div/div[1]/div/div/div[2]/span/div/a/div[3]/span/span"));
		//String message;
		//message = profil.getText();
		//Assert.assertEquals("Ri Hab DrIdi",message);
		driver.close();
		System.out.println("Test OK");
		
		
		
		
		
		
	}

}
