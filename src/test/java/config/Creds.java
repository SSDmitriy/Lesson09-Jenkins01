package config;

import org.aeonbits.owner.ConfigFactory;

public class Creds {

    public static CredsConfig myCredsFactory = ConfigFactory.create(
            CredsConfig.class, System.getProperties()
    );
}
