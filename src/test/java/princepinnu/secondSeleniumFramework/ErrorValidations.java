package princepinnu.secondSeleniumFramework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import princepinnu.TestComponents.BaseTest;
import princepinnu.TestComponents.Retry;

public class ErrorValidations extends BaseTest{

	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
	
		
		landingPage.loginApplication("anshika@gmail.com", "Iamki000");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test(groups= {"ProductErrorValidation"})
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
	
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("princebabu@gmail.com", "Prince@2000");		
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match =cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}

}
