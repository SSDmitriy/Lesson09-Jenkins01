package tests;

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
    @Tag("terminal_tag")
    void methReadFromTerminal(){
        String value = System.getProperty("version", "77");
        System.out.println(value);
    }
}
