package config;

import java.util.Optional;

public class ConfigVariables {
    public static String getHost() {
        return Optional.ofNullable(System.getenv("host"))
                .orElse((String) ApplicationProperties.getInstance().get("host"));
    }

    public static String getBasePath() {
        return Optional.ofNullable(System.getenv("basePath"))
                .orElse((String) ApplicationProperties.getInstance()
                        .get("basePath"));
    }
}
