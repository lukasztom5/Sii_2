package Day5;

import Day3.TestBase;
import Day6.*;
import MyStore.CreateAccountPOP;
import MyStore.HomePagePop;
import MyStore.LoginPop;
import MyStore.MenuPop;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCreation extends TestBase {
    @Test
    public void testUserRegestration() {
        String firstName = "Lukasz";
        String lastName = "Tomczyk";
        String email = "test" + System.currentTimeMillis() + "@test.com";
        HomePagePop homepagePO = new HomePagePop(driver);
        homepagePO.open();
        MenuPop menuPO = new MenuPop(driver);
        //when
        menuPO.clickSignInOutButton();
        LoginPop loginPO = new LoginPop(driver);
        loginPO.clickCreateAccountLink();
        CreateAccountPOP createAccountPO = new CreateAccountPOP(driver);
        createAccountPO.fillFormAndSubmit(true,
                firstName,
                lastName,
                email,
                "AAAABBBB",
                "05/08/2000");
        //then
        Assert.assertTrue(menuPO.logoutVisible());
        Assert.assertEquals(menuPO.getUserName(), firstName + " " + lastName);
    }
    @Test
    public void userRegistrationShouldFailWhenSameEmailIsUsedMoreThanOnceTest(){
        //given
        String firstName = "Lukasz";
        String lastName = "Tomczyk";
        String email = "test@test.com";
        HomePagePop homepagePO = new HomePagePop(driver);
        homepagePO.open();
        MenuPop menuPO = new MenuPop(driver);
        //when
        menuPO.clickSignInOutButton();
        LoginPop loginPO = new LoginPop(driver);
        loginPO.clickCreateAccountLink();
        CreateAccountPOP createAccountPO = new CreateAccountPOP(driver);
        createAccountPO.fillFormAndSubmit(true,
                firstName,
                lastName,
                email,
                "AAAABBBB",
                "05/08/2000");
        //then
        Assert.assertTrue(createAccountPO.getAlertText().contains("already used"));
    }
    @Test
    public void showProductsTest(){
        HomePagePop homepagePO = new HomePagePop(driver);
        homepagePO.open();
        homepagePO.printAllPrices();
    }
    @Test
    public void openQuickViewTest(){
        HomePagePop homepagePO = new HomePagePop(driver);
        homepagePO.open();
        int n=getRandomNumber(homepagePO.miniatureNumber()-1);
        String name1=homepagePO.getNameOfNthMiniature(n);
        homepagePO.openQuickView(n);
        QuickViewPop quickView = new QuickViewPop(driver);
        Assert.assertEquals(name1,quickView.getTitle());

    }
    @Test
    public void itemsInTheCartShouldHaveCorrectSummaryPrice() {
        HomePagePop homepagePO = new HomePagePop(driver);
        homepagePO.open();
        int n = getRandomNumber(homepagePO.miniatureNumber() - 1);
        String name1 = homepagePO.getNameOfNthMiniature(n);
        double price = homepagePO.getPriceOfNthMiniature(n);
        homepagePO.openQuickView(n);
        QuickViewPop quickViewPO = new QuickViewPop(driver);
        int quantity = getRandomNumber(10);
        quickViewPO.setQuantity(quantity);
        double expectedValue = price * quantity;
        quickViewPO.clickAddCart();
        ProductAddedToCartPop productAddedToCartPO = new ProductAddedToCartPop(driver);
        productAddedToCartPO.clickProceed();
        ShoppingCartPop shoppingCartPO = new ShoppingCartPop(driver);
        Assert.assertEquals(shoppingCartPO.getNthCartItemsName(0), name1);
        Assert.assertEquals(shoppingCartPO.getSubtotal(), expectedValue);
    }
    @Test
    public void shouldCorrectlyAddMultipleToCartTest(){
        HomePagePop homepagePO = new HomePagePop(driver);
        homepagePO.open();
        MenuPop menuPO = new MenuPop(driver);
        QuickViewPop quickViewPO = new QuickViewPop(driver);
        ProductAddedToCartPop productAddedToCartPO = new ProductAddedToCartPop(driver);
        ShoppingCartPop shoppingCartPO = new ShoppingCartPop(driver);
        int totalQuantity=0;
        double value=0;
        for(int i=1;i<=3;i++){
            int random = getRandomNumber(homepagePO.miniatureNumber() - 1);
            int quantity = getRandomNumber(10);
            double price = homepagePO.getPriceOfNthMiniature(random);
            quickViewPO.setQuantity(quantity);
            totalQuantity+=quantity;
            value+=(price * quantity);
            homepagePO.openQuickView(random);
            quickViewPO.setQuantity(quantity);
            quickViewPO.clickAddCart();
            productAddedToCartPO.clickContinueShopping();
        }
        menuPO.open();
        Assert.assertEquals(totalQuantity,shoppingCartPO.getTotalNumberOfItems());
        Assert.assertEquals(value,shoppingCartPO.getSubtotal(),0.001);

    }
    @Test
    public void removeItemFromCartTest(){

    }
}