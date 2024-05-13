package Harshika.Myfirstproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginPage {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String product="ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("harshikapatel2574@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Vinay@30");
		driver.findElement(By.id("login")).click();
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
//		List<WebElement> carProducts=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
//		boolean proName=carProducts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(product));
//		Assert.assertTrue(proName);
//		
		System.out.println(driver.findElement(By.cssSelector(".totalRow button")).getText());
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".totalRow button")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		
		element.click();
		
	}

}
