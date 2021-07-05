package tests;

import config_g.Creds;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ByOwnerTests {
    @Test
    @Tag("owner_tag")
    void readFromPropsTest(){
        String login = Creds.my_creds_factory.login();
        String password = Creds.my_creds_factory.password();

        System.out.println(login);
        System.out.println(password);

        String message = String.format("Popytka logina pod %s s parolem %s", login, password);

        System.out.println(message);
    }
}
