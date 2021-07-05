package tests;

//класс для демонстрации работы с системными пропертями
//можно настроить параметры по умолчанию,
// которые также возможно изменять извне (через Jenkins)

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {

    @Test
    void methInPropTest(){
        System.setProperty("my_props", "prop-01");
        String value = System.getProperty("my_props");

        System.out.println(value);
    }

    @Test
    void methTwoInPropTest(){
        System.setProperty("my_props", "prop-01");
        String value = System.getProperty("my_props", "default-prop");

        System.out.println(value);
    }

    @Test
    void methReadFromGradle(){
        String value = System.getProperty("browser", "default-browser");
        System.out.println(value);
    }

    @Test
    //если в build.gradle прописать  includeTags "terminal_tag"
    //то будут запускаться только тесты с аннотацией @Tag и значением этого тега
    @Tag("terminal_tag")
    void methReadFromTerminal(){
        //ссохранить в String данные из System.getProperty
        //если в gradle пропертя не будет задана, то возьмётся значение, заданное здесь по умолчанию
        String browser = System.getProperty("browser_type", "default_brow");
        String value = System.getProperty("browser_version", "default_version");

        System.out.println("prop_browser: " + browser);
        System.out.println("prop_version: " + value);
    }
}
