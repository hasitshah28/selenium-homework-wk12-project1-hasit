package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //1.1 Click on Computer
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

        //1.3 Select Sort by Position "Name Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A ");

        //1.4 Verify the Product will arrange in Descending order.
        selectByValueFromDropDown(By.id("products-orderby"), "6");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.id("products-orderby"), "5");
        Thread.sleep(2000);

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));

        //2.5 Verify the Text "Build your own computer"
        verifyFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"), "Build your own computer");

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.name("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByValueFromDropDown(By.name("product_attribute_2"), "5");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(4000);

        //2.11 Verify the price "$1,475.00"
        verifyFromElement(By.xpath("//span[@id='price-value-1']"), "$1,475.00");
        Thread.sleep(2000);

        //2.12 Click on "ADD TO CART" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),
                "The product has been added to your shopping cart");
        Thread.sleep(2000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(2000);

        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        //mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverToElement(By.xpath("//span[text()='Shopping cart']"));
        clickOnElement(By.id("topcartlink"));

        //2.15 Verify the message "Shopping cart"
        verifyFromElement(By.xpath("//span[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        //clickOnElement(By.xpath("//input[@class='qty-input']"));
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        verifyFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"),"$2,950.00");

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");

        //2.21Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Has");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Shah");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"has1234@gmail.com");
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"China");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Liverpool");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"7,North Avenue");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA2 0HR");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07845678912");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"),"H shah");
        sendTextToElement(By.name("CardNumber"),"5245256238832614");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "2");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2030");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"356");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyFromElement(By.xpath("//span[normalize-space()='Credit Card']"),"Credit Card");

        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyFromElement(By.xpath("//span[normalize-space()='Next Day Air']"),"Next Day Air");

        //2.33 Verify Total is “$2,950.00”
        verifyFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"),"$2,950.00");

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank You”
        verifyFromElement(By.xpath("//h1[normalize-space()='Thank you']"), "Thank you");

        //2.36 Verify the message “Your order has been successfully processed!” 2.37 Click on “CONTINUE”
        verifyFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"),
                "Your order has been successfully processed!");
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.37 Verify the text “Welcome to our store”
        verifyFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"),"Welcome to our store");

    }
    @After
    public void tearDown() {
         closeBrowser();
    }
}