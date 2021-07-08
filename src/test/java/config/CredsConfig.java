package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/my_creds.properties"
})

public interface CredsConfig extends Config {

    @Key("myLogin")
    String login();

    @Key("myPass")
    String password();
}
