package useCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstPro {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.get("https://www.youtube.com/");
		driver.navigate().to("https://www.youtube.com/");
		String message;
		message= driver.getTitle();
		System.out.println("Le titre de l'application est " +message);
		
		
		
	}

}
