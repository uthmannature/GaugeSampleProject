import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class GoogleTest {

    @Step("Navigate to <https://www.google.co.uk>")
    public void navigateTo(String url) throws InterruptedException {
        Driver.driver.get(url);
        Thread.sleep(2000);
    }

    @Step("Enter query <query> in the search box and submit")
    public void enterQuery(String query) throws InterruptedException {
        WebElement searchBox = Driver.driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
        Thread.sleep(2000);
    }

    @Step("The knowledge graph box should show <Jupiter> as result")
    public void verifySearchResult(String resultString) {
        WebElement result = Driver.driver.findElement(By.className("_eF"));
        assertEquals(resultString, result.getText());
    }
}
