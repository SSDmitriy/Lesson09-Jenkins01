package config_g;

//импортировать библиотеку owner
import org.aeonbits.owner.Config;

//просто прописать эти аннотации
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/my_creds.properties"
})

//интерфейс наследуется от Config из библиотеки owner
public interface CredsConfig extends Config {

    @Key("keylogin")
    String login();

    @Key("keypass")
    String password();

}
