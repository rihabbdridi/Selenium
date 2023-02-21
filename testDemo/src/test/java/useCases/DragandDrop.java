package useCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class DragandDrop {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		WebDriver navigateur = new ChromeDriver();
		
		// Delete cookies
		
		navigateur.manage().deleteAllCookies();
		navigateur.manage().window().maximize();
		
		//Implicit Wait
		navigateur.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		//Ouvrir URL
		navigateur.navigate().to("https://demoqa.com/droppable");
		
		//dentif elemt 
		
		WebElement Drag = navigateur.findElement(By.id("draggable"));
		WebElement Drop = navigateur.findElement(By.id("droppable"));
		
		//Instanciation Action
		Actions action = new Actions(navigateur);
		
		//drag and drop 
		action.dragAndDrop(Drag, Drop).perform();
		
		//verifaction
		String message; 
		message = Drop.getText();
		Assert.assertEquals(message,"Dropped!");
		navigateur.close();
		System.out.println("Done");
		
		
		
		
		
	}

}
