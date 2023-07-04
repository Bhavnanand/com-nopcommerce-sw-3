package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

//1. Create the class ElectronicsTest
public class ElectronicsTest extends Utility {
    String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setBrowser()
    {
openBrowser(baseUrl);
    }

    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
@Test
public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
//1.1 Mouse Hover on “Electronics” Tab
//1.2 Mouse Hover on “Cell phones” and click
    Thread.sleep(1000);
    clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
  //  mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"), By.linkText("cell-phones"));

    Thread.sleep(1000);
//1.3 Verify the text “Cell phones”
   // String expected = "Cell phones";
  //  String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
 //   Assert.assertEquals("Both texts are equal", expected, actual);
    Thread.sleep(1000);
}
//2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//2.1 Mouse Hover on “Electronics” Tab
//2.2 Mouse Hover on “Cell phones” and click

        Thread.sleep(1000);
        //clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
       // mouseHoverAction(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"), By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        Thread.sleep(2000);
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"),By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
//clickOnEolement(By.linkText("cell-phones"));
        Thread.sleep(1000);
//2.3 Verify the text “Cell phones”
        String expected = "Cell phones";
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Both texts are equal", expected, actual);
        Thread.sleep(1000);

//2.4 Click on List View Tab
    clickOnElement(By.xpath("//a[contains(text(),'List')]"));
//2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
//2.6 Verify the text “Nokia Lumia 1020”
        String expected1="Nokia Lumia 1020";
        String actual1 ="//a[contains(text(),'Nokia Lumia 1020')]";
        Assert.assertEquals("Both text are equal",expected1,actual1);
//2.7 Verify the price “$349.00”
        String expected2= "$349.00";
        String actual2=getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        Assert.assertEquals("Both amount are equal",expected2,actual2);

//2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("/div[@class='buttons']//button[text()='Add to cart']"));
//2.8 Change quantity to 2
clickOnElement(By.xpath("//input[@id='itemquantity11232']"));
sendTextToElement(By.xpath("//input[@id='itemquantity11232']"),"2");
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top
//green Bar
        String expexcted4="The product has been added to your shopping cart";
        String actual4=getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
Assert.assertEquals("Both messages are equal",expexcted4,actual4);
//After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

//2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"),By.xpath("//button[contains(text(),'Go to cart')]"));
//2.12 Verify the message "Shopping cart"
        String expected3="Shopping cart";
        String actual3= getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Both text are equal",expected3,actual3);
//2.13 Verify the quantity is 2
        String expected5=": 2";
        String actual5= getTextFromElement(By.xpath("//div[@class='quantity']"));
        Assert.assertEquals("Both are equal",expected5,actual5);
//2.14 Verify the Total $698.00
        String epexted6="$698.00";
        String actual6 =getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("Both values are equal",epexted6,actual6);

//2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

//2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expected7="Welcome, Please Sign In!";
        String actual7= getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Both texts are equal",expected7,actual7);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));


//2.19 Verify the text “Register”
        String expected8="";
        String actual8=getTextFromElement(By.xpath("//a[contains(text(),'Register')]"));
        Assert.assertEquals("Both text are ewqual",expected8,actual8);
//2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"nina");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"mehta");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "12");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "November");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1976");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"ggdhhLondon@gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"),"Prime");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Gujarat");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"12,Gokul Park,Ahmedavad");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"344555");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"02233444");


//2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        Thread.sleep(2000);

        //2.22 Verify the message “Your registration completed”
      //  verifyText(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
        Thread.sleep(2000);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //define expected
        String expectedTextShoppingCard = "Shopping cart";
        //get actual
        String actualTextShoppingCard = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.24 Verify the text “Shopping card”
        Assert.assertEquals("not on shopping cart", expectedTextShoppingCard, actualTextShoppingCard);
        Thread.sleep(1000);

    }


    @After
    public void TearDown(){
       closeBrowser();
    }
}


