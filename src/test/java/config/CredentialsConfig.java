package config;

import org.aeonbits.owner.Config;
@Config.Sources("Classpath:config/credentials.properties")

public interface CredentialsConfig extends Config {
    String login();
    String password();
}
