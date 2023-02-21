package sprint1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class CreationFB {
	WebDriver driver;

	@Given("ouvrir navigateur")
	public void ouvrir_navigateur() {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@And("ouvrir l URL")
	public void ouvrir_l_url() {
		driver.navigate().to("https://www.facebook.com");
	}

	@And("Cliquer sur creer nv compte")
	public void cliquer_sur_creer_nv_compte() {
		WebElement Button = driver.findElement(By.xpath("//a[normalize-space()='Créer nouveau compte']"));
		Button.click();
	
	}

	@And("Entrer nom")
	public void entrer_nom() {
		WebElement PRENOM = driver.findElement(By.name("firstname"));
		PRENOM.sendKeys("Rihab");
}
	
	@When("Entrer prenom")
	public void entrer_prenom() {
		WebElement NOM = driver.findElement(By.name("lastname"));
		NOM.sendKeys("DRIDI");
		}
	
	@And("Entrer email")
	public void entrer_email() {
		WebElement EMAIL = driver.findElement(By.name("reg_email__"));
		EMAIL.sendKeys("rihabbdridi@yahoo.com");
	}

	@And("confirmer email")
	public void confirmer_email() {
		WebElement CONFIRMEMAIL = driver.findElement(By.name("reg_email_confirmation__"));
		CONFIRMEMAIL.sendKeys("rihabbdridi@yahoo.com");
	}

	@And("entrer mot de passe")
	public void entrer_mot_de_passe() {
		WebElement PASSWORD = driver.findElement(By.name("reg_passwd__"));
		PASSWORD.sendKeys("123456789!");

	}

	@And("entrer date de naissance")
	public void entrer_date_de_naissance() {
		WebElement LISTD = driver.findElement(By.id("day"));
		Select SELECTD = new Select(LISTD);
		SELECTD.selectByValue("28");

		WebElement LISTM = driver.findElement(By.id("month"));
		Select SELECTM = new Select(LISTM);
		SELECTM.selectByValue("7");

		WebElement LISTY = driver.findElement(By.id("year"));
		Select SELECTY = new Select(LISTY);
		SELECTY.selectByValue("1992");
	}

	@And("selectionner genre")
	public void selectionner_genre() {
		WebElement Radio = driver.findElement(By.xpath("//label[normalize-space()='Femme']"));
		Radio.click();

	}

	@And("cliquer inscription")
	public void cliquer_inscription() {
		WebElement SUBSCRIBE = driver.findElement(By.name("websubmit"));
		SUBSCRIBE.click();
	}

	@Then("compte cree")
	public void compte_cree() {
		
		WebElement profil;
		profil = driver.findElement(By.xpath("//*[@id=\"scrollview\"]/div/div/div/div[1]/div/div[3]/div[1]/div[2]/span/span[2]/span"));
		String message;
		message = profil.getText();
		System.out.println(message);
		Assert.assertEquals("Rihab", message);
		driver.close();
		

	}

}
