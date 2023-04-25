package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {


    String baseUrl = "https://demo.nopcommerce.com/ ";
    static String menu="Computers";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
         //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
        //1.2 This method should click on the menu whatever name is passed as parameter.

        public void selectMenu(){
            Actions actions  = new Actions(driver);
            WebElement clickMenu = driver.findElement(By.linkText(menu));
            actions.moveToElement(clickMenu).click().build().perform();
        }
        //1.2 This method should click on the menu whatever name is passed as parameter.
        //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation

        @Test
        public void verifyPageNavigation(){
            selectMenu();
            String expectedText =menu;
            String actualText = getTextFromElement(By.xpath("(//a[text()='Computers '])[1]"));
            Assert.assertEquals("Not Navigation",expectedText,actualText);
        }

    @After
    public void tearDown() {
        closeBrowser();
    }
}





