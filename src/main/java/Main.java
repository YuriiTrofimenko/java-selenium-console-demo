import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Java Selenium!");
        // подключение драйвера, расположенного в каталоге driver
        // в корне проекта (https://github.com/mozilla/geckodriver/releases)
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        // создаем экземпляр реализации интерфейса взаимодействия с веб-страницами
        // в браузере Firefox (запускается браузер)
        WebDriver driver = new FirefoxDriver();
        // неявные ожидания реакции браузера на все последующие действия:
        // если через 5 секунд реакции не будет - получим исключение,
        // а если реакция будет ранее 5 секунд - ожидание прерывается
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // разворачивается окно браузера
        driver.manage().window().maximize();
        // переход по указанному адресу
        driver.get("https://wiki.ubuntu.com/");
        // создание экземпляра класса, соответствующего главной странице
        WikiUbuntuPage wikiUbuntuPage =
                new WikiUbuntuPage(driver);
        // присутствует ли искомая гиперссылка из результатов поиска?
        System.out.println(wikiUbuntuPage.isFindPageHrefPresent());
        // ввод поисковой строки
        wikiUbuntuPage.fillInSearchInput();
        // клик кнопки поиска
        wikiUbuntuPage.performTitleSearchButtonClick();
        // присутствует ли искомая гиперссылка из результатов поиска теперь?
        System.out.println(wikiUbuntuPage.isFindPageHrefPresent());
        // закрытие браузера
        driver.close();
    }
}
