package config_g;

import org.aeonbits.owner.ConfigFactory;

public class Creds {

    public static CredsConfig my_creds_factory = ConfigFactory.create(
            CredsConfig.class, System.getProperties()
    );

}
