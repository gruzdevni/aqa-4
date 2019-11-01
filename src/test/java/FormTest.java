import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FormTest {

    @Test
    void successfulFormFilling(){
        open("http://localhost:9999");
        List <SelenideElement> fields = $$("[class='input__control']");
        fields.get(0).setValue("Владивосток");
        field1Clear(fields);
        fields.get(1).setValue("05.11.2019");
        fields.get(2).setValue("Иван Петров-Водкин");
        fields.get(3).setValue("+79012345678");
        $("[data-test-id='agreement']").click();
        $$("button").find(Condition.matchText("брон")).click();
        $(withText("Успешно")).waitUntil(Condition.visible, 15000);
    }

    private void field1Clear(List<SelenideElement> fields) {
        fields.get(1).sendKeys(Keys.CONTROL + "a");
        fields.get(1).sendKeys(Keys.DELETE);
    }
}
