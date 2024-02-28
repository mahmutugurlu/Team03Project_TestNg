package allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sule {
    public Sule() {

    }
    @FindBy(xpath = "//button[@data-taxonomy='product_brand']")
    public WebElement locate;
}
