package pages;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Product extends Base {

	Actions action;

	public Product(WebDriver driver) {
		super(driver);
	}

	public boolean addToCartStatus() {

		if (isExist(By.cssSelector("Button.single_add_to_cart_button.button.alt.disabled")))
			return true;
		else
			return false;
	}

	public boolean editProduct() {
		if (addToCartStatus()) {
			Select select = new Select(driver.findElement(By.xpath("//table//select")));
			select.selectByIndex(2);

			return true;
		} else
			return false;
	}

	public boolean addToCart() throws InterruptedException {
		click(By.cssSelector(".single_add_to_cart_button.button"));
		Thread.sleep(3000);
		String itemCount = driver.findElement(By.xpath("((//a[@id=\"elementor-menu-cart__toggle_button\"])[1]/span)[2]")).getAttribute("data-counter");
		if(itemCount.equals("1"))
		return true;
		else
			return false;
	}
}
