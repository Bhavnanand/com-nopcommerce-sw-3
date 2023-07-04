package computer;//Create the package name computer

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuit extends Utility {    //1. Create class “TestSuite
String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setUrl(){
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {    //Write the following Test:
        //1.Test name verifyProductArrangeInAlphaBaticalOrder()
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//ul[@class='sublist']//a[text()='Desktops ']"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        //selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"),"6");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2. Test name verifyProductAddedToShoppingCartSuccessFully()
        //mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']"),By.xpath("//ul[@class='sublist']//a[text()='Desktops ']"));
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']"));

        //2.2 Click on Desktop
       clickOnElement(By.xpath("//ul[@class='sublist']//a[text()='Desktops ']"));


        //2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.name("products-orderby"),"Name: A to Z");
        Thread.sleep(1000);

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='buttons']//button[text()='Add to cart']"));
        Thread.sleep(1000);


        //2.5 Verify the Text "Build your own computer"
       String expectedText="Build your own computer";
      String actual= getTextFromElement( By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Both text are equal",expectedText,actual);
        Thread.sleep(1000);


        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"),"2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        //selectByValueFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"5");
selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //selectByValueFromDropDown(By.xpath("//input[@id='product_attribute_3_7']"),"7");
        Thread.sleep(1000);
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        selectByValueFromDropDown(By.xpath("//input[@id='product_attribute_4_8']"),"8");
        Thread.sleep(1000);

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));


        //2.11 Verify the price "$1,475.00"
        getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//div[@class='buttons']//button[text()='Add to cart']"));
        //div[@class='buttons']//button[text()='Add to cart']
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedtext="The product has been added to your shopping cart";
String actualtext = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1])"));
Assert.assertEquals("Both message are  equal",expectedtext,actualtext);


        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"), By.xpath("//button[contains(text(),'Go to cart')]"));

        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"),By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 Verify the message "Shopping cart"
        String expextedtext1="Shopping cart";
        String actualtext1=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
Assert.assertEquals("Both text are equal",expextedtext1,actualtext1);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        sendTextToElement(By.xpath("//input[@id='itemquantity11223']"),"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        String expectedtext2="$2,950.00";
        String actualtext2 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
                Assert.assertEquals("Both value are equal",expectedtext2,actualtext2);



        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expected1=getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actual1="Welcome, Please Sign In!";
        Assert.assertEquals("Both text are equal",expected1,actual1);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Nina");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"mehta");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"7 ggdhhLondon@gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"),"Prime");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Gujarat");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"12,Gokul Park,Ahmedavad");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"344555");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"02233444");


        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath(""));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'Next Day Air ($0.00)')]"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));


        //2.26 Select Radio Button “Credit Card”
        selectByValueFromDropDown(By.xpath("//input[@id='paymentmethod_1']"),"Payments.Manual");

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");

        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"N mehta");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"2333444445");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"7");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"234");


        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//li[@class='payment-method']/span[@class='value']"));
        Thread.sleep(1000);
        Assert.assertEquals("no credit card", expectedPaymentMethod, actualPaymentMethod);
        //Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Thread.sleep(1000);
        Assert.assertEquals("Message not found", expectedShippingMethod, actualShippingMethod);
        //Verify Total is “$2,950.00”
        String expectedTotalAmount = "$2,950.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Total amount does not match.", expectedTotalAmount, actualTotalAmount);
        //Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //define expected
        String expectedThankYou = "Thank you";
        //get actual
        Thread.sleep(1000);
        String actualThankYou = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //Verify the Text “Thank You”
        Thread.sleep(1000);
        Assert.assertEquals("Thank you not displayed", expectedThankYou, actualThankYou);
        //define expected
        String expectedSuccessfullyProcessed = "Your order has been successfully processed!";
        //get actual
        String actualSuccessfullyProcessed = getTextFromElement(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"));
        //Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Not processed", expectedSuccessfullyProcessed, actualSuccessfullyProcessed);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //Verify the text “Welcome to our store”
        //define expected
        String expectedWelcomeMessage = "Welcome to our store";
        //get actual
        String actualWelcomeMessage = getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));
        //Verify the message “Your order has been successfully processed!”
        Thread.sleep(1000);
        Assert.assertEquals("Not successfully processed", expectedWelcomeMessage, actualWelcomeMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



