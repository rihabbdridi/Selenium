package sprint1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AuthentificationOrangeCuc {
	WebDriver driver;

	@Given("Ouvrir URL de l application")
	public void ouvrir_url_de_l_application() {
		 System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login\r\n");
		

	}

	@When("saisir login")
	public void saisir_login() {
		WebElement username;
		username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
	}

	@When("saisir mot de passe")
	public void saisir_mot_de_passe() {
		WebElement password;
		password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
	}

	@When("Cliquer sur le bouton se connecter")
	public void cliquer_sur_le_bouton_se_connecter() {
		WebElement bouton;
		bouton  = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		bouton.click();
		
}

	@Then("Ouvrir page acceuil")
	public void ouvrir_page_acceuil() {
		WebElement profil;
		profil = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span"));
		String message;
		message = profil.getText();
		System.out.println(message);
		Assert.assertEquals("Paul Collings", message);
		driver.close();
		
	}

}
