package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VendorPages {
    public VendorPages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


















    // Burhanettin Aydin 31-81


















































    //Ali Iz 82-132


















































    //Mehmet Okay 133-183


















































    //Sevin Acar 184-234


















































    //Mahmut Ugurlu 235-285


















































    //Sule Yüksel 286-450
    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement signinButton;

    @FindBy(css = "#username")
    public WebElement email;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement enterButton;
    @FindBy(css = "#menu-item-1079")
    public WebElement myAccountButton;

    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerButton;
    @FindBy(xpath = "//a[@href='https://allovercommerce.com/store-manager/products/']")
    public WebElement productsButton;

    @FindBy(id = "add_new_product_dashboard")
    public WebElement addNewButton;

    @FindBy(css = "#product_type")
    public WebElement productTypeDDM;

    @FindBy(id = "featured_img_display")
    public WebElement imageButton;

    @FindBy(id = "__wp-uploader-id-1")
    public WebElement selectFilesButton;
    @FindBy(css = ".button.media-button.button-primary.button-large.media-button-select")
    public WebElement selectButton;
    @FindBy(xpath = "//input[@id='variations_image_0_remove_button']")
    public WebElement xButton;
    @FindBy(id = "pro_title") //TC03 locate'leri#username
    public WebElement productTitleMetinAlani;
    @FindBy(xpath = "//*[@data-id='excerpt']")
    public WebElement shortDescriptionMetinAlani;
    @FindBy(xpath = "//*[@data-id='description']")
    public WebElement descriptionMetinAlani;
    @FindBy(xpath = "(//p[@class='wcfm_title wcfm_full_ele'])[1]") //TC04 locate'leri
    public WebElement categoriesButton;
    @FindBy(xpath = "//input[@name='product_cats[]']")
    public WebElement  catagoriesToplamClikButton;
    @FindBy(xpath = "//p[.='+Add new category']") //TC05 locate'leri
    public WebElement addNewCategoryButton;
    @FindBy(id = "wcfm_new_cat")
    public WebElement categoryNameBox;
    @FindBy(id = "wcfm_new_parent_cat")
    public WebElement parentCategoryDDM;
    @FindBy(xpath = "//button[@data-taxonomy='product_cat']")
    public WebElement ADDButton;

    @FindBy(xpath = "//input[@name='product_cats[]']")
    public WebElement yeniEklenen;


    @FindBy(xpath = "//input[@class='wcfm-checkbox checklist_type_product_brand ']") //TC06 locate'leri
    public WebElement productBrandsClickButton ;

    @FindBy(xpath = "//input[@name='product_custom_taxonomies[product_brand][]']")
    public WebElement productBrandsList ;
    @FindBy(xpath = "//p[.='+Add new Product brands']") //TC07 locate'leri
    public WebElement addNewProductBrandsButton ;

    @FindBy(id = "wcfm_new_product_brand")
    public WebElement productBrandsNameBox;
    @FindBy(id = "wcfm_new_parent_product_brand")
    public WebElement parentTaxonomyDDM;

    @FindBy(xpath = "(//input[@name='product_custom_taxonomies[product_brand][]'])[1]")
    public WebElement productBrandsEklenenUrun;

    @FindBy(xpath = "//button[@data-taxonomy='product_brand']")
    public WebElement productBrandAddButton;
























































































    //Beytullah Cakir 450-500




















































}
