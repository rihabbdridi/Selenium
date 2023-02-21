package useCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreationCOmpteFCBK {

	public static void main(String[] args) {

		// Ouvrir chrome
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		WebDriver navigateur = new ChromeDriver();

		// Effacer les cookies et maximiser la fenetre
		navigateur.manage().deleteAllCookies();
		navigateur.manage().window().maximize();

		// Implicit wait
		navigateur.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Ouvrir URL
		navigateur.navigate().to("https://fr-fr.facebook.com/");
		
		//identifier Element
		WebElement Button = navigateur.findElement(By.xpath("//a[normalize-space()='Créer nouveau compte']"));
		Button.click();
		
		WebElement PRENOM = navigateur.findElement(By.name("firstname")); 
		WebElement NOM   = navigateur.findElement(By.name("lastname")); 
		WebElement EMAIL  =navigateur.findElement(By.name("reg_email__"));
		WebElement PASSWORD =navigateur.findElement(By.name("reg_passwd__")) ;

		WebElement LISTD = navigateur.findElement(By.id("day"));
		WebElement LISTM = navigateur.findElement(By.id("month"));
		WebElement LISTY = navigateur.findElement(By.id("year"));
		WebElement SUBSCRIBE = navigateur.findElement(By.name("websubmit"));
		
		
	PRENOM.sendKeys("Rihab");
	NOM.sendKeys("DRIDI");
	EMAIL.sendKeys("rihabdridi@yahoo.com");
	WebElement CONFIRMEMAIL =navigateur.findElement(By.name("reg_email_confirmation__")); 
	CONFIRMEMAIL.sendKeys("rihabdridi@yahoo.com");
	PASSWORD.sendKeys("12345");
	
Select SELECTD =new Select(LISTD);
SELECTD.selectByValue("28");

Select SELECTM =new Select(LISTM);
SELECTM.selectByValue("7");

Select SELECTY =new Select(LISTY);
SELECTY.selectByValue("1992");

WebElement Radio = navigateur.findElement(By.xpath("//label[normalize-space()='Femme']"));
Radio.click();
SUBSCRIBE.click();

		
	}

}
