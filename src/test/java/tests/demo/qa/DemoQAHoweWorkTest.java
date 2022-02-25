package tests.demo.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class DemoQAHoweWorkTest extends TestBase {

     @Test
     public void FillFormTest() {
         open("/automation-practice-form");
         $("#firstName").setValue("Anna");
         $("#lastName").setValue("Grishina");
         $("#userEmail").setValue("aaa@aa.aa");
         $("[for='gender-radio-1']").click();
         $("#userNumber").setValue("8912345678");
         $("#dateOfBirthInput").click();
         $(".react-datepicker__month-select").click();
         $(".react-datepicker__month-select").selectOption("July");
         $(".react-datepicker__year-select").selectOption("1990");
         $(byText("29")).click();
         $("#subjectsInput").setValue("Math").pressEnter();
         $("[for*='hobbies-checkbox-2']").click();
      //   File file = new File("src/test/resources/1.png");
       //  $("#uploadPicture").uploadFile(file);
         $("#currentAddress").setValue("Krasnaya, 1-1-11");
         $("#state").scrollTo().click();
         $("#stateCity-wrapper").$(byText("NCR")).click();
         $("#city").click();
         $("#stateCity-wrapper").$(byText("Noida")).click();
         $("#submit").scrollIntoView(true).click();

         $("[class*=modal-content]").should(visible);
         $(byText("Thanks for submitting the form")).should(appear);
         $(".table-responsive").shouldHave(
                 text("Anna"),
                 text("Grishina"),
                 text("aaa@aa.aa"),
                 text("8912345678"),
                 text("29 July,1990"),
                 text("Krasnaya, 1-1-11"),
                 text("NCR Noida"));
     }
}
