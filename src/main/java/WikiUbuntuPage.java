import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiUbuntuPage {

    private static WebDriver driver;

    // Декларация поиска кнопки titleSearch
    @FindBy(id = "titlesearch")
    private WebElement titleSearchButton;
    // Декларация поиска поля ввода текста searchInput
    @FindBy(id = "searchinput")
    private WebElement searchInput;
    // Подготовленный селектор для поиска гиперссылки с адресом /FindPage
    private By findPageHrefCss =
        new By.ByCssSelector(".searchresults > ol > li > a[href='/FindPage']");

    public WikiUbuntuPage(WebDriver driver) {
        this.driver = driver;
        // запуск контейнера, который найдет все аннотации @FindBy
        // и выполнит инициализации полей, если элементы найдены
        // или выбросит исключение, если хотя бы один не найден
        PageFactory.initElements(driver, this);
    }
    // метод ввода текста "find" в поле ввода searchInput
    public void fillInSearchInput() {
        searchInput.sendKeys("find");
    }
    // выполнение клика по кнопке titleSearchButton
    public void performTitleSearchButtonClick() {
        titleSearchButton.click();
    }
    // динамическая проверка присутствия на веб-странице
    // гиперссылки findPageHref из результатов поиска по заголовку "find"
    public boolean isFindPageHrefPresent() {
        return !driver.findElements(findPageHrefCss).isEmpty();
    }
}
