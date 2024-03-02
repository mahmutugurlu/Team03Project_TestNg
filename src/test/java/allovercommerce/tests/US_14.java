package allovercommerce.tests;

import allovercommerce.pages.VendorPages;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US_14 {

    VendorPages vendorPages =new VendorPages();
    Faker faker=new Faker();


    @Test
    public void tc01() {
        //    Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

//    Sign in butonuna tiklanir

        vendorPages.signinButton.click();
//    Acilan pencerede Username or email address ve Password alanina gecerli datalar girilerek vendor olarak giris yapilir
        vendorPages.email.sendKeys(ConfigReader.getProperty("allovercommerceEmail"), Keys.TAB);
        vendorPages.password.sendKeys(ConfigReader.getProperty("allovercommercePassword"),Keys.ENTER);
        vendorPages.enterButton.click();

//    My Account yazisina tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(3);
        vendorPages.myAccountButton.click();

//    Acilan sayfada Store Manager butonuna tiklanir
        ReusableMethods.bekle(4);

        vendorPages.storeManagerButton.click();
//    Acilan sayfada products button tiklanir
        ReusableMethods.bekle(4);
        vendorPages.productsButton.click();

//    Acilan sayfada Add New butonuna tiklanir
        ReusableMethods.bekle(4);
        vendorPages.addNewButton.click();

//    Acilan sayfada Simple Product yazan kutucuga tiklanir
        ReusableMethods.bekle(4);
        vendorPages.productTypeDDM.click();

//    Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçeneklerinin oldugu dogrulanir
        WebElement secenek= vendorPages.productTypeDDM;
        Select select=new Select(secenek);
        vendorPages.productTypeDDM.click();
        List<WebElement> list=select.getOptions();
        list.forEach(t-> System.out.println(t.getText()));


    }

    @Test
    public void tc02() {


        //    Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

//    Sign in butonuna tiklanir

        vendorPages.signinButton.click();
//    Acilan pencerede Username or email address ve Password alanina gecerli datalar girilerek vendor olarak giris yapilir
        vendorPages.email.sendKeys(ConfigReader.getProperty("allovercommerceEmail"),Keys.TAB);
        vendorPages.password.sendKeys(ConfigReader.getProperty("allovercommercePassword"),Keys.ENTER);
        vendorPages.enterButton.click();

//    My Account yazisina tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        vendorPages.myAccountButton.click();

//    Acilan sayfada Store Manager butonuna tiklanir
        ReusableMethods.bekle(2);

        vendorPages.storeManagerButton.click();
//    Acilan sayfada products button tiklanir
        ReusableMethods.bekle(2);
        vendorPages.productsButton.click();

//    Acilan sayfada Add New butonuna tiklanir
        ReusableMethods.bekle(2);
        vendorPages.addNewButton.click();

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement((WebElement) vendorPages.addNewButton).click().perform();

//        Acilan sayfada Fotograf ekleme kutusuna tiklanir
        ReusableMethods.bekle(2);
        vendorPages.imageButton.click();
//        Acilan sayfada SELECT FILES butonuna tiklanir
        ReusableMethods.bekle(2);
        vendorPages.selectFilesButton.click();
//        Acilan pencereden yuklenmek istenen fotograf secilir ve ac butonu tiklanir
        String dosyaYolu="C:\\Users\\derya\\Desktop\\kus.jpg";
        ReusableMethods.uploadFile(dosyaYolu);

//        Acilan sayfadan SELECT butonuna tiklanir
        vendorPages.selectButton.click();

//        Fotografin yuklendigi dogrulanir
        Assert.assertTrue(vendorPages.xButton.isEnabled());
    }

    @Test
    public void tc03() {

//    Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

//    Sign in butonuna tiklanir

        vendorPages.signinButton.click();
//    Acilan pencerede Username or email address ve Password alanina gecerli datalar girilerek vendor olarak giris yapilir
        vendorPages.email.sendKeys(ConfigReader.getProperty("allovercommerceEmail"),Keys.TAB);
        vendorPages.password.sendKeys(ConfigReader.getProperty("allovercommercePassword"),Keys.ENTER);
        vendorPages.enterButton.click();

//    My Account yazisina tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        vendorPages.myAccountButton.click();

//    Acilan sayfada Store Manager butonuna tiklanir
        ReusableMethods.bekle(2);

        vendorPages.storeManagerButton.click();
//    Acilan sayfada products button tiklanir
        ReusableMethods.bekle(2);
        vendorPages.productsButton.click();

//    Acilan sayfada Add New butonuna tiklanir
        ReusableMethods.bekle(2);
        vendorPages.addNewButton.click();

//        Acilan sayfada Product Title, Short Description ve Description alanlarina gecerli datalar girilir
//        Product Title alanina veri girilir
        ReusableMethods.scroll(vendorPages.productTitleMetinAlani);
        vendorPages.productTitleMetinAlani.sendKeys(ConfigReader.getProperty("productTitle"));


//        Short description alanina veri girilir  ve veri girildigini doğrulanir
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().frame(0);
        vendorPages.shortDescriptionMetinAlani.sendKeys(ConfigReader.getProperty("shortDescription"));
        Assert.assertTrue(vendorPages.shortDescriptionMetinAlani.getText().contains("aciklama"));
        Driver.getDriver().switchTo().defaultContent();
//        Description alanina veri girilir  ve veri girildigini doğrulanir
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().frame(1);
        vendorPages.descriptionMetinAlani.sendKeys(ConfigReader.getProperty("description"));
        Assert.assertTrue(vendorPages.descriptionMetinAlani.getText().contains("notlar"));
//        Product Title, Short Description ve Description alanlarina gecerli datalarin girilebildigi dogrulanir
    }

    @Test
    public void tc04() {

//    Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

//    Sign in butonuna tiklanir

        vendorPages.signinButton.click();
//    Acilan pencerede Username or email address ve Password alanina gecerli datalar girilerek vendor olarak giris yapilir
        vendorPages.email.sendKeys(ConfigReader.getProperty("allovercommerceEmail"),Keys.TAB);
        vendorPages.password.sendKeys(ConfigReader.getProperty("allovercommercePassword"),Keys.ENTER);
        vendorPages.enterButton.click();

//    My Account yazisina tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        vendorPages.myAccountButton.click();

//    Acilan sayfada Store Manager butonuna tiklanir
        ReusableMethods.bekle(2);

        vendorPages.storeManagerButton.click();
//    Acilan sayfada products button tiklanir
        ReusableMethods.bekle(2);
        vendorPages.productsButton.click();

//    Acilan sayfada Add New butonuna tiklanir
        ReusableMethods.bekle(2);
        vendorPages.addNewButton.click();

//        Catagories yazisinin goruntulendigini dogrulanir
        ReusableMethods.scroll(vendorPages.catagoriesToplamClikButton);
        Assert.assertTrue(vendorPages.categoriesButton.isDisplayed());

//        Categories webelementinden istedigin bir urunu secilir
        ReusableMethods.click(vendorPages.catagoriesToplamClikButton);
        ReusableMethods.bekle(3);

//        Categories secilebildigi dogrulanir
        List<WebElement> clickButonlari = Driver.getDriver().findElements((By.xpath("//input[@name='product_cats[]']")));

        for (int i = 0; i < clickButonlari.size(); i++) {
            if (clickButonlari.get(i).isDisplayed()){
                ReusableMethods.click(clickButonlari.get(i));
            }
        }
    }

    @Test
    public void tc05() {


//    Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

//    Sign in butonuna tiklanir

        vendorPages.signinButton.click();
//    Acilan pencerede Username or email address ve Password alanina gecerli datalar girilerek vendor olarak giris yapilir
        vendorPages.email.sendKeys(ConfigReader.getProperty("allovercommerceEmail"),Keys.TAB);
        vendorPages.password.sendKeys(ConfigReader.getProperty("allovercommercePassword"),Keys.ENTER);
        vendorPages.enterButton.click();

//    My Account yazisina tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        vendorPages.myAccountButton.click();

//    Acilan sayfada Store Manager butonuna tiklanir
        ReusableMethods.bekle(2);

        vendorPages.storeManagerButton.click();
//    Acilan sayfada products button tiklanir
        ReusableMethods.bekle(2);
        vendorPages.productsButton.click();

//    Acilan sayfada Add New butonuna tiklanir
        ReusableMethods.bekle(2);
        vendorPages.addNewButton.click();
        ReusableMethods.bekle(2);

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

//        Acilan sayfada Categories alaninda Add new category yazisina tiklanir
        ReusableMethods.scroll(vendorPages.addNewCategoryButton);
        ReusableMethods.click(vendorPages.addNewCategoryButton);
        ReusableMethods.bekle(2);
//        Category Name alanina gecerli bir data girilir

        vendorPages.categoryNameBox.sendKeys(faker.color().name());
        ReusableMethods.bekle(2);

        ReusableMethods.scroll(vendorPages.productsButton);

        //Parent categoryden bir category sec
        ReusableMethods.ddmIndex(vendorPages.parentCategoryDDM,0);
        ReusableMethods.bekle(2);

//        ADD butonuna tiklanir
        vendorPages.ADDButton.click();

//        Yeni Categories eklenebildigi dogrulanir
        Assert.assertTrue(vendorPages.yeniEklenen.isDisplayed());
    }

    @Test
    public void tc06() {

//    Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

//    Sign in butonuna tiklanir
        vendorPages.signinButton.click();

//    Acilan pencerede Username or email address ve Password alanina gecerli datalar girilerek vendor olarak giris yapilir
        vendorPages.email.sendKeys(ConfigReader.getProperty("allovercommerceEmail"),Keys.TAB);
        vendorPages.password.sendKeys(ConfigReader.getProperty("allovercommercePassword"),Keys.ENTER);
        vendorPages.enterButton.click();

//    My Account yazisina tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        vendorPages.myAccountButton.click();

//    Acilan sayfada Store Manager butonuna tiklanir
        ReusableMethods.bekle(2);

        vendorPages.storeManagerButton.click();
//    Acilan sayfada products button tiklanir
        ReusableMethods.bekle(2);
        vendorPages.productsButton.click();

//    Acilan sayfada Add New butonuna tiklanir
        ReusableMethods.bekle(2);
        vendorPages.addNewButton.click();
        ReusableMethods.bekle(2);

//        Acilan sayfada Product brands alanindan ilgili kutucuk tiklanrak isaretlenir
        ReusableMethods.click(vendorPages.productBrandsClickButton);

//        Product brands secilebildigi dogrulanir
        List<WebElement> list=Driver.getDriver().findElements(By.xpath("//input[@name='product_custom_taxonomies[product_brand][]']"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isDisplayed()){
                ReusableMethods.click(list.get(i));
            }

        }

    }

    @Test
    public void tc07() {

//    Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

//    Sign in butonuna tiklanir
        vendorPages.signinButton.click();

//    Acilan pencerede Username or email address ve Password alanina gecerli datalar girilerek vendor olarak giris yapilir
        vendorPages.email.sendKeys(ConfigReader.getProperty("allovercommerceEmail"),Keys.TAB);
        vendorPages.password.sendKeys(ConfigReader.getProperty("allovercommercePassword"),Keys.ENTER);
        vendorPages.enterButton.click();

//    My Account yazisina tiklanir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        vendorPages.myAccountButton.click();

//    Acilan sayfada Store Manager butonuna tiklanir
        ReusableMethods.bekle(2);

        vendorPages.storeManagerButton.click();
//    Acilan sayfada products button tiklanir
        ReusableMethods.bekle(2);
        vendorPages.productsButton.click();

//    Acilan sayfada Add New butonuna tiklanir
        ReusableMethods.bekle(2);
        vendorPages.addNewButton.click();


//        Acilan sayfada Product brands alaninda Add new Product brands yazisina tiklanir
        ReusableMethods.scroll(vendorPages.addNewProductBrandsButton);
        ReusableMethods.click(vendorPages.addNewProductBrandsButton);
        ReusableMethods.bekle(2);

//        Product brands Name alanina gecerli bir data girilir
        vendorPages.productBrandsNameBox.sendKeys(faker.country().name());
        ReusableMethods.bekle(2);

//        Parent taxonomiy'den birini secilebilmeli
        ReusableMethods.ddmIndex(vendorPages.parentTaxonomyDDM,4);
        ReusableMethods.bekle(2);

//        ADD butonuna tiklanir
        ReusableMethods.click(vendorPages.productBrandAddButton);
        ReusableMethods.bekle(2);

//        Yeni Product brands eklenebildigi dogrulanir
        Assert.assertTrue(vendorPages.productBrandsEklenenUrun.isDisplayed());


    }
}






