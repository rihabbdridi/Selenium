package useCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class DoubleCLic {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// ouvrir navig
		driver.navigate().to("https://demoqa.com/buttons");
		
		// Identification de l'element
        WebElement doubleClic;
		doubleClic = driver.findElement(By.id("doubleClickBtn"));
		
		//Instanciation de la classe Action
		Actions action = new Actions(driver);
		
		//double clique du bouton
		action.doubleClick(doubleClic).perform();
		
		//vérifiaction 
		
		WebElement Verif;
		Verif= driver.findElement(By.id("doubleClickMessage"));
		String  Message;
		Message = Verif.getText();
		
		// Test
		Assert.assertEquals("You have done a double click", Message);
		
		driver.close();
		System.out.println("Test OK");
		

	}

}
