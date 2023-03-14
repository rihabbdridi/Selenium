package Sprint2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class DifferentsCombiOrange {
	WebDriver driver;
	@Given("Ouvrir site avec URL")
	public void ouvrir_site_avec_url() {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}

	@When("^Entrer userloginAdmin(.*)$")
	public void entrer_userlogin_admin(String MAIL) {
     	WebElement username;
		username = driver.findElement(By.name("username"));
		username.sendKeys(MAIL);
	}

	@And("^Entrer userpasswordadmin123(.*)$")
	public void entrer_userpasswordadmin123(String MDP) {

		WebElement password;
		password = driver.findElement(By.name("password"));
		password.sendKeys(MDP);
	}

	@And("Clique button se connecter")
	public void clique_button_se_connecter() {

		WebElement bouton;
		bouton  = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		bouton.click();
	}

	@Then("acces compte")
	public void acces_compte() {
	}

}
