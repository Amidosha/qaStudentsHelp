package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class Credentials {

    @Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({
            "system:properties",
            "classpath:config/credentials.properties"
    })

    public interface CredentialManager extends Config {
        @Config.Key("login")
        String getLogin();

        @Config.Key("password")
        String getPassword();
    }

    public static CredentialManager getCredConfig() {
        return ConfigFactory.create(CredentialManager.class, System.getProperties());
    }
}