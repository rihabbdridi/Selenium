package useCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListeDeroulante {
// choisir la couleur WHITE
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		WebDriver navigateur = new ChromeDriver ();
		navigateur.manage().deleteAllCookies();
		navigateur.manage().window().maximize();
		
		//Implicit wait 
		navigateur.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//ouvrir navig 
		navigateur.navigate().to(" https://demoqa.com/select-menu ");
		
		//Identification elet 
		WebElement LIST= navigateur.findElement(By.id("oldSelectMenu"));
		
		//Appel Class list
		
		Select SELECT = new Select(LIST);
		SELECT.selectByValue("6");
		navigateur.close();
		
		System.out.println("La couleur choisie est bien WHITE");
		
		
		

	}

}
