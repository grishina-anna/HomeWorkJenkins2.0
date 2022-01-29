package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.browser;

public class SystemPropertiesTests {
//        System.getProperties("key"); - системные хранилища в памяти проекта
//        System.setProperties("key", "value"); - системные хранилища в памяти проекта
    @Test
    void someTest1() {
        String someValue = System.getProperty("someKey");
        System.out.println(someValue); //null
    }

        @Test
        void someTest2(){
            System.setProperty ("someKey", "red value");
            String someValue = System.getProperty("someKey");
            System.out.println(someValue); //red value
        }

    @Test
    void someTest3(){
        String someValue = System.getProperty("someKey", "blue value"); //если по someKey ничего не нашлось, то ему установят дефолтное значение
        System.out.println(someValue); //red value
    }

    @Test
    @Tag("properties")
    void someTest4() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    Test
    @Tag("properties")
    void someTest5() {
        String browser = System.getProperty("browser","chrome"); //по дефолту будет хром
        String version = System.getProperty("version","91");
        String browserSize = System.getProperty("browserSize","300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }

    }

}
