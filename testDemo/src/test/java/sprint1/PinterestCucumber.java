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

public class PinterestCucumber {
	WebDriver driver;

	@Given("ouvrir le navigateur")
	public void ouvrir_le_navigateur() {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("ouvrir URL du site")
	public void ouvrir_url_du_site() {
		driver.navigate().to("https://www.pinterest.fr/");
	}

	@And("Cliquer sur s inscrire")
	public void Cliquer_sur_s_inscrire() {
		WebElement inscrire;
		inscrire = driver.findElement(By.xpath("//div[@data-test-id='simple-signup-button']//button[@type='button']//div//div"));
		inscrire.click();
	}

	@When("Entrer Mail")
	public void entrer_mail() {
		WebElement mail;
		mail = driver.findElement(By.id("email"));
		mail.sendKeys("rihabbdr@yahoo.com");
	}

	@When("Entrer mot de passe")
	public void entrer_mot_de_passe() {
		WebElement password;
		password = driver.findElement(By.name("password"));
		password.sendKeys("Ri123456!");
	}

	@When("Saisir age")
	public void saisir_age() {
		WebElement age;
		age = driver.findElement(By.name("age"));
		age.sendKeys("30");
	}

	@When("cliquer sur continuer")
	public void cliquer_sur_continuer() {
		WebElement continuer;
		continuer = driver.findElement(By.xpath("//*[@id=\"__PWS_ROOT__\"]/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[5]/div/div[1]/form/div[6]/button/div"));
		continuer.click();
		
	}


	@When("cliquer sur  suivant")
	public void cliquer_sur_suivant() {
		WebElement suivant;
		suivant = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/button/div"));
		suivant.click();
	}

	@When("Choisir genre")
	public void choisir_genre() {
		WebElement genre = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/fieldset/div/div[1]/div/label/div/div[2]/h3"));
		genre.click();
		WebElement suiv = driver.findElement(By.xpath("//body/div/div/div/div[@aria-label='nux']/div/div/div/div/div/div/div[@data-test-id='nux_gender_next_btn']/button[@aria-label='Suivant']/div[1]"));
		suiv.click();
	}

	@When("Choisir Langue")
	public void choisir_langue() {
		WebElement langue = driver.findElement(By.name("locale"));
		Select SELECT = new Select(langue);
		SELECT.selectByValue("fr");
	}
	
	@When("Choisir pays")
	public void choisir_pays() {

		WebElement Listepays = driver.findElement(By.name("country"));
		Select SELECT = new Select(Listepays);
		SELECT.selectByValue("TN");
    }
	
	@When("cliquer suivant")
	public void cliquer_suivant() {
		WebElement suiv = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div[2]/button/div/div/div"));
		suiv.click();
	}

	
	@When("Choisir theme")
	public void choisir_theme() {
		
		WebElement photography = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div[3]/div/div[1]/div/div/div/div/div/div/div[2]/div[1]"));
		photography.click();
		
		WebElement Mode = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div[3]/div/div[7]/div/div/div/div/div/div/div[1]/div/div"));
		Mode.click();
		
		WebElement Nature = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div[3]"));
		Nature.click();
		
		WebElement Deco = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div[3]/div/div[24]/div/div/div/div/div/div/div[2]/div[1]"));
		Deco.click();
		
		WebElement Cuisine = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div[3]/div/div[25]/div/div/div/div/div/div/div[2]"));
		Cuisine.click();

		WebElement Termine = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div[4]/div[2]/button/div"));
		Termine.click();
	}

	@When("Choisir termine")
	public void choisir_termine() {
		WebElement Termine = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div[4]/div[2]/button/div"));
		Termine.click();
	}

	@Then("Verifier creation")
	public void verifier_creation() {
		WebElement R;
		R = driver.findElement(By.xpath("//*[@id=\"HeaderContent\"]/div/div/div[2]/div/div/div/div[5]/div[4]/div/div/div/a/div/div/div/div/div/div/svg"));
		R.click();
		WebElement profil;
		profil = driver.findElement(By.xpath("//h1[normalize-space()='Rihabtest']"));
		String message;
		message = profil.getText();
		Assert.assertEquals("Rihabbdri", message);
		driver.close();

	}
}
